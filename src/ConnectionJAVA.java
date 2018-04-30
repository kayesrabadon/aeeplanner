import java.awt.List;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class ConnectionJAVA {
	public Connection connection;
	private Window getframeLogin;
	private static Statement command;
	private static ResultSet rs;

	public ConnectionJAVA() {
		super();

		String username = "root";
		String password = "12345678";
		String connectionString = "jdbc:mariadb://localhost:3306/aeeplannerdb?user=" + username + "&password="
				+ password;

		try {
			connection = DriverManager.getConnection(connectionString);
			command = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertRegistration(String username, String password, String email_address, int type)
			throws SQLException {
		CallableStatement callableStmt = null;
		String query = "{call encrypt (?, ?, ?, ?)}";
		try {
			callableStmt = connection.prepareCall(query);
			callableStmt.setString(1, username);
			callableStmt.setString(2, password);
			callableStmt.setString(3, email_address);
			callableStmt.setShort(4, (short) 0);
			callableStmt.executeQuery();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callableStmt != null) {
				callableStmt.close();
			}
			if (command != null) {
				command.close();
			}
		}
		;
	}

	public void insertAppointment(String day_of_the_month, String month_of_appointment, String time_of_appointment,
			String type_of_appointment, String description_of_appointment) {
		String query = ("INSERT INTO planner_content(day_of_the_month, month_of_appointment, time_of_appointment, type_of_appointment, description_of_appointment) VALUES (?, ?, ?, ?, ?)");
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, day_of_the_month);
			preparedStmt.setString(2, month_of_appointment);
			preparedStmt.setString(3, time_of_appointment);
			preparedStmt.setString(4, type_of_appointment);
			preparedStmt.setString(5, description_of_appointment);
			preparedStmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Array> selectAppointments() throws SQLException {
		ArrayList<Array> appointments = new ArrayList<>();
		String query = "SELECT * FROM planner_content";
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			rs = preparedStmt.executeQuery();
			
			String day_of_the_month;
			String month_of_appointment;
			String time_of_appointment;
			String type_of_appointmenString;
			String description_of_appointment;
			
			while(rs.next()){
				day_of_the_month = rs.getString("day_of_the_month");
				month_of_appointment = rs.getString("month_of_appointment");
				time_of_appointment = rs.getString("time_of_appointment");
				type_of_appointmenString = rs.getString("type_of_appointment");
				description_of_appointment = rs.getString("description_of_appointment");
				
				appointments.add(new Array(day_of_the_month, month_of_appointment, time_of_appointment, type_of_appointmenString, description_of_appointment));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appointments;
	}

	public void selectLogin (String username, String password) throws SQLException {
		CallableStatement callableStmt = null;
		String query = "{call encryptselect ('" + username + "', '" + password + "')}";
		try {
			if(command.execute(query))
			
			{
				rs = command.getResultSet();
				
				if(rs.next())
				{
					AeeCalendar windowCalendar = new AeeCalendar();
					windowCalendar.getframeCalendar().setVisible(true);
				}
				else
				{
					System.err.println("Invalid username or password!");
				}
			}
			else
			{
				System.out.println("Invalido username or password!");
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (callableStmt != null) {
				callableStmt.close();
			}
			if (command !=null) {
				command.close();
			}
		}
	}
	
}
