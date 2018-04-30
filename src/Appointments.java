import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JSpinner;
import javax.swing.JTextField;

public class Appointments {

	private JFrame frameAppointments;
	ConnectionJAVA connJAVA;
	private String day;
	private String month;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointments windowAppointments = new Appointments("", "");
					windowAppointments.getframeAppointments().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Appointments(String day, String month) {
		System.out.println(day);
		System.out.println(month);
		this.day = day;
		this.month = month;
		initialize();
		connJAVA = new ConnectionJAVA();
	}


	private void initialize() {
		setframeAppointments(new JFrame());
		getframeAppointments().setBounds(100, 100, 614, 397);
		getframeAppointments().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAppointments.getContentPane().setLayout(null);
		frameAppointments.setTitle("PLANNER");

		JButton buttonBacktoCalendar = new JButton("BACK");
		buttonBacktoCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AeeCalendar windowCalendar = new AeeCalendar();
				windowCalendar.getframeCalendar().setVisible(true);
				frameAppointments.setVisible(false);
			}
		});

		buttonBacktoCalendar.setBounds(10, 11, 89, 23);
		frameAppointments.getContentPane().add(buttonBacktoCalendar);

		JLabel labelDateOfTheMonth = new JLabel();
		labelDateOfTheMonth.setHorizontalAlignment(SwingConstants.CENTER);
		labelDateOfTheMonth.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelDateOfTheMonth.setBounds(248, 73, 97, 34);
		labelDateOfTheMonth.setText(" "+day+" ");
		frameAppointments.getContentPane().add(labelDateOfTheMonth);

		//bug fix
		JButton buttonPrevious = new JButton("PREVIOUS");
		buttonPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int next = Integer.parseInt(day) -1;
				labelDateOfTheMonth.setText(String.valueOf(next));
			}
		});
		buttonPrevious.setBounds(118, 86, 89, 23);
		frameAppointments.getContentPane().add(buttonPrevious);

		//bug fix
		JButton buttonNext = new JButton("NEXT");
		buttonNext.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int next = Integer.parseInt(day) +1;
				labelDateOfTheMonth.setText(String.valueOf(next));
			}
		});
		buttonNext.setBounds(389, 86, 89, 23);
		frameAppointments.getContentPane().add(buttonNext);

		JComboBox comboBoxTime = new JComboBox();
		comboBoxTime.setBounds(82, 138, 89, 20);
		frameAppointments.getContentPane().add(comboBoxTime);

		Calendar minutesController = Calendar.getInstance();
		minutesController.set(Calendar.HOUR, 7); 
		minutesController.set(Calendar.MINUTE, 0);
		minutesController.set(Calendar.AM_PM, Calendar.AM);

		SimpleDateFormat sdt = new SimpleDateFormat("hh:mm aa");

		do {
			comboBoxTime.addItem(sdt.format(minutesController.getTime()));
			minutesController.add(Calendar.MINUTE, 10);
		} while(minutesController.get(Calendar.HOUR) != 11 || minutesController.get(Calendar.AM_PM) != Calendar.PM);	


		JEditorPane editorPaneDescription = new JEditorPane();
		editorPaneDescription.setBounds(231, 138, 268, 99);
		frameAppointments.getContentPane().add(editorPaneDescription);

		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setBounds(279, 261, 164, 20);
		frameAppointments.getContentPane().add(comboBoxType);
		comboBoxType.addItem("Dental Appointment");
		comboBoxType.addItem("Client Appointment");
		comboBoxType.addItem("Hearing");
		comboBoxType.addItem("Deadline");
		comboBoxType.addItem("Meeting");
		comboBoxType.addItem("Others");

		JButton buttonDone = new JButton("DONE");
		buttonDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AeeCalendar windowCalendar = new AeeCalendar();
				windowCalendar.getframeCalendar().setVisible(true);
				frameAppointments.setVisible(false);
			}
		});
		buttonDone.setBounds(410, 310, 89, 23);
		frameAppointments.getContentPane().add(buttonDone);

		JButton buttonAddAppointment = new JButton("ADD ANOTHER APPOINTMENT");
		buttonAddAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Appointments windowAppointments = new Appointments("", "");
				windowAppointments.getframeAppointments().setVisible(true);
				getframeAppointments().setVisible(false);
			}
		});
		buttonAddAppointment.setBounds(90, 310, 226, 23);
		frameAppointments.getContentPane().add(buttonAddAppointment);

		JLabel labelMonth = new JLabel("");
		labelMonth.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelMonth.setHorizontalAlignment(SwingConstants.CENTER);
		labelMonth.setBounds(192, 22, 226, 40);
		labelMonth.setText(" "+month+" ");
		frameAppointments.getContentPane().add(labelMonth);

		//to insert something in the database
		buttonDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connJAVA.insertAppointment(labelDateOfTheMonth.getText(), labelMonth.getText(), String.valueOf(comboBoxTime.getSelectedItem()), editorPaneDescription.getText(), String.valueOf(comboBoxType.getSelectedItem()));
			}

		});

		buttonAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connJAVA.insertAppointment(labelDateOfTheMonth.getText(), labelMonth.getText(), String.valueOf(comboBoxTime.getSelectedItem()), editorPaneDescription.getText(), String.valueOf(comboBoxType.getSelectedItem()));
			}
		});

	}


	public JFrame getframeAppointments() {
		return frameAppointments;
	}


	public void setframeAppointments(JFrame frameAppointments) {
		this.frameAppointments = frameAppointments;
	}
}
