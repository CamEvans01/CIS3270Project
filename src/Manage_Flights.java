import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manage_Flights {

	private JFrame frame;
	private JTextField txtDeparture;
	private JTextField txtDestination;
	private JTextField txtDate;
	private JTextField txtTime;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Flights window = new Manage_Flights();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Flights() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbEdit_Flights = new JLabel("Edit Flights");
		lbEdit_Flights.setHorizontalAlignment(SwingConstants.CENTER);
		lbEdit_Flights.setBounds(256, 19, 108, 16);
		frame.getContentPane().add(lbEdit_Flights);
		
		JList list = new JList();
		list.setBounds(97, 47, 450, 180);
		frame.getContentPane().add(list);
		
		JButton btnRemove_Flight = new JButton("Remove Flight");
		btnRemove_Flight.setBounds(256, 239, 117, 29);
		frame.getContentPane().add(btnRemove_Flight);
		
		txtDeparture = new JTextField();
		txtDeparture.setBounds(211, 331, 291, 26);
		frame.getContentPane().add(txtDeparture);
		txtDeparture.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(27, 288, 567, 12);
		frame.getContentPane().add(separator);
		
		JLabel lbDeparture_City = new JLabel("Departure City");
		lbDeparture_City.setBounds(97, 336, 102, 16);
		frame.getContentPane().add(lbDeparture_City);
		
		JLabel lbDestination_City = new JLabel("Destination City");
		lbDestination_City.setBounds(97, 369, 102, 16);
		frame.getContentPane().add(lbDestination_City);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setBounds(97, 397, 61, 16);
		frame.getContentPane().add(lbDate);
		
		JLabel lbTime = new JLabel("Time");
		lbTime.setBounds(97, 425, 61, 16);
		frame.getContentPane().add(lbTime);
		
		txtDestination = new JTextField();
		txtDestination.setBounds(211, 359, 291, 26);
		frame.getContentPane().add(txtDestination);
		txtDestination.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(211, 387, 291, 26);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setBounds(211, 420, 291, 26);
		frame.getContentPane().add(txtTime);
		txtTime.setColumns(10);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Screen a1 = new Admin_Screen();
				a1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(0, 493, 117, 29);
		frame.getContentPane().add(btnGo_Back);
		
		JButton btnAdd_Flight = new JButton("Add Flight");
		btnAdd_Flight.setBounds(166, 458, 117, 29);
		frame.getContentPane().add(btnAdd_Flight);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(477, 493, 117, 29);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnSearch_Flights = new JButton("Search Flights");
		btnSearch_Flights.setBounds(385, 458, 117, 29);
		frame.getContentPane().add(btnSearch_Flights);
	}
}
