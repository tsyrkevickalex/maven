package org.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficesDAO {

    public Office getOfficeById(String officeCode){
        Office office = null;

        Connection conn = null;

        try {
            conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From classicmodels.offices Where officeCode = '" +  officeCode + "'");
            //может быть один или ноль полей
            if (rs.next())
                office = extractOffice(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtils.release(conn);
        }


        return office;
    }

    public List<Office> getAllOffices(){
        List<Office> offices = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From classicmodels.offices");
            //может быть много, один или ноль полей
            while (rs.next()){
                Office office = new Office();
                office.setOfficeCode(rs.getString(1));
                office.setCity(rs.getString(2));
                office.setPhone(rs.getString("phone"));
                office.setAddressLine1(rs.getString("addressLine1"));
                office.setAddressLine2(rs.getString("addressLine2"));
                office.setState(rs.getString("state"));
                office.setCountry(rs.getString("country"));
                office.setPostalCode(rs.getString("postalCode"));
                office.setTerritory(rs.getString("territory"));

                offices.add(office);
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return offices;
    }

    public List<Office> getAllOfficesInCountry(String country){
        List<Office> offices = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From classicmodels.offices Where country = '" + country +"'");
            //может быть много, один или ноль полей
            while (rs.next()){
                Office office = new Office();
                office.setOfficeCode(rs.getString(1));
                office.setCity(rs.getString(2));
                office.setPhone(rs.getString("phone"));
                office.setAddressLine1(rs.getString("addressLine1"));
                office.setAddressLine2(rs.getString("addressLine2"));
                office.setState(rs.getString("state"));
                office.setCountry(rs.getString("country"));
                office.setPostalCode(rs.getString("postalCode"));
                office.setTerritory(rs.getString("territory"));

                offices.add(office);
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return offices;
    }

    public List<Office> getAllOfficesByNumber(String number){
        List<Office> offices = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From classicmodels.offices Where phone = '" + number + "'");
            //может быть много, один или ноль полей
            while (rs.next()){
                Office office = new Office();
                office.setOfficeCode(rs.getString(1));
                office.setCity(rs.getString(2));
                office.setPhone(rs.getString("phone"));
                office.setAddressLine1(rs.getString("addressLine1"));
                office.setAddressLine2(rs.getString("addressLine2"));
                office.setState(rs.getString("state"));
                office.setCountry(rs.getString("country"));
                office.setPostalCode(rs.getString("postalCode"));
                office.setTerritory(rs.getString("territory"));

                offices.add(office);
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return offices;
    }

    private Office extractOffice(ResultSet rs) throws SQLException {
        Office office = new Office();
        office.setOfficeCode(rs.getString(1));
        office.setCity(rs.getString(2));
        office.setPhone(rs.getString("phone"));
        office.setAddressLine1(rs.getString("addressLine1"));
        office.setAddressLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTerritory(rs.getString("territory"));

        return office;
    }

    public void updateOffice(Office office){

        String updateSQL = "UPDATE `classicmodels`.`offices` " +
                "SET `city` = '"+ office.getCity()+"', `phone` = '"+ office.getPhone()+"', " +
                "`addressLine1` = '"+ office.getAddressLine1()+"', `addressLine2` = '"+office.getAddressLine2() +"', " +
                "`state` = '"+ office.getState()+"', `country` = '"+office.getCountry()+"', `postalCode` = '"+ office.getPostalCode()+"', `territory` = '"+ office.getTerritory()+"' " +
                "WHERE `officeCode` = '"+office.getOfficeCode()+"'";

        try(Connection conn = DBUtils.getConnection()){
            Statement stmt = conn.createStatement();
            int result =  stmt.executeUpdate(updateSQL);
            if(result == 1){
                System.out.println("Office with Code = '"+ office.getOfficeCode()+"' update SuccesFully");
            }else System.out.println("Office NOT updated with Code = '"+ office.getOfficeCode()+"'");
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void deleteOfficeById(String officeCode){
        String sql = "DELETE FROM classicmodels.offices WHERE officeCode = '"+ officeCode+"'";

        try(Connection conn = DBUtils.getConnection()){
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if(result == 1){
                System.out.println("Office with Code = '"+ officeCode+"' delete SuccesFully");
            }else System.out.println("Office NOT deleted with Code = '" + officeCode +"'");
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void createOffice(Office office){
        String sql = "INSERT INTO classicmodels.offices (officeCode, city, phone, addressLine1, addressLine2, state , country, postalCode, territory) " +
                "VALUES ('"+office.getOfficeCode()+"', '"+office.getCity()+"', '"+office.getPhone()+"', '"
                +office.getAddressLine1()+"', '"+office.getAddressLine2()+"', '"+office.getCountry()+"', '"
                +office.getPostalCode()+"', '"+office.getTerritory()+"')";

        try(Connection conn = DBUtils.getConnection()){
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if(result == 1){
                System.out.println("Office with Code = '"+ office+"' create SuccesFully");
            }else System.out.println("Office NOT created with Code = '" + office +"'");

        }catch (SQLException sqlException){
            sqlException.printStackTrace();

        }


    }

}
