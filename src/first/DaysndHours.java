package first;

import java.sql.*;
import java.util.ArrayList;


public class DaysndHours {
	
	private int noOfWorkingDays,workingTimePerDay,id,min;
	private String workingDays;
	
	
	
	
	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}


	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}


	public int getWorkingTimePerDay() {
		return workingTimePerDay;
	}


	public void setWorkingTimePerDay(int workingTimePerDay) {
		this.workingTimePerDay = workingTimePerDay;
	}


	public String getWorkingDays() {
		return workingDays;
	}


	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Connection connect() {
		Connection connection = null;
		try {
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itpm", "root", "");

		if(connection != null) {
		System.out.println("Successfully Connected");
		}
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return connection;
		}
	
	
	
	public String insertWorkingDays(String workingDays, int workingTimePerDay,int minutes,int noOfWorkingDays) {
		String outcome = "";
		
		try {
		    Connection connection = connect();
		    String insertQuery = "insert into workingdays values ('2','"+workingDays+"', '"+workingTimePerDay+"','"+minutes+"', '"+noOfWorkingDays+"')";
		
		
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
	
	public ArrayList<DaysndHours> workingDayList(){
		ArrayList<DaysndHours> s1 =new ArrayList<DaysndHours>();
		Connection con = connect();
		String list = "select*from workingdays";
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(list);
			while(rs.next()) {
				DaysndHours dh = new DaysndHours();
				dh.setId(rs.getInt(1));
				dh.setWorkingDays(rs.getString(2));
				dh.setWorkingTimePerDay(rs.getInt(3));
				dh.setMin(rs.getInt(4));
				dh.setNoOfWorkingDays(rs.getInt(5));
				s1.add(dh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;
		
	}
	
	public void updateWorkingDays(int id, String workingDays, int workingTimePerDay,int minutes,int noOfWorkingDays) {
		try {
		Connection connection = connect();
		String updateQuery = "update workingdays set workingDays = '"+workingDays+"', workingTimePerDay = '"+workingTimePerDay+"', minute = '"+minutes+"', noOfDays ='"+noOfWorkingDays+"',where id = '"+id+"' ";

		PreparedStatement ps;
		ps = connection.prepareStatement(updateQuery);
		ps.execute();
		connection.close();

		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	
	public void deleteWorkingDays(int id) {

		try {
		Connection connection = connect();

		String delQuery = "delete from workingdays where id = '"+id+"'";

		PreparedStatement ps = connection.prepareStatement(delQuery);
		ps.execute();
		connection.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}
	
	

}
