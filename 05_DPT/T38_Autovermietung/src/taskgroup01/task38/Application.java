package taskgroup01.task38;

import taskgroup01.task38.command.CommandRent;
import taskgroup01.task38.command.CommandReturn;
import taskgroup01.task38.command.ICommand;

import java.util.Scanner;

public class Application {

    Repository repo;
    Customer customer;

    public Application() {
        repo = new Repository();
        customer = new Customer("CLI User");

        //example data
        rentVehicle("1");
        rentVehicle("2");
        rentVehicle("2");
        rentVehicle("4");
        rentVehicle("4");
        rentVehicle("4");
    }

    private void rentVehicle(String type) {
        int t = Integer.parseInt(type);
        ICommand rent = new CommandRent(customer, t, repo);
        rent.execute();
    }

    private void returnVehicle(String plate) {
        ICommand ret = new CommandReturn(customer, plate, repo);
        ret.execute();
    }

    public static void main(String... args) {
        Application app = new Application();
        System.out.println("Commands: RENT <type (number)>, RETURN <id>, EXIT");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextLine()) {
                continue;
            }
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.startsWith("exit")) {
                break;
            }
            if (!input.contains(" ")) {
                System.out.println("Please enter a valid command.");
                continue;
            }
            String parameter = input.substring(input.indexOf(' ')).trim();
            if (input.startsWith("rent ")) {
                app.rentVehicle(parameter);
            } else if (input.startsWith("return ")) {
                app.returnVehicle(parameter);
            }

        }


    }
}
