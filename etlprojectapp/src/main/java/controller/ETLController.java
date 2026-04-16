package controller;

import dao.EmployeeDAO;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import service.ETLService;
import util.CsvReader;
import util.JsonReader;
import util.Logger;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ETLController {

    private final ETLService etlService;
    private final EmployeeDAO employeeDAO;
    Logger logger;

    @Value("${etl.csv.path}")
    private String csvPath;

    @Value("${etl.json.path}")
    private String jsonPath;

    @Autowired
    public ETLController(ETLService etlService, EmployeeDAO employeeDAO) {
        this.etlService = etlService;
        this.employeeDAO = employeeDAO;
    }

    // ETL Endpoints

    @PostMapping("/etl/csv")
    public ResponseEntity<String> processCsv() {

        try {
            List<Employee> csvData = CsvReader.readEmployees(csvPath);
            etlService.process(csvData);
            return ResponseEntity.ok("CSV to DB Process Completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error parsing CSV: " + e.getMessage());
        }
    }

    @PostMapping("/etl/json")
    public ResponseEntity<String> processJson() {
        try {
            List<Employee> jsonData = JsonReader.readJson(jsonPath);
            etlService.process(jsonData);
            return ResponseEntity.ok("JSON to DB Process Completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error parsing JSON: " + e.getMessage());
        }
    }

    @PostMapping("/etl/db-to-db")
    public ResponseEntity<String> processDbToDb() {
        try {
            etlService.dbToDbProcess();
            return ResponseEntity.ok("DB to DB ETL process completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error in DB -> DB transfer: " + e.getMessage());
        }
    }

    // CRUD Endpoints

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Processing etl.csv");
        try {
            return ResponseEntity.ok(employeeDAO.getAllEmployees());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        if (service.ValidationService.isValid(employee)) {
            try {
                employeeDAO.insert(employee);
                return ResponseEntity.ok("Employee inserted successfully");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Failed to insert employee: " + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Invalid employee data");
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employee.setId(id);
        if (service.ValidationService.isValid(employee)) {
            try {
                employeeDAO.update(employee);
                return ResponseEntity.ok("Employee updated successfully");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Failed to update employee: " + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Invalid employee data");
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        try {
            employeeDAO.delete(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete employee: " + e.getMessage());
        }
    }
}
