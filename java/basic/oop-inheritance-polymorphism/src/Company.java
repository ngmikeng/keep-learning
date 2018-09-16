import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private ArrayList<Employee> listEmployee = new ArrayList();
    private int numberOfEmployee;

    public void inputListEmployee() {
        System.out.println("Input number of employee: ");
        Scanner scan = new Scanner(System.in);
        this.numberOfEmployee = scan.nextInt();
        Boolean isInvalid = true;
        while (isInvalid == true) {
            for (int i = 0; i < this.numberOfEmployee; i++) {
                System.out.println("Input type of employee (engineer|manager):");
                String employeeType = scan.next();
                Employee employee = new Employee();
                switch (employeeType) {
                    case "engineer":
                        employee = new Engineer();
                        isInvalid = false;
                        break;
                    case "manager":
                        employee = new Manager();
                        isInvalid = false;
                        break;
                    default:
                        System.out.println("Invalid value!");
                        isInvalid = true;
                        break;
                }
                if (isInvalid == false) {
                    employee.inputConsole();
                    this.listEmployee.add(employee);
                }
            }
        }
    }

    public void printListEmployee() {
        for (int i = 0; i < this.listEmployee.size(); i++) {
            this.listEmployee.get(i).printConsole();
            System.out.println();
        }
    }

    public float calculateTotalSalary() {
        float sumSalary = 0;
        for (int i = 0; i < this.listEmployee.size(); i++) {
            sumSalary = sumSalary + this.listEmployee.get(i).calculateSalary();
        }

        return sumSalary;
    }

    public Employee findEmployeeLargestSalary() {
        Employee ep = new Employee();
        ep = this.listEmployee.get(0);
        for (int i = 0; i < this.listEmployee.size(); i++) {
            if (this.listEmployee.get(i).calculateSalary() > ep.calculateSalary()) {
                ep = this.listEmployee.get(i);
            }
        }

        return ep;
    }
}
