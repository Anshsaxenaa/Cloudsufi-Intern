package service;

import model.Employee;

public class ValidationService {
    public static boolean isValid(Employee emp) {
        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            System.out.println("Invalid name for id:" + emp.getId());
            return false;
        }

        String email = emp.getEmail();
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email for id:" + emp.getId());
            return false;
        }

        if (emp.getSalary() < 0) {
            System.out.println("Invalid salary for id:" + emp.getId());
            return false;
        }

        return true;
    }

    public static boolean isValidSalary(Employee emp) {
        double salary = emp.getSalary();
        if (salary >= 0) {
            return true;
        }
        System.out.println("Invalid salary for id:" + emp.getId());
        return false;
    }
}
