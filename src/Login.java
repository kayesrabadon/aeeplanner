import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Login {
	
	public JFrame frameLogin;
	private JPasswordField fieldPassword;
	ConnectionJAVA connJAVA;
	protected int type;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login windowLogin = new Login();
					windowLogin.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		initialize();
		connJAVA = new ConnectionJAVA();
	}

	
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		frameLogin.setTitle("PLANNER");
		
		Dimension frameSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = frameSize.height;
		int width = frameSize.width;
		frameLogin.setSize(width/4, height/3);
		frameLogin.setLocationRelativeTo(null);
		
		JLabel labelLogIn = new JLabel("Username:");
		labelLogIn.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogIn.setFont(new Font("Tahoma", Font.BOLD, 21));
		labelLogIn.setBounds(28, 42, 137, 34);
		frameLogin.getContentPane().add(labelLogIn);
		
		JTextArea textareaLogin = new JTextArea();
		textareaLogin.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textareaLogin.setBounds(161, 42, 189, 34);
		frameLogin.getContentPane().add(textareaLogin);
		
		JLabel labelpassword = new JLabel("Password:");
		labelpassword.setHorizontalAlignment(SwingConstants.LEFT);
		labelpassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		labelpassword.setBounds(28, 106, 137, 34);
		frameLogin.getContentPane().add(labelpassword);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setFont(new Font("Monospaced", Font.PLAIN, 21));
		fieldPassword.setBounds(161, 104, 189, 37);
		frameLogin.getContentPane().add(fieldPassword);
		
		JButton buttonLogin = new JButton("LOGIN");
		buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 21));
		buttonLogin.setBounds(116, 166, 158, 34);
		frameLogin.getContentPane().add(buttonLogin);
		
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					connJAVA.selectLogin(textareaLogin.getText(), String.copyValueOf(fieldPassword.getPassword()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			
		});
		
		// open another form REGISTER
		JLabel labelRegister = new JLabel("REGISTER HERE");
		labelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Registration windowRegistration = new Registration();
				windowRegistration.frameRegistration.setVisible(true);
				frameLogin.setVisible(false);
			}
		});
		
		labelRegister.setForeground(Color.DARK_GRAY);
		labelRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelRegister.setBounds(28, 211, 158, 28);
		frameLogin.getContentPane().add(labelRegister);
	}




	public Window getframeLogin() {
		return frameLogin;
	}
}
