public record Employee(String id, double salary) {
    public Employee {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
    }

    public boolean isHighEarner() {
        return salary > 100000;
    }

    public static void main(String[] args) {
        Employee emp = new Employee("E101", 100000);
        System.out.println(emp.id());
        System.out.println(emp.salary());
        System.out.println(emp.isHighEarner());
    }
}
