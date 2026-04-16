package dao;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAO {

    private final JdbcTemplate primaryJdbcTemplate;
    private final JdbcTemplate sourceJdbcTemplate;
    private final JdbcTemplate targetJdbcTemplate;

    @Autowired
    public EmployeeDAO(
            @Qualifier("primaryJdbcTemplate") JdbcTemplate primaryJdbcTemplate,
            @Qualifier("sourceJdbcTemplate") JdbcTemplate sourceJdbcTemplate,
            @Qualifier("targetJdbcTemplate") JdbcTemplate targetJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
        this.sourceJdbcTemplate = sourceJdbcTemplate;
        this.targetJdbcTemplate = targetJdbcTemplate;
    }

    private final RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDouble("salary")
            );
        }
    };

    public void insert(Employee emp) {
        String sql = "INSERT INTO employees (id, name, email, salary) VALUES (?, ?, ?, ?)";
        primaryJdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getEmail(), emp.getSalary());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return primaryJdbcTemplate.query(sql, employeeRowMapper);
    }

    public List<Employee> fetchFromSource() {
        String sql = "SELECT * FROM employees";
        return sourceJdbcTemplate.query(sql, employeeRowMapper);
    }

    public void insertToTarget(Employee emp) {
        String sql = "INSERT INTO employees (id, name, email, salary) VALUES (?, ?, ?, ?)";
        targetJdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getEmail(), emp.getSalary());
    }

    public void update(Employee emp) {
        String sql = "UPDATE employees SET name = ?, email = ?, salary = ? WHERE id = ?";
        primaryJdbcTemplate.update(sql, emp.getName(), emp.getEmail(), emp.getSalary(), emp.getId());
    }

    public void delete(int deleteID) {
        String sql = "DELETE FROM employees WHERE id = ?";
        primaryJdbcTemplate.update(sql, deleteID);
    }
}
