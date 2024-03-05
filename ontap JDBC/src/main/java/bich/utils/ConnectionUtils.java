package bich.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
   public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
       String hostName = "localhost";
       String sqlInstanceName = "SQL2019";
       String dbName = "TranNgocBich_2110900007";
       String userName = "da";
       String password = "12345@";
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String connectionURL = "jdbc:sqlserver://" + hostName + ":1000;encrypt=true;trustServerCertificate=true;instance=" + sqlInstanceName + ";databaseName="+ dbName;
       Connection conn = DriverManager.getConnection(connectionURL, userName, password);
       return conn;
   
   }
}