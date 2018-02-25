package Task_I06;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        IShoppingCartVisitor visitor;
        System.out.println("Are you a business customer? y/n");
        String input = sc.nextLine();
        if (input.contains("y")) {
            visitor = new BusinessVisitor();
        } else {
            visitor = new PrivateVisitor();
        }

        ShoppingCartOperator operator = new ShoppingCartOperator(visitor);

        System.out.println(visitor.getClass().getSimpleName() + " selected");
        System.out.println("Commands: choose, close, pay");

        while (true) {
            input = "";
            if (sc.hasNextLine()) {
                input = sc.nextLine();
            }
            if (input.contains("choose")) {
                operator.selectRandomProducts();
                continue;
            }
            if (input.contains("close")) {
                if (operator.close()) {
                    System.out.println("Cart closed");
                }
                continue;
            }
            if (input.contains("pay")) {
                if (operator.pay()) {
                    break;
                }
                continue;
            }
            System.out.println("couldn't parse command. Try again");
            System.out.println("Commands: choose, close, pay");
        }
        System.out.println("Successfully paid. Goodbye");
    }
}
