import java.util.Scanner;

public class Engineer extends Employee {
    private short workdays;
    private long salaryPerDay;

    public Engineer() {
        super();
        this.workdays = 0;
        this.salaryPerDay = 200;
    }

    public Engineer(String id, String name, int yearBirth) {
        super(id, name, yearBirth);
    }

    public short getWorkdays() {
        return workdays;
    }

    public void setWorkdays(short workdays) {
        this.workdays = workdays;
    }

    public long getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(long salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    @Override
    public long calculateSalary() {
        return super.calculateSalary() + this.salaryPerDay * this.workdays;
    }

    @Override
    public void inputConsole() {
        super.inputConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input workdays: ");
        this.workdays = Short.parseShort(scanner.next());
    }

    @Override
    public void printConsole() {
        super.printConsole();
        System.out.println("Workdays: " + this.workdays);
    }
}
