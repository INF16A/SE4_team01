import sun.security.krb5.Config;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Application {
    private Class _class;
    private Object _classInstance;
    private Object port;

    private void showComponents() {

    }

    private void showCurrentComponent() {
        try {
            Method getName = port.getClass().getMethod("getName");
            System.out.println("current component: " + getName.invoke(port));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseInputSelection(String input) {
        int parsedInput = -1 + Integer.parseInt(input);
        SorterType[] sorterTypes = SorterType.values();
        for (int i = 0; i < sorterTypes.length; i++) {
            if (parsedInput == i) {
                System.out.println(sorterTypes[i].name() + " sorter selected");
                loadComponent(sorterTypes[i]);
                break;
            }
        }
    }

    private void loadComponent(SorterType num) {
        Configuration.instance.sortingAlgorithm = "0" + Integer.toString(num.ordinal() + 1);
        port = SorterFactory.create();
    }

    private int[] execute(String arr[]) {

        try {
            int[] values = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                values[i] = Integer.parseInt(arr[i]);
            }
            Method sortMethod = port.getClass().getMethod("sort", int[].class);
            return (int[]) sortMethod.invoke(port, arr);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number input");
        } catch (NoSuchMethodException e) {
            System.out.println("Method 'sort' not found.");
        } catch (Exception e) {
            System.out.println("unexpected exception happened.");
            e.printStackTrace();
        }
        return new int[0];
    }

    public static void main(String... args) {
        Application app = new Application();

        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();

            if (command.equals("exit")) {
                running = false;
            } else if (command.equals("show components")) {
                app.showComponents();
            } else if (command.equals("show current component")) {
                app.showCurrentComponent();
            } else if (command.startsWith("set current component ")) {
                String[] parts = command.split(" ");
                app.parseInputSelection(parts[3]);
            } else if (command.startsWith("execute ")) {
                String parts[] = command.split(" ");
                String arr[] = parts[2].split(",");
                app.execute(arr);
            } else {
                System.out.println("Unknown command.\nThe following commands are available:\nshow components, show current component, set current component <component>, execute <unsorted comma seperated list>");
            }

        }
    }
}