package service;

import dao.EmployeeDAO;
import model.Employee;
import java.util.*;
import java.io.*;

public class ETLService {
    public void process(List<Employee> employees) throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        FileWriter invalidWriter = new FileWriter(
                "C:\\Users\\ansh.saxena_cloudsuf\\Desktop\\etlproject\\src\\data\\invalid.csv");
        for (Employee emp : employees) {
            try {
                if (ValidationService.isValid(emp)) {
                    try {
                        dao.insert(emp);
                        System.out.println("inserted id: " + emp.getId());
                    } catch (Exception e) {
                        if (e.getMessage().contains("Duplicate entry")) {
                            System.out.println("duplicate id skipped: " + emp.getId());
                        } else {
                            System.out.println("error for id: " + emp.getId());
                            e.printStackTrace();
                        }
                    }
                } else {
                    invalidWriter
                            .write(emp.getId() + "," + emp.getName() + "," + emp.getEmail() + "," + emp.getSalary()
                                    + "\n");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        invalidWriter.close();

    }

    public void dbToDbProcess() throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.fetchFromSource();
        System.out.println("fetched employees: " + employees.size());
        for (Employee emp : employees) {
            if (ValidationService.isValid(emp)) {
                try {
                    dao.insertToTarget(emp);
                    System.out.println("inserted id: " + emp.getId());
                } catch (Exception e) {
                    if (e.getMessage().contains("Duplicate entry")) {
                        System.out.println("duplicate id skipped: " + emp.getId());
                    } else {
                        System.out.println("error for id: " + emp.getId());
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("DB -> DB ETL process completed");
    }
}
