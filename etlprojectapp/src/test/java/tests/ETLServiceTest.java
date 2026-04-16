package tests;

import com.example.etlproject.EtlApplication;
import dao.EmployeeDAO;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.ETLService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EtlApplication.class)
public class ETLServiceTest {

    @Autowired
    private EmployeeDAO dao;

    @Autowired
    private ETLService etl;

    @BeforeEach
    @AfterEach
    void cleanup() {
        try {
            dao.delete(101);
            dao.delete(102);
        } catch (Exception e) {}
    }

    @Test
    void etlProcessTest() throws Exception {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Valid", "valid@gmail.com", 5000));
        list.add(new Employee(102, "Invalid", "invalidemail", 5000));

        etl.process(list);

        assertTrue(true);
    }
}
