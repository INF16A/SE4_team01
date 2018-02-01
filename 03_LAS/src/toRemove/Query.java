package toRemove;

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
                "WHERE customerRegion = 'A' AND productID >= 100 AND productID <= 500 AND quantity > 1";
        queryDump(sqlStatement);
    }

    // count, where, in
    public void executeSQL03() {
        writeLogfile("--- query 03 (count, where, in)");
        String sqlStatement = "SELECT COUNT(*) FROM data " +
                "WHERE customerTownID >= 5 AND customerTownID <= 75 " +
                "AND customerRegion IN ('B','C','G') " +
                "AND productID >= 50 AND productID <= 500 " +
                "AND quantity <= 2";
        queryDump(sqlStatement);
    }

    // count, where, not in
    public void executeSQL04() {
        writeLogfile("--- query 04 (count, where, not in)");
        String sqlStatement = "SELECT COUNT(*) FROM data " +
                "WHERE customerTownID >= 10 AND customerTownID <= 15 " +
                "AND customerRegion NOT IN ('A','B','C','H') " +
                "AND productID >= 50 AND productID <= 100 " +
                "AND quantity <= 2";
        queryDump(sqlStatement);
    }

    // id, where, in, order by desc limit
    public void executeSQL05() {
        writeLogfile("--- query 05 (id, where, in, order by desc limit)");
        String sqlStatement = "SELECT id FROM data " +
                "WHERE customerTownID >= 10 AND customerTownID <= 15 " +
                "AND customerRegion IN ('A','B') " +
                "AND productID >= 50 AND productID <= 55 " +
                "AND quantity = 3 " +
                "ORDER BY customerTownID DESC LIMIT 3";
        queryDump(sqlStatement);
    }

    // id, where, in, order by desc, order by asc
    public void executeSQL06() {
        writeLogfile("--- query 06 (id, where, in, order by desc, order by asc)");
        String sqlStatement = "SELECT id FROM data " +
                "WHERE customerTownID >= 5 AND customerTownID <= 7 " +
                "AND customerRegion IN ('A','B') " +
                "AND productID >= 250 AND productID <= 252 " +
                "AND quantity = 1 " +
                "ORDER BY quantity DESC,customerTownID";
        queryDump(sqlStatement);
    }

    // count, group by
    public void executeSQL07() {
        writeLogfile("--- query 07 (count, group by)");
        String sqlStatement = "SELECT customerRegion,COUNT(*) FROM data " +
                "GROUP BY customerRegion";
        queryDump(sqlStatement);
    }

    // count, where, group by
    public void executeSQL08() {
        writeLogfile("--- query 08 (count, where, group by)");
        String sqlStatement = "SELECT productID,COUNT(*) FROM data " +
                "WHERE customerRegion = 'C' " +
                "AND productID <= 10 " +
                "AND quantity <= 2 " +
                "GROUP BY productID";
        queryDump(sqlStatement);
    }

    // count, where, in, group by
    public void executeSQL09() {
        writeLogfile("--- query 09 (count, where, in, group by)");
        String sqlStatement = "SELECT customerRegion,COUNT(*) FROM data " +
                "WHERE customerRegion IN ('A','B','C') " +
                "AND productID >= 125 AND productID <= 425 " +
                "AND quantity > 1 " +
                "GROUP BY customerRegion";
        queryDump(sqlStatement);
    }

    // count, where, not in, group by
    public void executeSQL10() {
        writeLogfile("--- query 10 (count, where, not in, group by)");
        String sqlStatement = "SELECT customerRegion,COUNT(*) FROM data " +
                "WHERE customerRegion NOT IN ('B','D','F','G') " +
                "AND customerTownID <= 275 " +
                "AND productID <= 300 " +
                "GROUP BY customerRegion";
        queryDump(sqlStatement);
    }

    // sum, where, not in, in, group by
    public void executeSQL11() {
        writeLogfile("--- query 11 (sum, where, not in, in, group by)");
        String sqlStatement = "SELECT customerRegion,SUM(quantity) FROM data " +
                "WHERE customerRegion NOT IN ('B','C','D') " +
                "AND customerTownID >= 50 AND customerTownID <= 100 " +
                "AND productID IN (5,10,15,20,15) " +
                "GROUP BY customerRegion";
        queryDump(sqlStatement);
    }

    // avg, where, in, in, group by
    public void executeSQL12() {
        writeLogfile("--- query 12 (avg, where, in, in, group by)");
        String sqlStatement = "SELECT productID,AVG(deliveryTimeInHours) FROM data " +
                "WHERE customerRegion IN ('C','D','E') " +
                "AND customerTownID >= 50 AND customerTownID <= 100 " +
                "AND productID IN (10,20,30,40,50) " +
                "GROUP BY productID";
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