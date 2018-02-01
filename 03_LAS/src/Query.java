import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Query implements IQuery {
    private Connection connection;
    private String driverName = "jdbc:hsqldb:";
    private String username = "sa";
    private String password = "";
    private BufferedWriter bufferedWriter;

    public void startup() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + Configuration.instance.dataPath + "records.db";
            connection = DriverManager.getConnection(databaseURL,username,password);

            bufferedWriter = new BufferedWriter(new FileWriter(Configuration.instance.logPath + "query.log"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeLogfile(String message) {
        try {
            bufferedWriter.append(message).append("\n");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public String dump(ResultSet resultSet) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int maximumNumberColumns = resultSetMetaData.getColumnCount();
            int i;
            Object object;

            for (;resultSet.next();) {
                for (i = 0;i < maximumNumberColumns;++i) {
                    object = resultSet.getObject(i + 1);
                    stringBuilder.append(object.toString() + " ");
                }
                stringBuilder.append(" \n");
            }

            return stringBuilder.toString();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return "-1";
    }

    public synchronized void queryDump(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            writeLogfile(sqlStatement);
            writeLogfile(dump(resultSet));
            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    // count
    public void executeSQL01() {
        writeLogfile("--- query 01 (count)");
        String sqlStatement = "SELECT COUNT(*) FROM data";
        queryDump(sqlStatement);
    }

    // count, where
    public void executeSQL02() {
        writeLogfile("--- query 02 (count, where)");
        String sqlStatement = "SELECT COUNT(*) FROM data " +
                "WHERE serviceDesk = 8 AND type = 'w'";
        queryDump(sqlStatement);
    }

    // count, where, in
    public void executeSQL03() {
        writeLogfile("--- query 03 (count, where, in)");
        String sqlStatement = "SELECT COUNT(*) FROM data " +
                "WHERE serviceDesk = 4 AND shift = 1 AND type = 'm' " +
                "AND dayOfWeek IN ('fri','sat','sun')";
        queryDump(sqlStatement);
    }

    // count, where, not in
    public void executeSQL04() {
        writeLogfile("--- query 04 (count, where, not in)");
        String sqlStatement = "SELECT COUNT(*) FROM data " +
                "WHERE serviceDesk = 8 AND shift = 2 AND type = 'r' " +
                "AND dayOfWeek NOT IN ('mon','fri','sat')";
        queryDump(sqlStatement);
}

    // id, where, in, order by desc limit
    public void executeSQL05() {
        writeLogfile("--- query 05 (id, where, in, order by desc limit)");
        String sqlStatement = "SELECT serviceDesk FROM data " +
                "WHERE shift = 2 AND type = 'r' " +
                "AND dayOfWeek IN ('sat','sun') AND destination = 'b' " +
                "AND waitingTimeInMinutes = 10 " +
                "ORDER BY dayOfWeek DESC LIMIT 3";
        queryDump(sqlStatement);
    }

    // id, where, in, order by desc, order by asc
    public void executeSQL06() {
        writeLogfile("--- query 06 (id, where, in, order by desc, order by asc)");
        String sqlStatement = "SELECT serviceDesk FROM data " +
                "WHERE shift = 1 AND type = 'm' " +
                "AND dayOfWeek = 'mon' AND destination IN ('a','f') " +
                "AND waitingTimeInMinutes = 10 " +
                "AND premiumService = 'yes' " +
                "ORDER BY serviceDesk DESC, destination";
        queryDump(sqlStatement);
    }

    // count, group by
    public void executeSQL07() {
        writeLogfile("--- query 07 (count, group by)");
        String sqlStatement = "SELECT dayOfWeek,COUNT(*) FROM data " +
                "GROUP BY dayOfWeek";
        queryDump(sqlStatement);
    }

    // count, where, group by
    public void executeSQL08() {
        writeLogfile("--- query 08 (count, where, group by)");
        String sqlStatement = "SELECT destination,COUNT(*) FROM data " +
                "WHERE type = 'm' " +
                "AND premiumService = 'yes' " +
                "GROUP BY destination";
        queryDump(sqlStatement);
    }

    // count, where, in, group by
    public void executeSQL09() {
        writeLogfile("--- query 09 (count, where, in, group by)");
        String sqlStatement = "SELECT dayOfWeek,COUNT(*) FROM data " +
                "WHERE shift = 3 AND destination = 'c' " +
                "AND type IN ('s','r') " +
                "GROUP BY dayOfWeek";
        queryDump(sqlStatement);
    }

    // count, where, not in, group by
    public void executeSQL10() {
        writeLogfile("--- query 10 (count, where, not in, group by)");
        String sqlStatement = "SELECT type,COUNT(*) FROM data " +
                "WHERE destination = 'b' AND shift = '4' " +
                "AND dayOfWeek NOT IN ('tue','wed') " +
                "GROUP BY type";
        queryDump(sqlStatement);
    }

    // sum, where, not in, in, group by
    public void executeSQL11() {
        writeLogfile("--- query 11 (sum, where, not in, in, group by)");
        String sqlStatement = "SELECT serviceDesk,SUM(price) FROM data " +
                "WHERE type NOT IN ('s','r') " +
                "AND shift IN (1,2) " +
                "AND premiumService = 'yes' " +
                "GROUP BY serviceDesk";
        queryDump(sqlStatement);
    }

    // avg, where, in, in, group by
    public void executeSQL12() {
        writeLogfile("--- query 12 (avg, where, in, in, group by)");
        String sqlStatement = "SELECT shift,AVG(waitingTimeInMinutes) FROM data " +
                "WHERE premiumService = 'no' " +
                "AND dayOfWeek IN ('fri','mon') AND shift IN (1,4) " +
                "GROUP BY shift";
        queryDump(sqlStatement);
    }

    public void shutdown() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            connection.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String... args) {
        Query query = new Query();
        query.startup();

        query.executeSQL01();
        query.executeSQL02();
        query.executeSQL03();
        query.executeSQL04();
        query.executeSQL05();
        query.executeSQL06();
        query.executeSQL07();
        query.executeSQL08();
        query.executeSQL09();
        query.executeSQL10();
        query.executeSQL11();
        query.executeSQL12();

        query.shutdown();
    }
}