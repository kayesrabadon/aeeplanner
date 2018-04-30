
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Registration {

	ConnectionJAVA connJAVA;
	
	public JFrame frameRegistration;
	private JTextField textFieldUserName;
	private JTextField textFieldEmailAddress;
	private JPasswordField fieldPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration windowRegistration = new Registration();
					windowRegistration.frameRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registration() {
		initialize();
		connJAVA = new ConnectionJAVA();
	}

	private void initialize() {
		frameRegistration = new JFrame();
		frameRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegistration.setTitle("PLANNER");

		Dimension frameRegistrationSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = frameRegistrationSize.height;
		int width = frameRegistrationSize.width;
		frameRegistration.setSize(width / 3, height / 2);
		frameRegistration.setLocationRelativeTo(null);
		frameRegistration.getContentPane().setLayout(null);

		JLabel labelRegistrationForm = new JLabel("REGISTRATION FORM");
		labelRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 25));
		labelRegistrationForm.setBounds(106, 36, 292, 45);
		frameRegistration.getContentPane().add(labelRegistrationForm);

		JLabel labelUName = new JLabel("Username:");
		labelUName.setFont(new Font("Tahoma", Font.BOLD, 21));
		labelUName.setBounds(31, 134, 159, 35);
		frameRegistration.getContentPane().add(labelUName);

		//to open calendar.java
		JButton buttonRegister = new JButton("REGISTER");
		buttonRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login windowLogin = new Login();
				windowLogin.getframeLogin().setVisible(true);
				frameRegistration.setVisible(false);
			}
		});
		
		
		buttonRegister.addActionListener(new ActionListener() {
			private int type;

			public void actionPerformed(ActionEvent arg0) {
				try {
					connJAVA.insertRegistration(textFieldUserName.getText(), String.copyValueOf(fieldPassword.getPassword()), textFieldEmailAddress.getText(), type=0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		buttonRegister.setFont(new Font("Tahoma", Font.BOLD, 21));
		buttonRegister.setBounds(186, 337, 159, 35);
		frameRegistration.getContentPane().add(buttonRegister);

		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textFieldUserName.setBounds(206, 133, 272, 35);
		frameRegistration.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);

		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		labelPassword.setBounds(31, 191, 165, 35);
		frameRegistration.getContentPane().add(labelPassword);

		JLabel labelEmailAddress = new JLabel("Email Address:");
		labelEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 21));
		labelEmailAddress.setBounds(31, 247, 165, 35);
		frameRegistration.getContentPane().add(labelEmailAddress);

		textFieldEmailAddress = new JTextField();
		textFieldEmailAddress.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textFieldEmailAddress.setColumns(10);
		textFieldEmailAddress.setBounds(206, 247, 272, 35);
		frameRegistration.getContentPane().add(textFieldEmailAddress);

		fieldPassword = new JPasswordField();
		fieldPassword.setFont(new Font("Monospaced", Font.PLAIN, 21));
		fieldPassword.setBounds(206, 190, 272, 35);
		frameRegistration.getContentPane().add(fieldPassword);
	}
}
