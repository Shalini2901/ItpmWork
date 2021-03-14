package first;
import java.sql.*;
public class WorkingDays {
	public Connection connect() {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itpm", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully connected");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}

	public String insertWorkingDays(int noOfWorkingDays, String workingDays, int workingTimePerDay) {
		String outcome = "";
		
		try {
		    Connection connection = connect();
		    String insertQuery = "insert into workingdays values ('1','"+noOfWorkingDays+"', '"+workingDays+"', '"+workingTimePerDay+"')";
		
		
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			if(ps.execute()) {
				outcome = "Inserted Successfully";
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
		
		
	}
		
	}

