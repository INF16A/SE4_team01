package taskgroup01.task38;

import java.util.Scanner;

public class Application {
    public static void main(String... args) {
        System.out.println("Commands: RENT <type>, RETURN <id>, EXIT");
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            String[] cmd = scanner.nextLine().toLowerCase().split(" ");
            if (cmd.length >= 2) {
                if (cmd[0].contains("rent")) {
                    String type = cmd[1];
                    System.out.println("you chose RENT with type " + type);
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
