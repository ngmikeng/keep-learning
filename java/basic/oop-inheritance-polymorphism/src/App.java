public class App {
    public static void main(String[] args) {
        System.out.println("*** OOP Inheritance & Polymorphism ***");

        Company company = new Company();
        System.out.println("*** Input list of employee: ");
        company.inputListEmployee();

        System.out.println("-------- List of employee --------");
        company.printListEmployee();
        System.out.println("----------------------------------");
        System.out.println("*** Total salary of employee: " + company.calculateTotalSalary());
        System.out.println("*** Info of employee has largest salary: ");
        Employee nv = company.findEmployeeLargestSalary();
        nv.printConsole();
    }
}
