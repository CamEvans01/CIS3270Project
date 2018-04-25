import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private JTextField txtSearchCity;

	

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
	private JTextField txtDepartureCity;
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
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.addActionListener(new ActionListener() {
			
			//button to to book flight and add it to Bookings table
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Book Flight Button Pressed");
				
				//get flights id from text field and parse to int value
				String stringidFlight = txtBookFlight.getText();
				int idFlight = Integer.parseInt(stringidFlight);
				
				//send flight id to queries to gather information
				String departureCity = Queries.fetchDepartureCity(idFlight);
				String departureDate = Queries.fetchDepartureDate(idFlight);
				String departureTime = Queries.fetchArrivalTime(idFlight);
				String arrivalCity = Queries.fetchArrivalCity(idFlight);
				String arrivalDate = Queries.fetchArrivalDate(idFlight);
				String arrivalTime = Queries.fetchDepartureTime(idFlight);
				
				//check if the flight exists
				if (Queries.checkFlightId(idFlight)) {
				
					//insert data into bookflight table
					try {
					Queries.bookFlight(idFlight, ValueObject.bookingUsername, departureCity, departureDate, departureTime, 
							arrivalCity,arrivalDate, arrivalTime);
					
					//pop up message to confirm booked flight
					JOptionPane.showMessageDialog(null, "flight booked", "update", JOptionPane.INFORMATION_MESSAGE);
				
					} catch (Exception exc) {
					exc.printStackTrace();
				}
					
			}else {
				//pop up message to show flight doesn't exist
				JOptionPane.showMessageDialog(null, "Invalid Flight", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
				
			}
		});
		btnBookFlight.setBounds(416, 360, 117, 29);
		frame.getContentPane().add(btnBookFlight);
		
		JButton btnShowAllFlights = new JButton("Show all Flights");
		btnShowAllFlights.addActionListener(new ActionListener() {
			
			//button to show all flights available from Flights table
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
		
		//text field for user to type in departure city

		txtSearchCity = new JTextField();
		txtSearchCity.setBounds(235, 281, 177, 26);
		frame.getContentPane().add(txtSearchCity);
		txtSearchCity.setColumns(10);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(261, 247, 61, 16);
		frame.getContentPane().add(lblSearch);
	
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(6, 332, 588, 16);
		frame.getContentPane().add(separator_1);
		
		JButton btnSearchCity = new JButton("Search");
		btnSearchCity.addActionListener(new ActionListener() {
			
			//button to show all flights in Flight table
			public void actionPerformed(ActionEvent e) {
				//get city name from text field
				String city = txtSearchCity.getText();
				
				//if the city exists...
				if (Queries.checkFlight(city)) {
					try {
						//display searched-for city in table display
						table.setModel(DbUtils.resultSetToTableModel(Queries.searchByDepartureCity(city)));

					} catch (Exception exc) {
						exc.printStackTrace();

					}
				} else {
					//show message that city doesn't exist
					JOptionPane.showMessageDialog(null, "Invalid City", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnSearchCity.setBounds(416, 279, 117, 29);
		frame.getContentPane().add(btnSearchCity);
		
		//text field to hold the flight id of the flight the user wishes to book 
		txtBookFlight = new JTextField();
		txtBookFlight.setBounds(205, 363, 182, 26);
		frame.getContentPane().add(txtBookFlight);
		txtBookFlight.setColumns(10);
		
		JLabel lblBookFlightid = new JLabel("Book Flight (id)");
		lblBookFlightid.setBounds(62, 365, 111, 16);
		frame.getContentPane().add(lblBookFlightid);
	}
}
	


	

