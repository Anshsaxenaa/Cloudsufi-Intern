import dao.EmployeeDAO;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDAOTest {

    EmployeeDAO dao = new EmployeeDAO();

    @BeforeEach
    @AfterEach
    void cleanup() {
        try { dao.delete(999); } catch (Exception e) {}
        try { dao.delete(998); } catch (Exception e) {}
        try { dao.delete(997); } catch (Exception e) {}
    }

    @Test
    void insertAndFetchTest() throws Exception {
        Employee emp = new Employee(999, "JUnit", "junit@gmail.com", 5000);

        dao.insert(emp);

        List<Employee> list = dao.getAllEmployees();

        boolean found = list.stream().anyMatch(e -> e.getId() == 999);

        assertTrue(found);

        dao.delete(999); // cleanup
    }

    @Test
    void updateTest() throws Exception {
        Employee emp = new Employee(998, "Old", "old@gmail.com", 4000);
        dao.insert(emp);

        dao.update(new Employee(998, "New", "new@gmail.com", 6000));

        List<Employee> list = dao.getAllEmployees();

        Employee updated = list.stream()
                .filter(e -> e.getId() == 998)
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals("New", updated.getName());

        dao.delete(998);
    }

    @Test
    void deleteTest() throws Exception {
        Employee emp = new Employee(997, "Delete", "del@gmail.com", 3000);
        dao.insert(emp);

        dao.delete(997);

        List<Employee> list = dao.getAllEmployees();

        boolean exists = list.stream().anyMatch(e -> e.getId() == 997);

        assertFalse(exists);
    }
}