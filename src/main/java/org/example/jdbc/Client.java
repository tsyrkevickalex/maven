package org.example.jdbc;

import java.util.List;

public class Client {
    public static void main(String[] args) {
//        OfficesDAO officesDAO = new OfficesDAO();
//        Office office = officesDAO.getOfficeById("2");
//        System.out.println(office);
//
//        List<Office> all = officesDAO.getAllOffices();
//
//        System.out.println("SIZE: " + all.size());
//        for (Office o: all
//             ) {
//            System.out.println(o.getCountry() + " : " + o.getCity());
//        }
//
//        List<Office> all2 = officesDAO.getAllOfficesInCountry("USA");
//        System.out.println("SIZE : " + all2.size());
//        for (Office o: all2
//        ) {
//            System.out.println(o.getCountry() + " : " + o.getCity());
//        }
//
//        List<Office> all3 = officesDAO.getAllOfficesByNumber("+81 33 224 5000");
//        System.out.println("SIZE : " + all3.size());
//        System.out.println(all3);
//
//        Office officeNew = new OfficesDAO().getOfficeById("11");
//        officeNew.setAddressLine2("floor #3");
//        officeNew.setPhone("+948509348");
//
//        officesDAO.updateOffice(officeNew);
//
//        officesDAO.deleteOfficeById("20");
//
//        Office office1 = new Office("100","100","100","100","100","100","100","100","100");
//        officesDAO.createOffice(office1);
//
//        Office officeFromDB = officesDAO.getOfficeById("100");
//        System.out.println(office1.equals(officeFromDB));

        EmployeesDAO employeesDAO = new EmployeesDAO();
        Employee empl = employeesDAO.getEmployeeById(1188);
        System.out.println(empl);

    }
}
