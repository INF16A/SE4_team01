import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Application implements IApplication {
    private ArrayList<String> daysOfWeek;
    private ArrayList<String> destinations;
    private ArrayList<String> ticketTypes;
    private ArrayList<Ticket> tickets;
    private ArrayList<Record> records;

    public Application() {
        daysOfWeek = new ArrayList<>();
        destinations = new ArrayList<>();
        ticketTypes = new ArrayList<>();
        tickets = new ArrayList<>();
        records = new ArrayList<>();
    }

    public void initDaysOfWeek() {
        daysOfWeek.add("mon");
        daysOfWeek.add("tue");
        daysOfWeek.add("wed");
        daysOfWeek.add("thu");
        daysOfWeek.add("fri");
        daysOfWeek.add("sat");
        daysOfWeek.add("sun");
    }

    public void initDestinations() {
        destinations.add("a");
        destinations.add("b");
        destinations.add("c");
        destinations.add("d");
        destinations.add("e");
        destinations.add("f");
        destinations.add("g");
        destinations.add("h");
    }

    public void initTicketTypes() {
        ticketTypes.add("s");
        ticketTypes.add("r");
        ticketTypes.add("w");
        ticketTypes.add("m");
    }

    public void initTickets() {
        int returnTicketFactor = 2;
        int weekTicketFactor = 5;
        int monthTicketFactor = 20;

        for (int i = 0;i < destinations.size();i++) {
            for (int j = 0;j < ticketTypes.size();j++) {
                int randomBasePrice = Configuration.instance.randomNumberGenerator.nextInt(5,45);
                int price = 0;

                String ticketType = ticketTypes.get(j);
                switch (ticketType) {
                    case "s" : price = randomBasePrice;
                    break;
                    case "r" : price = randomBasePrice * returnTicketFactor;
                    break;
                    case "w" : price = randomBasePrice * weekTicketFactor;
                    break;
                    case "m" : price = randomBasePrice * monthTicketFactor;
                    break;
                }

                Ticket ticket = new Ticket(destinations.get(i),ticketTypes.get(j),price);
                tickets.add(ticket);
            }
        }
    }

    public void generateData() {
        for (int i = 0;i < Configuration.instance.maximumNumberOfRecords;i++) {
            int randomWaitingTimeInMinutes = Configuration.instance.randomNumberGenerator.nextInt(1,10);
            int randomNumberServiceDesk = Configuration.instance.randomNumberGenerator.nextInt(1,12);
            int randomNumberShift = Configuration.instance.randomNumberGenerator.nextInt(1,4);
            int randomDayOfWeekIndex = Configuration.instance.randomNumberGenerator.nextInt(0,daysOfWeek.size()-1);
            int randomTicketIndex = Configuration.instance.randomNumberGenerator.nextInt(0,tickets.size()-1);
            String premiumService = "no";
            if (Configuration.instance.randomNumberGenerator.nextDouble() < 0.05)
                premiumService = "yes";

            Record record = new Record(i+1,randomWaitingTimeInMinutes,randomNumberServiceDesk,randomNumberShift,
                    daysOfWeek.get(randomDayOfWeekIndex),tickets.get(randomTicketIndex),premiumService);
            records.add(record);
        }
    }

    public void generateToCSVFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Configuration.instance.dataPath + "records.csv")));

            for (int i = 0;i < records.size();i++)
                bufferedWriter.write(records.get(i).toString() + Configuration.instance.lineSeparator);

            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String... args) {
        // Application application = new Application();
        // application.initDestinations();
        // application.initTicketTypes();
        // application.initDaysOfWeek();
        // application.initTickets();
        // application.generateData();
        // application.generateToCSVFile();
    }
}