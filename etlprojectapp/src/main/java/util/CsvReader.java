package util;

import model.Employee;
import java.io.*;
import java.util.*;

public class CsvReader {
    public static List<Employee> readEmployees(String filename) throws Exception {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                Employee emp = new Employee(
                        Integer.parseInt(parts[0].trim()),
                        parts[1].trim(),
                        parts[2].trim(),
                        Double.parseDouble(parts[3].trim()));
                employees.add(emp);

            }
        }
        return employees;
    }
}
