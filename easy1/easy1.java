//BEFORE REFACTORING
/*public class easy1{
    class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
    
        void printPaySlip() {
            System.out.println("Employee: " + name + ", Salary: $" + salary);
        }
    
        void saveToDatabase() {
            System.out.println("Saving employee to database...");
        }
    }
    
}
 */

//AFTER REFACTORING

public class easy1{
    // Employee class now only holds data
class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// Responsible for printing payslips
class PaySlipPrinter {
    public void print(Employee employee) {
        System.out.println("Employee: " + employee.getName() + ", Salary: $" + employee.getSalary());
    }
}

// Abstract storage strategy to follow OCP
interface EmployeeStorage {
    void save(Employee employee);
}

// Implementation for database storage
class DatabaseStorage implements EmployeeStorage {
    @Override
    public void save(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}

// Implementation for file storage (New feature added without modifying Employee class)
class FileStorage implements EmployeeStorage {
    @Override
    public void save(Employee employee) {
        System.out.println("Saving employee to a file...");
    }
}

}