package service;

import dao.EmployeeDAO;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ETLService {

    private final EmployeeDAO dao;

    @Value("${etl.invalid.path}")
    private String invalidCsvPath;

    @Autowired
    public ETLService(EmployeeDAO dao) {
        this.dao = dao;
    }

    public void process(List<Employee> employees) throws Exception {
        try (FileWriter invalidWriter = new FileWriter(invalidCsvPath)) {
            for (Employee emp : employees) {
                if (ValidationService.isValid(emp)) {
                    try {
                        dao.insert(emp);
                        System.out.println("inserted id: " + emp.getId());
                    } catch (Exception e) {
                        if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
                            System.out.println("duplicate id skipped: " + emp.getId());
                        } else {
                            System.out.println("error for id: " + emp.getId());
                            e.printStackTrace();
                        }
                    }
                } else {
                    invalidWriter.write(
                            emp.getId() + "," + emp.getName() + "," + emp.getEmail() + "," + emp.getSalary() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dbToDbProcess() throws Exception {
        List<Employee> employees = dao.fetchFromSource();
        System.out.println("fetched employees: " + employees.size());
        for (Employee emp : employees) {
            if (ValidationService.isValid(emp)) {
                try {
                    dao.insertToTarget(emp);
                    System.out.println("inserted id: " + emp.getId());
                } catch (Exception e) {
                    if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
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
