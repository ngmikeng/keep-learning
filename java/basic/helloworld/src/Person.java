import java.util.Scanner;

public class Person {
    private String name = "Name";
    private Address address = new Address();

    public void printAddress() {
        address.printInfo();
    }

    public void inputAddress() {
        address.inputInfo();
    }

    public void inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name: ");
        this.name = scanner.next();
    }

    public void printName() {
        System.out.println("Your name: " + Helpers.uppercaseFirstChar(this.name));
    }

    public class Address {
        private String street;
        private String city;

        public void printInfo() {
            System.out.println("Address: " + Helpers.uppercaseFirstChar(street) + " - " + Helpers.uppercaseFirstChar(city));
        }

        public void inputInfo() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input street: ");
            street = scanner.next();
            System.out.println("Input city: ");
            city = scanner.next();
        }
    }

    public static class Helpers {
        public static String uppercaseFirstChar(String name) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }
}
