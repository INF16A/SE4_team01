import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application implements IQuery {

    public Application() {
        loadRecords();
    }

    List<RecordLine> records;

    public static void main(String... args) {
        Application app = new Application();
        app.execute();

    }


    public void execute() {
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
    public long executeSQL02() {
        long count = records.stream()
                .filter(record ->
                        record.getCustomerRegion() == 'A' &&
                                record.getProductId() >= 100 &&
                                record.getProductId() <= 500 &&
                                record.getQuanitity() > 1)
                .count();
        System.out.println("--- query 02 (count, where)");
        System.out.println(count);
        System.out.println();
        return count;
    }

    // count, where, in
    public long executeSQL03() {
        long count = records.stream()
                .filter(r ->
                        r.getCustomerTownId() >= 5 &&
                                r.getCustomerTownId() <= 75 &&
                                "BCG".contains(Character.toString(r.getCustomerRegion())) &&
                                r.getProductId() >= 50 &&
                                r.getProductId() <= 500 &&
                                r.getQuanitity() <= 2)
                .count();
        System.out.println("--- query 03 (count, where, in)");
        System.out.println(count);
        System.out.println();
        return count;
    }

    // count, where, not in
    public long executeSQL04() {
        long count = records.stream()
                .filter(r ->
                        r.getCustomerTownId() >= 10 &&
                                r.getCustomerTownId() <= 15 &&
                                !"ABCH".contains(Character.toString(r.getCustomerRegion())) &&
                                r.getProductId() >= 50 &&
                                r.getProductId() <= 100 &&
                                r.getQuanitity() <= 2)
                .count();
        System.out.println("--- query 04 (count, where, not in)");
        System.out.println(count);
        System.out.println();
        return count;
    }

    // id, where, in, order by desc limit
    public List<Integer> executeSQL05() {
        List<Integer> result = records.stream()
                .filter(r ->
                        r.getCustomerTownId() >= 10 &&
                                r.getCustomerTownId() <= 15 &&
                                "AB".contains(Character.toString(r.getCustomerRegion())) &&
                                r.getProductId() >= 50 &&
                                r.getProductId() <= 55 &&
                                r.getQuanitity() == 3)
                .sorted(Comparator.comparingInt(RecordLine::getCustomerTownId).reversed())
                .map(RecordLine::getId)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("--- query 05 (count, where, in, order by desc limit)");
        System.out.println(result);
        System.out.println();
        return result;
    }

    // id, where, in, order by desc, order by asc
    @Override
    public List<Integer> executeSQL06() {
        List<Integer> result = records.stream()
                .filter(r ->
                        r.getCustomerTownId() >= 5 &&
                                r.getCustomerTownId() <= 7 &&
                                "AB".contains(Character.toString(r.getCustomerRegion())) &&
                                r.getProductId() >= 250 &&
                                r.getProductId() <= 252 &&
                                r.getQuanitity() == 1)
                .sorted(Comparator.comparingInt(RecordLine::getQuanitity).reversed().thenComparingInt(RecordLine::getCustomerTownId))
                .map(RecordLine::getId)
                .collect(Collectors.toList());
        System.out.println("--- query 06 (id, where, in, order by desc, order by asc)");
        System.out.println(result);
        System.out.println();
        return result;
    }

    // count, group by
    @Override
    public Map<Character, Long> executeSQL07() {
        Map<Character, Long> result = records.stream()
                .collect(Collectors.groupingBy(RecordLine::getCustomerRegion, Collectors.counting()));
        System.out.println("--- query 07 (count, group by)");
        System.out.println(result);
        System.out.println();
        return result;
    }

    // count, where, group by
    @Override
    public Map<Integer, Long> executeSQL08() {
        return null;
    }

    // count, where, in, group by
    @Override
    public Map<Character, Long> executeSQL09() {
        return null;
    }

    // count, where, not in, group by
    @Override
    public Map<Character, Long> executeSQL10() {
        return null;
    }

    // sum, where, not in, in, group by
    @Override
    public Map<Character, Long> executeSQL11() {
        return null;
    }

    // avg, where, in, in, group by
    @Override
    public Map<Character, Double> executeSQL12() {
        return null;
    }
}
