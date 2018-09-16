import java.util.Scanner;

public class Manager extends Employee {
    private short ratioSalary;
    private long baseSalary;

    public Manager() {
        this.ratioSalary = 1;
        this.baseSalary = 5000;
    }

    public Manager(String id, String name, int yearBirth, short ratioSalary, long baseSalary) {
        super(id, name, yearBirth);
        this.ratioSalary = ratioSalary;
        this.baseSalary = baseSalary;
    }

    public short getRatioSalary() {
        return ratioSalary;
    }

    public void setRatioSalary(short ratioSalary) {
        this.ratioSalary = ratioSalary;
    }

    public long getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(long baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public long calculateSalary() {
        return super.calculateSalary() + this.ratioSalary * this.baseSalary;
    }

    @Override
    public void inputConsole() {
        super.inputConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ratio of salary: ");
        this.ratioSalary = Short.parseShort(scanner.next());
        System.out.println("Input base salary: ");
        this.baseSalary = Short.parseShort(scanner.next());
    }

    @Override
    public void printConsole() {
        super.printConsole();
        System.out.println("Ratio of salary: " + this.ratioSalary);
        System.out.println("Base salary: " + this.baseSalary);
    }
}
