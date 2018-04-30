import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.Calendar;

import com.toedter.calendar.JDayChooser;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class AeeCalendar {

	private JFrame frameCalendar;
	protected Object getwindowViewAppointments;
	private static JDayChooser dayChooserJan, dayChooserFeb, dayChooserMar, dayChooserApr, dayChooserMay, dayChooserJun, dayChooserJul, dayChooserAug, dayChooserSept, dayChooserOct, dayChooserNov, dayChooserDec;
	private JLabel lblFebruary, lblMarch, lblApril, lblMay, lblJune, lblJuly, lblAugust, lblSeptember, lblOctober, lblNovember, lblDecember;
	private JLabel lblYear;
	private JLabel lblNewYear;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AeeCalendar windowCalendar = new AeeCalendar();
					windowCalendar.getframeCalendar().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AeeCalendar() {
		initialize();
	}

	private void initialize() {
		setframeCalendar(new JFrame());
		getframeCalendar().setExtendedState(JFrame.MAXIMIZED_BOTH);
		getframeCalendar().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getframeCalendar().getContentPane().setLayout(null);
		frameCalendar.setTitle("PLANNER");
		

		dayChooserJan = new JDayChooser();
		dayChooserJan.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserJan.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedJan(evt);
		});
		Calendar jan = Calendar.getInstance();
		jan.set(Calendar.MONTH, Calendar.JANUARY);
		dayChooserJan.setCalendar(jan);
		dayChooserJan.setBounds(63, 110, 333, 220);
		frameCalendar.getContentPane().add(dayChooserJan);

		JLabel lblJanuary = new JLabel("JANUARY");
		lblJanuary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblJanuary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJanuary.setHorizontalAlignment(SwingConstants.CENTER);
		lblJanuary.setBounds(63, 80, 333, 32);
		getframeCalendar().getContentPane().add(lblJanuary);

		
		
		dayChooserFeb = new JDayChooser();
		dayChooserFeb.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserFeb.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedFeb(evt);
		});
		Calendar feb = Calendar.getInstance();
		feb.set(Calendar.MONTH, Calendar.FEBRUARY);
		dayChooserFeb.setCalendar(feb);
		dayChooserFeb.setBounds(443, 110, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserFeb);
		
		lblFebruary = new JLabel("FEBRUARY");
		lblFebruary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblFebruary.setHorizontalAlignment(SwingConstants.CENTER);
		lblFebruary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFebruary.setBounds(443, 80, 333, 32);
		frameCalendar.getContentPane().add(lblFebruary);
		

		
		dayChooserMar = new JDayChooser();
		dayChooserMar.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserMar.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedMar(evt);
		});
		Calendar mar = Calendar.getInstance();
		mar.set(Calendar.MONTH, Calendar.MARCH);
		dayChooserMar.setCalendar(mar);
		dayChooserMar.setBounds(823, 110, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserMar);
		
		lblMarch = new JLabel("MARCH");
		lblMarch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblMarch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarch.setBounds(823, 80, 333, 32);
		frameCalendar.getContentPane().add(lblMarch);
		
		

		dayChooserApr = new JDayChooser();
		dayChooserApr.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserApr.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedApr(evt);
		});
		Calendar apr = Calendar.getInstance();
		apr.set(Calendar.MONTH, Calendar.APRIL);
		dayChooserApr.setCalendar(apr);
		dayChooserApr.setBounds(1203, 110, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserApr);
		
		lblApril = new JLabel("APRIL");
		lblApril.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblApril.setHorizontalAlignment(SwingConstants.CENTER);
		lblApril.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApril.setBounds(1203, 80, 333, 32);
		frameCalendar.getContentPane().add(lblApril);
		
		

		dayChooserMay = new JDayChooser();
		dayChooserMay.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserMay.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedMay(evt);
		});
		Calendar may = Calendar.getInstance();
		may.set(Calendar.MONTH, Calendar.MAY);
		dayChooserMay.setCalendar(may);
		dayChooserMay.setBounds(63, 360, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserMay);
		
		lblMay = new JLabel("MAY");
		lblMay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMay.setBounds(63, 328, 333, 32);
		frameCalendar.getContentPane().add(lblMay);
		
		

		dayChooserJun = new JDayChooser();
		dayChooserJun.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserJun.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedJun(evt);
		});
		Calendar jun = Calendar.getInstance();
		jun.set(Calendar.MONTH, Calendar.JUNE);
		dayChooserJun.setCalendar(jun);
		dayChooserJun.setBounds(443, 360, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserJun);
		
		lblJune = new JLabel("JUNE");
		lblJune.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblJune.setHorizontalAlignment(SwingConstants.CENTER);
		lblJune.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJune.setBounds(443, 328, 333, 32);
		frameCalendar.getContentPane().add(lblJune);
		
		

		dayChooserJul = new JDayChooser();
		dayChooserJul.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserJul.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedJul(evt);
		});
		Calendar jul = Calendar.getInstance();
		jul.set(Calendar.MONTH, Calendar.JULY);
		dayChooserJul.setCalendar(jul);
		dayChooserJul.setBounds(823, 360, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserJul);
		
		lblJuly = new JLabel("JULY");
		lblJuly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblJuly.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJuly.setBounds(823, 328, 333, 32);
		frameCalendar.getContentPane().add(lblJuly);
		
		

		dayChooserAug = new JDayChooser();
		dayChooserAug.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserAug.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedAug(evt);
		});
		Calendar aug = Calendar.getInstance();
		aug.set(Calendar.MONTH, Calendar.AUGUST);
		dayChooserAug.setCalendar(aug);
		dayChooserAug.setBounds(1203, 360, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserAug);
		
		lblAugust = new JLabel("AUGUST");
		lblAugust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblAugust.setHorizontalAlignment(SwingConstants.CENTER);
		lblAugust.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAugust.setBounds(1203, 328, 333, 32);
		frameCalendar.getContentPane().add(lblAugust);
		
		

		dayChooserSept = new JDayChooser();
		dayChooserSept.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserSept.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedSept(evt);
		});
		Calendar sept = Calendar.getInstance();
		sept.set(Calendar.MONTH, Calendar.SEPTEMBER);
		dayChooserSept.setCalendar(sept);
		dayChooserSept.setBounds(63, 610, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserSept);
		
		lblSeptember = new JLabel("SEPTEMBER");
		lblSeptember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblSeptember.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeptember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeptember.setBounds(63, 578, 333, 32);
		frameCalendar.getContentPane().add(lblSeptember);
		
		

		dayChooserOct = new JDayChooser();
		dayChooserOct.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserOct.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedOct(evt);
		});
		Calendar oct = Calendar.getInstance();
		oct.set(Calendar.MONTH, Calendar.OCTOBER);
		dayChooserOct.setCalendar(oct);
		dayChooserOct.setBounds(443, 610, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserOct);
		
		lblOctober = new JLabel("OCTOBER");
		lblOctober.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblOctober.setHorizontalAlignment(SwingConstants.CENTER);
		lblOctober.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOctober.setBounds(443, 578, 333, 32);
		frameCalendar.getContentPane().add(lblOctober);
		
		

		dayChooserNov = new JDayChooser();
		dayChooserNov.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserNov.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedNov(evt);
		});
		Calendar nov = Calendar.getInstance();
		nov.set(Calendar.MONTH, Calendar.NOVEMBER);
		dayChooserNov.setCalendar(nov);
		dayChooserNov.setBounds(823, 610, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserNov);
		
		lblNovember = new JLabel("NOVEMBER");
		lblNovember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblNovember.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovember.setBounds(823, 578, 333, 32);
		frameCalendar.getContentPane().add(lblNovember);
		
		

		dayChooserDec = new JDayChooser();
		dayChooserDec.getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dayChooserDec.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertyChangedDec(evt);
		});
		Calendar dec = Calendar.getInstance();
		dec.set(Calendar.MONTH, Calendar.DECEMBER);
		dayChooserDec.setCalendar(dec);
		dayChooserDec.setBounds(1203, 610, 333, 220);
		getframeCalendar().getContentPane().add(dayChooserDec);
		
		lblDecember = new JLabel("DECEMBER");
		lblDecember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAppointments windowViewAppointments;
				try {
					windowViewAppointments = new ViewAppointments();
					windowViewAppointments.getframeViewAppointments().setVisible(false);
					frameCalendar.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		lblDecember.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDecember.setBounds(1203, 578, 333, 32);
		frameCalendar.getContentPane().add(lblDecember);
		
		lblNewYear = new JLabel("2017");
		lblNewYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewYear.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewYear.setBounds(750, 26, 112, 43);
		frameCalendar.getContentPane().add(lblNewYear);
		
		
	}

	private Window setframeAppointments() {
		return null;
	}

	private JCalendar dayChooserJan() {
		return null;
	}

	private Window getdayChooserJan() {
		return null;
	}

	private void setdayChooserJan(JDayChooser jDayChooser) {

	}

	// to click the day in the calendar and open Appointments
	private void dateChooserPropertyChangedJan(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserJan.getDay()), "JANUARY");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	

	private void dateChooserPropertyChangedFeb(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserFeb.getDay()), "FEBRUARY");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	private void dateChooserPropertyChangedMar(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserMar.getDay()), "MARCH");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	private void dateChooserPropertyChangedApr(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserApr.getDay()), "APRIL");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	private void dateChooserPropertyChangedMay(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserMay.getDay()), "MAY");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	private void dateChooserPropertyChangedJun(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserJun.getDay()), "JUNE");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	private void dateChooserPropertyChangedJul(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserJul.getDay()), "JULY");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	private void dateChooserPropertyChangedAug(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserAug.getDay()), "AUGUST");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	private void dateChooserPropertyChangedSept(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserSept.getDay()), "SEPTEMBER");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	private void dateChooserPropertyChangedOct(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserOct.getDay()), "OCTOBER");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	private void dateChooserPropertyChangedNov(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserNov.getDay()), "NOVEMBER");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}
	
	private void dateChooserPropertyChangedDec(PropertyChangeEvent evt) {
		Appointments windowAppointments = new Appointments(String.valueOf(dayChooserDec.getDay()), "DECEMBER");
		windowAppointments.getframeAppointments().setVisible(true);
		getframeCalendar().setVisible(false);
	}

	public JFrame getframeCalendar() {
		return frameCalendar;
	}

	public void setframeCalendar(JFrame frameCalendar) {
		this.frameCalendar = frameCalendar;
	}
}
