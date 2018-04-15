//For SQL
import java.sql.*;
public class SQL_Test {

	public static void main(String[] args) {
		
		//For connecting to SQL 
		try {
			// 1. Get a connection to DB
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CISAppDatabase?useSSL=false","root","root");
			
			
			// 2. Create the statement 
			Statement myStatement = myConn.createStatement();
			
			// 3. Execute Query 
			ResultSet  myRs = myStatement.executeQuery("select * from Customer");
			
			// 4. Process the result set 
			while(myRs.next()) {
				System.out.println(myRs.getString("FirstName") + myRs.getString("LastName"));
			}
			
		}
		
		catch (Exception exc) {
			
		}

	}

}
