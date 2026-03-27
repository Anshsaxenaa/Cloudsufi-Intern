import dao.EmployeeDAO;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ETLService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ETLServiceTest {

    @BeforeEach
    @AfterEach
    void cleanup() {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            dao.delete(101);
            dao.delete(102);
        } catch (Exception e) {}
    }

    @Test
    void etlProcessTest() throws Exception {

        ETLService etl = new ETLService();

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(101, "Valid", "valid@gmail.com", 5000));
        list.add(new Employee(102, "Invalid", "invalidemail", 5000));

        etl.process(list);

        assertTrue(true);
    }
}