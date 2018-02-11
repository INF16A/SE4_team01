import java.lang.reflect.Method;
import java.util.Scanner;

public class Application {
    private Object port;

    private Application() {
        loadComponent(Configuration.instance.getSorterType());
    }

    public static void main(String... args) {
        Application app = new Application();
        System.out.println("Please enter a command:");
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            if (scanner.hasNextLine()) {
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
                    int[] result = app.execute(arr);
                    String resultStr = "";
                    for (int i = 0; i < result.length; i++) {
                        resultStr += Integer.toString(result[i]);
                        if (i < result.length - 1)
                            resultStr += ',';
                    }
                    System.out.println(resultStr);
                } else {
                    System.out.println("Unknown command.\nThe following commands are available:\nshow components, show current component, set current component <component>, execute <unsorted comma seperated list>");
                }
            }
        }
    }

    private void showComponents() {
        String out = "";
        SorterType[] sorterTypes = SorterType.values();
        for (SorterType sorterType :
                sorterTypes) {
            out += sorterType.name();
            out += ", ";
        }
        System.out.println(out.substring(0, out.length() - 2));
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
        String parsedInput = input.toLowerCase().trim();
        SorterType[] sorterTypes = SorterType.values();
        for (SorterType sorterType : sorterTypes) {
            if (parsedInput.equals(sorterType.name())) {
                System.out.println(sorterType.name() + " sorter selected");
                loadComponent(sorterType);
                return;
            }
        }
        System.out.println("selection not changed, invalid input '" + parsedInput + "'");
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
            sortMethod.invoke(port, (Object) values);
            return values;

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
}