import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class CustomerSearchFlights {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 *///////
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSearchFlights window = new CustomerSearchFlights();
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
	public CustomerSearchFlights() {
		initialize();
	}
	
	
	

	private JTable table;
	private JTextField textField;
	private JTextField txtBookFlight;

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
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 219, 588, 16);
		frame.getContentPane().add(separator);
		
		JLabel lbDeparture_City = new JLabel("Departure City");
		lbDeparture_City.setBounds(69, 284, 102, 16);
		frame.getContentPane().add(lbDeparture_City);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerScreen c1 = new CustomerScreen();
				c1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 443, 117, 29);
		frame.getContentPane().add(btnGo_Back);
		
		JButton btnAddFlight = new JButton("Book Flight");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Book Flight Button Pressed");
				
			}
		});
		btnAddFlight.setBounds(416, 360, 117, 29);
		frame.getContentPane().add(btnAddFlight);
		
		JButton btnShowAllFlights = new JButton("Show all Flights");
		btnShowAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					table.setModel(DbUtils.resultSetToTableModel(Queries.showFLights()));
				
				
				} catch (Exception exc) {
				exc.printStackTrace();
			}
	}
		});
		btnShowAllFlights.setBounds(216, 307, 143, 29);
		frame.getContentPane().add(btnShowAllFlights);
		
		table = new JTable();
		table.setBounds(6, 34, 588, 154);
		frame.getContentPane().add(table);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(261, 247, 61, 16);
		frame.getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(205, 279, 182, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(6, 332, 588, 16);
		frame.getContentPane().add(separator_1);
		
		JButton btnSearchCity = new JButton("Search");
		btnSearchCity.setBounds(416, 279, 117, 29);
		frame.getContentPane().add(btnSearchCity);
		
		txtBookFlight = new JTextField();
		txtBookFlight.setBounds(205, 363, 182, 26);
		frame.getContentPane().add(txtBookFlight);
		txtBookFlight.setColumns(10);
		
		JLabel lblBookFlightid = new JLabel("Book Flight (id)");
		lblBookFlightid.setBounds(62, 365, 111, 16);
		frame.getContentPane().add(lblBookFlightid);
	}
}
	


	

