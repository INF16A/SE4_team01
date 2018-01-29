
import java.lang.reflect.Method;
import java.util.Scanner;

public class Application {
    private Application() {
        loadComponent(Configuration.instance.getSorterType());
    }

    private Class _class;
    private Object _classInstance;
    private Object port;

    private void showComponents() {
        SorterType[] sorterTypes = SorterType.values();
        for (SorterType sorterType :
                sorterTypes) {
            System.out.println(sorterType.name());
        }
    }

    private void showCurrentComponent() {
        SorterType[] sorterTypes = SorterType.values();
        System.out.println("current component " + sorterTypes[-1 + Integer.parseInt(Configuration.instance.sortingAlgorithm)]);
    }

    private void parseInputSelection(String input) {
        String parsedInput = input.toLowerCase().trim();
        SorterType[] sorterTypes = SorterType.values();
        for (int i = 0; i < sorterTypes.length; i++) {
            if (parsedInput.equals(sorterTypes[i].name())) {
                System.out.println(sorterTypes[i].name() + " sorter selected");
                loadComponent(sorterTypes[i]);
                return;
            }
        }
        System.out.println("selection not changed '" + parsedInput + "'");
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
        System.out.println("Enter a command pls");
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
                String arr[] = parts[1].split(",");
                app.execute(arr);
            } else {
                System.out.println("Unknown command.\nThe following commands are available:\nshow components, show current component, set current component <component>, execute <unsorted comma seperated list>");
            }

        }
    }
}