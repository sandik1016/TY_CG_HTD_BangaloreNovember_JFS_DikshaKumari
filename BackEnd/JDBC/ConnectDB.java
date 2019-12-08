import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class ConnectDB {
    static Connection connection = null;
	static String databaseName = "";

	static final String url = "jdbc:mysql://localhost:3306/StudentDatabase";
	static String username = "root";
	static String password="";
	public static void main(String[] args) throws Exception {
		Statement stmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to a selected database...");
	      
	    connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected database successfully...");
		System.out.println("Inserting records into the table...");
	      stmt = connection.createStatement();
	      
	      
	     String  sql = "INSERT INTO Student " +
                  "VALUES (101, 'Mahnaz')";
     stmt.executeUpdate(sql);
		
		}
	}


