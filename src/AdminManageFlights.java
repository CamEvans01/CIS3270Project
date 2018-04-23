import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

//class for admin add and remove flights flights 
public class AdminManageFlights {

	private JFrame frame;
	private JTextField txtDepartureCity;
	private JTextField txtArrivalCity;
	private JTextField txtDepartureDate;
	private JTextField txtDepartureTime;
	private JTable table;
	private JTextField txtArrivalDate;
	private JTextField txtArrivalTime;
	private JTextField txtRemoveFlight;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManageFlights window = new AdminManageFlights();
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
	public AdminManageFlights() {
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

		JButton btnRemoveFlight = new JButton("Remove Flight");
		btnRemoveFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get flight id to be removed from textfield and cast to int
				String idString = txtRemoveFlight.getText();
				int idNumber = Integer.parseInt(idString);
				
				//if the flight exists based on it's id
				if (Queries.checkFlightId(idNumber)) {
				try {
					
					//remove flight using query
					Queries.removeFlight(idNumber);
					
					//show confirmation with pop up
					JOptionPane.showMessageDialog(null, "flight added", "Success", JOptionPane.INFORMATION_MESSAGE);
				
				} catch (Exception exc) {
					exc.printStackTrace();
				
				}
				}else {
					
					//display failure message pop up
					JOptionPane.showMessageDialog(null, "Invalid Flight", "Failure", JOptionPane.ERROR_MESSAGE);
				}
				
				txtRemoveFlight.setText("");

			}
		});
		btnRemoveFlight.setBounds(315, 444, 117, 29);
		frame.getContentPane().add(btnRemoveFlight);

		txtDepartureCity = new JTextField();
		txtDepartureCity.setBounds(156, 267, 291, 26);
		frame.getContentPane().add(txtDepartureCity);
		txtDepartureCity.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(27, 243, 567, 12);
		frame.getContentPane().add(separator);

		JLabel lbDeparture_City = new JLabel("Departure City");
		lbDeparture_City.setBounds(27, 267, 102, 16);
		frame.getContentPane().add(lbDeparture_City);

		JLabel lbArrivalCity = new JLabel("Arrival City");
		lbArrivalCity.setBounds(27, 346, 102, 16);
		frame.getContentPane().add(lbArrivalCity);

		JLabel lbDepartureDate = new JLabel("Departure Date");
		lbDepartureDate.setBounds(27, 295, 102, 16);
		frame.getContentPane().add(lbDepartureDate);

		JLabel lbDepartureTime = new JLabel("Departure Time");
		lbDepartureTime.setBounds(27, 318, 102, 16);
		frame.getContentPane().add(lbDepartureTime);

		txtArrivalCity = new JTextField();
		txtArrivalCity.setBounds(156, 341, 291, 26);
		frame.getContentPane().add(txtArrivalCity);
		txtArrivalCity.setColumns(10);

		txtDepartureDate = new JTextField();
		txtDepartureDate.setBounds(156, 290, 291, 26);
		frame.getContentPane().add(txtDepartureDate);
		txtDepartureDate.setColumns(10);

		txtDepartureTime = new JTextField();
		txtDepartureTime.setBounds(156, 313, 291, 26);
		frame.getContentPane().add(txtDepartureTime);
		txtDepartureTime.setColumns(10);

		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new admin screen 
				AdminScreen a1 = new AdminScreen();
				a1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(0, 493, 117, 29);
		frame.getContentPane().add(btnGo_Back);

		JButton btnAddFlight = new JButton("Add Flight");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new flights object to hold flight data
				Flights f1 = new Flights();
				
				//insert flight data to flights class
				f1.departureCity = txtDepartureCity.getText();
				f1.departureDate = txtDepartureDate.getText();
				f1.departureTime = txtDepartureTime.getText();
				f1.arrivalCity = txtArrivalCity.getText();
				f1.arrivalDate = txtArrivalDate.getText();
				f1.arrivalTime = txtArrivalTime.getText();

				//insert data into query to add flight
				try {
					Queries.addFlights(f1);
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				//show success message and make text fields blank
				JOptionPane.showMessageDialog(null, "flight added", "Success", JOptionPane.INFORMATION_MESSAGE);
				txtDepartureCity.setText("");
				txtDepartureDate.setText("");
				txtDepartureTime.setText("");
				txtArrivalCity.setText("");
				txtArrivalDate.setText("");
				txtArrivalTime.setText("");

			}
		});
		btnAddFlight.setBounds(458, 290, 117, 29);
		frame.getContentPane().add(btnAddFlight);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//refresh screen and show flights
				try {

					table.setModel(DbUtils.resultSetToTableModel(Queries.showFLights()));

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(477, 493, 117, 29);
		frame.getContentPane().add(btnRefresh);

		table = new JTable();
		table.setBounds(17, 58, 577, 173);
		frame.getContentPane().add(table);

		JButton btnShowAllFlights = new JButton("Show All Flights");
		btnShowAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//show all flights 
				try {
					

					table.setModel(DbUtils.resultSetToTableModel(Queries.showFLights()));

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnShowAllFlights.setBounds(454, 361, 140, 29);
		frame.getContentPane().add(btnShowAllFlights);

		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setBounds(27, 374, 102, 16);
		frame.getContentPane().add(lblArrivalDate);

		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(27, 402, 102, 16);
		frame.getContentPane().add(lblArrivalTime);

		txtArrivalDate = new JTextField();
		txtArrivalDate.setBounds(156, 369, 291, 26);
		frame.getContentPane().add(txtArrivalDate);
		txtArrivalDate.setColumns(10);

		txtArrivalTime = new JTextField();
		txtArrivalTime.setBounds(156, 397, 291, 26);
		frame.getContentPane().add(txtArrivalTime);
		txtArrivalTime.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(27, 430, 567, 12);
		frame.getContentPane().add(separator_1);

		JLabel lblRemoveFlight = new JLabel("Remove Flight (id)");
		lblRemoveFlight.setBounds(27, 449, 117, 16);
		frame.getContentPane().add(lblRemoveFlight);

		txtRemoveFlight = new JTextField();
		txtRemoveFlight.setBounds(152, 444, 130, 26);
		frame.getContentPane().add(txtRemoveFlight);
		txtRemoveFlight.setColumns(10);
	}
}
