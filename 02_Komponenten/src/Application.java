import java.util.Scanner;

public class Application {

    private void showComponents() {

    }

    private void showCurrentComponent() {

    }

    private void loadComponent(String num) {

    }

    private void execute(String arr[]) {

    }

    public static void main(String... args) {
        Application app = new Application();

        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();

            if(command.equals("exit")) {
                running = false;
            } else if(command.equals("show components")) {
                app.showComponents();
            } else if(command.equals("show current component")) {
                app.showCurrentComponent();
            } else if(command.startsWith("set current component ")) {
                String[] parts = command.split(" ");
                app.loadComponent(parts[3]);
            } else if(command.startsWith("execute ")) {
                String parts[] = command.split(" ");
                String arr[] = parts[2].split(",");
                app.execute(arr);
            } else {
                System.out.println("Unknown command.\nThe following commands are available:\nshow components, show current component, set current component <component>, execute <unsorted comma seperated list>");
            }

        }
    }
}