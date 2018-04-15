import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book_Flight {

	private JFrame frame;
	private JTextField txtDeparture;
	private JTextField txtDestination;
	private JTextField txtDate;
	private JTextField txtTime;

	/**
	 * Launch the application.
	 *///////
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Flight window = new Book_Flight();
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
	public Book_Flight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbAvailable_Flights = new JLabel("Available Flights");
		lbAvailable_Flights.setHorizontalAlignment(SwingConstants.CENTER);
		lbAvailable_Flights.setBounds(250, 6, 121, 16);
		frame.getContentPane().add(lbAvailable_Flights);
		
		JList list = new JList();
		list.setBounds(35, 43, 545, 161);
		frame.getContentPane().add(list);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 219, 588, 16);
		frame.getContentPane().add(separator);
		
		JLabel lbDeparture_City = new JLabel("Departure City");
		lbDeparture_City.setBounds(65, 270, 102, 16);
		frame.getContentPane().add(lbDeparture_City);
		
		JLabel lbDestination_City = new JLabel("Destination City");
		lbDestination_City.setBounds(65, 298, 102, 16);
		frame.getContentPane().add(lbDestination_City);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setBounds(65, 326, 61, 16);
		frame.getContentPane().add(lbDate);
		
		JLabel lbTime = new JLabel("Time");
		lbTime.setBounds(65, 354, 61, 16);
		frame.getContentPane().add(lbTime);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Screen c1 = new Customer_Screen();
				c1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 443, 117, 29);
		frame.getContentPane().add(btnGo_Back);
		
		txtDeparture = new JTextField();
		txtDeparture.setColumns(10);
		txtDeparture.setBounds(209, 265, 291, 26);
		frame.getContentPane().add(txtDeparture);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(209, 293, 291, 26);
		frame.getContentPane().add(txtDestination);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(209, 321, 291, 26);
		frame.getContentPane().add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(209, 349, 291, 26);
		frame.getContentPane().add(txtTime);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(219, 387, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnAdd_Flight = new JButton("Book Flight");
		btnAdd_Flight.setBounds(364, 387, 117, 29);
		frame.getContentPane().add(btnAdd_Flight);
	}
}
