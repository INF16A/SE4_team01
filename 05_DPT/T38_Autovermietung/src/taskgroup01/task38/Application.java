package taskgroup01.task38;

import taskgroup01.task38.command.CommandRent;
import taskgroup01.task38.command.ICommand;

import java.util.Scanner;

public class Application {

    Repository repo;
    Customer customer;

    public Application() {
        repo = new Repository();
        customer = new Customer("CLI User");
    }

    private void rentVehicle(String type) {
        int t = Integer.parseInt(type);
        ICommand rent = new CommandRent(customer, t, repo);
        rent.execute();
    }

    public static void main(String... args) {
        Application app = new Application();
        System.out.println("Commands: RENT <type (number)>, RETURN <id>, EXIT");
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            String[] cmd = scanner.nextLine().toLowerCase().split(" ");
            if (cmd.length >= 2) {
                if (cmd[0].contains("rent")) {
                    String type = cmd[1];
                    System.out.println("you chose RENT with type " + type);
                    app.rentVehicle(type);
                } else if (cmd[0].contains("return")) {
                    String id = cmd[1];
                    System.out.println("you chose RETURN with id " + id);
                } else {
                    System.out.println("unrecognized command");
                }
            } else if (cmd[0].contains("exit")) {
                running = false;
                break;
            } else {
                System.out.println("no parameter given");
            }
        }


    }
}
