import java.util.List;

public class Application implements IQuery {

    List<RecordLine> records;

    public static void main(String... args) {
        Application app = new Application();
        app.execute();

    }


    public void execute() {
        loadRecords();
        executeSQL01();
        executeSQL02();
        executeSQL03();
        executeSQL04();
        executeSQL05();
        executeSQL06();
        executeSQL07();
        executeSQL08();
        executeSQL09();
        executeSQL10();
        executeSQL11();
        executeSQL12();
    }

    private void loadRecords() {
        CsvParser csvParser = new CsvParser();
        records = csvParser.processInputFile(Configuration.instance.dataPath + "records.csv");
    }

    // count
    public long executeSQL01() {
        long count = records.stream().count();
        System.out.println("--- query 01 (count)");
        System.out.println(count);
        System.out.println();
        return count;
    }

    // count, where
    public void executeSQL02() {
    }

    // count, where, in
    public void executeSQL03() {
    }

    // count, where, not in
    public void executeSQL04() {
    }

    // id, where, in, order by desc limit
    public void executeSQL05() {
    }

    // id, where, in, order by desc, order by asc
    public void executeSQL06() {
    }

    // count, group by
    public void executeSQL07() {
    }

    // count, where, group by
    public void executeSQL08() {
    }

    // count, where, in, group by
    public void executeSQL09() {
    }

    // count, where, not in, group by
    public void executeSQL10() {
    }

    // sum, where, not in, in, group by
    public void executeSQL11() {
    }

    // avg, where, in, in, group by
    public void executeSQL12() {
    }

}
