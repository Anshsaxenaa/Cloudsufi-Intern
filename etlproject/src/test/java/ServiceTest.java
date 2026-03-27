import model.Employee;
import org.junit.jupiter.api.Test;
import service.ValidationService;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    void validEmployeeTest() {
        Employee emp = new Employee(1, "Ansh", "ansh@gmail.com", 5000);
        assertTrue(ValidationService.isValid(emp));
    }

    @Test
    void invalidEmailTest() {
        Employee emp = new Employee(2, "Test", "invalidemail", 5000);
        assertFalse(ValidationService.isValid(emp));
    }

    @Test
    void negativeSalaryTest() {
        Employee emp = new Employee(3, "Test", "test@gmail.com", -1000);
        assertFalse(ValidationService.isValid(emp));
    }

    @Test
    void nullNameTest() {
        Employee emp = new Employee(4, null, "test@gmail.com", 5000);
        assertFalse(ValidationService.isValid(emp));
    }
}
