/**
 * Author : Vinh Pham.
 * Date: 13/09/2018.
 * Time : 10:02.
 */
public class Person {
    private String name = "Name";

    public void printAddress() {
        Address a = new Address();
        a.printInfo();
    }

    public class Address {
        private String street = "street";
        private String city = "city";

        public void printInfo() {
            System.out.println(name + ": " + street + " - " + city);
            Helpers.printMessage();
        }
    }

    public static class Helpers {
        private static String message = "This is a private message in Main.";

        public static void printMessage() {
            System.out.println(message);
        }
    }
}
