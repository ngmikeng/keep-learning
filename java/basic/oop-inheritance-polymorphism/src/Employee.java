import java.util.Scanner;

public class Employee {
    private String id;
    private String name;
    private int yearBirth;

    public Employee() {
    }

    public Employee(String id, String name, int yearBirth) {
        this.id = id;
        this.name = name;
        this.yearBirth = yearBirth;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public long calculateSalary() {
        return 0;
    }

    public void inputConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID: ");
        this.id = scanner.next();
        System.out.println("Input Name: ");
        this.name = scanner.next();
        System.out.println("Input Year of birth: ");
        this.yearBirth = Integer.parseInt(scanner.next());
    }

    public void printConsole() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Year of birth: " + this.yearBirth);
        System.out.println("Luong: " + this.calculateSalary());
    }
}
