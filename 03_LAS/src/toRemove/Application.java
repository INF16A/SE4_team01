package toRemove;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Application implements IApplication {
    private ArrayList<String> regions;
    private ArrayList<Town> towns;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public Application() {
        regions = new ArrayList<>();
        towns = new ArrayList<>();
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void initRegions() {
        regions.add("A");
        regions.add("B");
        regions.add("C");
        regions.add("D");
        regions.add("E");
        regions.add("F");
        regions.add("G");
    }

    public void initTowns() {
        for (int i = 0; i < Configuration.instance.maximumNumberOfTowns; i++) {
            int randomRegionIndex = Configuration.instance.randomNumberGenerator.nextInt(0,regions.size()-1);
            Town town = new Town(i,regions.get(randomRegionIndex));
            towns.add(town);
        }
    }

    public void initCustomers() {
        for (int i = 0; i < Configuration.instance.maximumNumberOfCustomers; i++) {
            int randomTownIndex = Configuration.instance.randomNumberGenerator.nextInt(0,towns.size()-1);
            Customer customer = new Customer(i,towns.get(randomTownIndex));
            customers.add(customer);
        }
    }

    public String generateRandomString(String candidateCharacters,int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < length;i++)
            stringBuilder.append(candidateCharacters.charAt(Configuration.instance.randomNumberGenerator.nextInt(candidateCharacters.length())));
        return stringBuilder.toString();
    }

    public void initProducts() {
        int i = 1;

        do {
            Product product = new Product(i,generateRandomString("abcdefghijklmnopqrstuvwxyz1234567890",5),
                    Configuration.instance.randomNumberGenerator.nextInt(5,1000));
            if (!products.contains(product)) {
                products.add(product);
                i++;
            }
        } while (products.size() < Configuration.instance.maximumNumberOfProducts);
    }

    public void generateData() {
        for (int i = 0; i < Configuration.instance.maximumNumberOfOrders; i++) {
            int randomCustomerIndex = Configuration.instance.randomNumberGenerator.nextInt(0,customers.size()-1);
            int randomProductIndex = Configuration.instance.randomNumberGenerator.nextInt(0,products.size()-1);
            Order order = new Order(i+1,customers.get(randomCustomerIndex),products.get(randomProductIndex),
                    Configuration.instance.randomNumberGenerator.nextInt(1,3), Configuration.instance.randomNumberGenerator.nextInt(4,48));
            orders.add(order);
        }
    }

    public void generateToCSVFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Configuration.instance.dataPath + "records.csv")));

            for (int i = 0;i < orders.size();i++)
                bufferedWriter.write(orders.get(i).toString() + Configuration.instance.lineSeparator);

            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String... args) {
        Application application = new Application();
        /*application.initRegions();
        application.initTowns();
        application.initCustomers();
        application.initProducts();
        application.generateData();
        application.generateToCSVFile();*/
    }
}