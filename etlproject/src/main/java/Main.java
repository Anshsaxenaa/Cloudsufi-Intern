import util.CsvReader;
import service.ETLService;
import model.Employee;
import java.util.*;
import dao.EmployeeDAO;
import util.Logger;
import util.JsonReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ETLService etl = new ETLService();
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            Logger.info("Application Started");
            System.out.println("-------Console Menu------");
            System.out.println("1. CSV -> DB");
            System.out.println("2. JSON -> DB");
            System.out.println("3. DB -> DB transfer");
            System.out.println("4. Insert Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Update Employee");
            System.out.println("7. Delete Employee");
            System.out.println("8. Exit");
            Logger.info("Enter your choice: ");
            int choice = sc.nextInt();
            Logger.info("Choice: " + choice);
            switch (choice) {
                case 1:
                    Logger.info("CSV to DB Process Started");
                    List<Employee> csvData = CsvReader.readEmployees(
                            "C:\\Users\\ansh.saxena_cloudsuf\\Desktop\\etlproject\\src\\data\\employees.csv");
                    etl.process(csvData);
                    Logger.info("CSV to DB Process Completed");
                    break;
                case 2:
                    List<Employee> jsonData = JsonReader.readJson(
                            "C:\\Users\\ansh.saxena_cloudsuf\\Desktop\\etlproject\\src\\data\\employees.json");
                    etl.process(jsonData);
                    break;
                case 3:
                    etl.dbToDbProcess();
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.next();
                    System.out.print("Enter Employee Email: ");
                    String email = sc.next();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    Employee emp = new Employee(id, name, email, salary);
                    if (service.ValidationService.isValid(emp)) {
                        dao.insert(emp);
                        System.out.println("Employee inserted successfully");
                    } else {
                        System.out.println("Invalid Employee");
                    }
                    break;
                case 5:
                    List<Employee> list = dao.getAllEmployees();

                    System.out.println("All Employees list:");
                    for (Employee e : list) {
                        System.out.println(
                                e.getId() + "|" + e.getName() + "|" + e.getEmail() + "|" + e.getSalary());
                    }
                    break;
                case 6:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = sc.next();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.next();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    dao.update(new Employee(updateId, newName, newEmail, newSalary));
                    System.out.println("Employee updated successfully");
                    break;
                case 7:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteID = sc.nextInt();
                    dao.delete(deleteID);
                    System.out.println("Employee deleted successfully");
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }
}