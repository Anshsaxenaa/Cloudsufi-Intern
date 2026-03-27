package dao;

import db.DBConnection;
import model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    public void insert(Employee emp) throws Exception {
        String sql = "INSERT INTO employees (id, name, email, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setDouble(4, emp.getSalary());
            pstmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary"));
                employees.add(emp);
            }
        }
        return employees;
    }

    public List<Employee> fetchFromSource() throws Exception {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getSourceConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary"));
                employees.add(emp);
            }
        }
        return employees;
    }

    public void insertToTarget(Employee emp) throws Exception {
        String sql = "INSERT INTO employees (id, name, email, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getTargetConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setDouble(4, emp.getSalary());
            pstmt.executeUpdate();
        }
    }

    public void update(Employee emp) throws Exception {
        String sql = "UPDATE employees SET name = ?, email = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getEmail());
            pstmt.setDouble(3, emp.getSalary());
            pstmt.setInt(4, emp.getId());
            pstmt.executeUpdate();
        }
    }

    public void delete(int deleteID) throws Exception {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deleteID);
            pstmt.executeUpdate();
        }
    }

}
