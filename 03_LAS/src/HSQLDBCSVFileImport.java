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
        sqlStringBuilder.append("waitingTimeInMinutes INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("serviceDesk INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("shift INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("dayOfWeek VARCHAR(3) NOT NULL").append(",");
        sqlStringBuilder.append("destination VARCHAR(1) NOT NULL").append(",");
        sqlStringBuilder.append("type VARCHAR(1) NOT NULL").append(",");
        sqlStringBuilder.append("price INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("premiumService VARCHAR(3) NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        update(sqlStringBuilder.toString());
    }

    public void init() {
        startup();
        dropTable();
        createTable();
    }

    public String buildSQLStatement(long id,int waitingTimeInMinutes,int serviceDesk,int shift,String dayOfWeek,String destination,String type,int price,String premiumService) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO data (id,waitingTimeInMinutes,serviceDesk,shift,dayOfWeek,destination,type,price,premiumService) VALUES (");
        stringBuilder.append(id).append(",");
        stringBuilder.append(waitingTimeInMinutes).append(",");
        stringBuilder.append(serviceDesk).append(",");
        stringBuilder.append(shift).append(",");
        stringBuilder.append("'").append(dayOfWeek).append("'").append(",");
        stringBuilder.append("'").append(destination).append("'").append(",");
        stringBuilder.append("'").append(type).append("'").append(",");
        stringBuilder.append(price).append(",");
        stringBuilder.append("'").append(premiumService).append("'");
        stringBuilder.append(")");
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public void insert(long id,int waitingTimeInMinutes,int serviceDesk,int shift,String dayOfWeek,String destination,String type,int price,String premiumService) {
        update(buildSQLStatement(id,waitingTimeInMinutes,serviceDesk,shift,dayOfWeek,destination,type,price,premiumService));
    }

    public void importCSVFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(";");
                insert(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),
                        Integer.parseInt(strings[3]),strings[4],strings[5],strings[6],Integer.parseInt(strings[7]),strings[8]);
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
        // HSQLDBCSVFileImport hsqldbcsvFileImport = new HSQLDBCSVFileImport();
        // hsqldbcsvFileImport.init();
        // hsqldbcsvFileImport.importCSVFile(Configuration.instance.dataPath + "records.csv");
        // hsqldbcsvFileImport.shutdown();
    }
}