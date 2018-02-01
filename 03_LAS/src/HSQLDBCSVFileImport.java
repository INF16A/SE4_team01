import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDBCSVFileImport {
    private Connection connection;
    private String driverName = "jdbc:hsqldb:";
    private String username = "sa";
    private String password = "";

    public void startup() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + Configuration.instance.dataPath + "records.db";
            connection = DriverManager.getConnection(databaseURL,username,password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);
            if (result == -1)
                System.out.println("error executing " + sqlStatement);
            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void dropTable() {
        System.out.println("--- dropTable");

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("DROP TABLE data");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

        update(sqlStringBuilder.toString());
    }

    public void createTable() {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE data ").append(" ( ");
        sqlStringBuilder.append("id BIGINT NOT NULL").append(",");
        sqlStringBuilder.append("customerID INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("customerTownID INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("customerRegion VARCHAR(1) NOT NULL").append(",");
        sqlStringBuilder.append("productID INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("productName VARCHAR(5) NOT NULL").append(",");
        sqlStringBuilder.append("productPrice INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("quantity INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("deliveryTimeInHours INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        update(sqlStringBuilder.toString());
    }

    public void init() {
        startup();
        dropTable();
        createTable();
    }

    public String buildSQLStatement(long id,int customerID,int customerTownID,String customerRegion,int productID,String productName,int productPrice,int quantity,int deliveryTimeInHours) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO data (id,customerID,customerTownID,customerRegion,productID,productName,productPrice,quantity,deliveryTimeInHours) VALUES (");
        stringBuilder.append(id).append(",");
        stringBuilder.append(customerID).append(",");
        stringBuilder.append(customerTownID).append(",");
        stringBuilder.append("'").append(customerRegion).append("'").append(",");
        stringBuilder.append(productID).append(",");
        stringBuilder.append("'").append(productName).append("'").append(",");
        stringBuilder.append(productPrice).append(",");
        stringBuilder.append(quantity).append(",");
        stringBuilder.append(deliveryTimeInHours);
        stringBuilder.append(")");
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public void insert(long id,int customerID,int customerTownID,String customerRegion,int productID,String productName,int productPrice,int quantity,int deliveryTimeInHours) {
        update(buildSQLStatement(id,customerID,customerTownID,customerRegion,productID,productName,productPrice,quantity,deliveryTimeInHours));
    }

    public void importCSVFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(";");
                insert(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),
                        strings[3],Integer.parseInt(strings[4]),strings[5],Integer.parseInt(strings[6]),
                        Integer.parseInt(strings[7]),Integer.parseInt(strings[8]));
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void shutdown() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            connection.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void main(String... args) {
        HSQLDBCSVFileImport hsqldbcsvFileImport = new HSQLDBCSVFileImport();
        hsqldbcsvFileImport.init();
        hsqldbcsvFileImport.importCSVFile(Configuration.instance.dataPath + "records.csv");
        hsqldbcsvFileImport.shutdown();
    }
}