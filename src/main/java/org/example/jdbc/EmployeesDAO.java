package org.example.jdbc;

import java.sql.*;

public class EmployeesDAO {
    private OfficesDAO officesDAO = new OfficesDAO();

    public Employee getEmployeeById(int id){

        String select = "Select * From classicmodels.employees Where employeeNumber = ? ";
        Employee empl = null;
        try (Connection conn = DBUtils.getConnection();) {
            PreparedStatement pstmt = conn.prepareStatement(select);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                empl = new Employee();
                empl.setEmployeeNumber(id);
                empl.setEmail(rs.getString("email"));
                empl.setExtension(rs.getString("Extension"));
                empl.setFirstName(rs.getString("FirstName"));
                empl.setLastName(rs.getString("LastName"));
                empl.setJobTitle(rs.getString("JobTitle"));
                int reportsTo = rs.getInt("reportsTo");
                if(reportsTo !=0){
                Employee employee = getEmployeeById(reportsTo);
                empl.setReportsTo(employee);
                }else {
                    empl.setReportsTo(null);
                }
                String officeCode = rs.getString("officeCode");
                Office office = officesDAO.getOfficeById(officeCode);
                empl.setOffice(office);

            }
        }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return empl;
    }
}
