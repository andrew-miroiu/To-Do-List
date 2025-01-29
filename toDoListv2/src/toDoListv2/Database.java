package toDoListv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;

public class Database {
	
	private GUI gui;
	public Database(GUI gui){
		this.gui = gui;
		String url = "jdbc:mysql://localhost:3306/todolist";
		String username = "root";
		String password = "";
	
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			String query = "SELECT task FROM todolist";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("task");
				gui.add_task(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteTask(String taskText) {
		String url = "jdbc:mysql://localhost:3306/todolist";
		String username = "root";
		String password = "";
	
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "DELETE FROM todolist WHERE task = ?";
			PreparedStatement ppst = con.prepareStatement(query);
			ppst.setString(1, taskText);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}