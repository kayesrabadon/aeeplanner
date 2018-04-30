import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Window;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;

public class ViewAppointments extends JFrame {

	private JFrame frameViewAppointments;
	ConnectionJAVA connJAVA;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointments windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewAppointments() throws SQLException {
		setFont(new Font("Tahoma", Font.PLAIN, 17));
		connJAVA = new ConnectionJAVA();
		initialize();
	}

	
	private void initialize() throws SQLException {
		setframeViewAppointments(new JFrame());
		getframeViewAppointments().setExtendedState(JFrame.MAXIMIZED_BOTH);
		getframeViewAppointments().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameViewAppointments.getContentPane().setLayout(null);
		
        //headers for the table
        String[] columns = new String[] { "DAY", "MONTH", "TIME", "TYPE", "APPOINTMENTS" };
        
        System.out.println(connJAVA);
        
        ArrayList<Array> appointments = connJAVA.selectAppointments();
        
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    	JTable table = new JTable(tableModel);
    	
    	for (Array appointment : appointments) {
    		Object[] data = appointment.getArrayObject();
        	tableModel.addRow(data);
		}
    	
        getContentPane().add(new JScrollPane(table));
         
        this.setTitle("PLANNER");
        this.setBounds(400, 100, 900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.setVisible(true);
	}


	private Window setwindowAppointments() {

		return null;
	}


	public JFrame getframeViewAppointments() {
		return frameViewAppointments;
	}


	public void setframeViewAppointments(JFrame frameViewAppointments) {
		this.frameViewAppointments = frameViewAppointments;
	}
}
