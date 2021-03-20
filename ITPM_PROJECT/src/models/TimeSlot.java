package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.TimeSlot;

public class TimeSlot {
	private int id;
	private String startTime;
	private String endTime;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Connection connect() {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/time_table", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully connected");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	

public void createTimeSlot(String start_time, String end_time) {
	
	Connection conn = connect();
	
	String insertTimeSlot = "insert into timeslot values(?, ?, ?)";
	PreparedStatement st;
	try {
		st = conn.prepareStatement(insertTimeSlot);
		st.setInt(1, 0);
		st.setString(2, start_time);
		st.setString(3, end_time);
		st.execute();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public ArrayList<TimeSlot> getTimeSlots(){
		Connection conn = connect();
		ArrayList<TimeSlot> ts = new ArrayList<>();
		
		String getTSlots = "select * from timeslot";
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(getTSlots);
			while(rs.next()) {
				TimeSlot tslot = new TimeSlot();
				tslot.setId(rs.getInt(1));
				tslot.setStartTime(rs.getString(2));
				tslot.setEndTime(rs.getString(3));
				ts.add(tslot);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ts;
	}
	
	public void deleteTimeSlot(int id) {
		Connection conn = connect();
		
		String deleteTSlot = "delete from timeslot where id = '"+id+"'";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(deleteTSlot);
			st.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
