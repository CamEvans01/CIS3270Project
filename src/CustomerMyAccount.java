import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMyAccount {

	private JFrame frame;
	private JTable table;
	private JTextField txtRemoveFlight;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMyAccount window = new CustomerMyAccount();
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
	public CustomerMyAccount() {
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

		JLabel lbMyAccount = new JLabel("My Account");
		lbMyAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lbMyAccount.setBounds(258, 22, 99, 16);
		frame.getContentPane().add(lbMyAccount);

		JLabel lblBookedFlights = new JLabel("Booked Flights");
		lblBookedFlights.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookedFlights.setBounds(247, 105, 110, 16);
		frame.getContentPane().add(lblBookedFlights);

		// For removing a flight for a customer

		JButton btnRemoveFlight = new JButton("Remove Flight");
		btnRemoveFlight.addActionListener(new ActionListener() {

			// button to remove this customer's flight from Bookings table
			public void actionPerformed(ActionEvent e) {

				System.out.println("Remove Flight Button Pressed");

				// get flight id from textfield and cast to int value
				String stringidFlight = txtRemoveFlight.getText();
				int idFlight = Integer.parseInt(stringidFlight);
				System.out.println(idFlight);

				// if the flight is booked...
				if (Queries.checkMyFlightId(idFlight)) {

					// run query to remove flight based on its id
					try {
						Queries.removeMyFlight(idFlight);

						// show confirmation message
						JOptionPane.showMessageDialog(null, "flight removed", "Success",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						exc.printStackTrace();
					}
				} else {
					// show failure message
					JOptionPane.showMessageDialog(null, "Invalid Flight", "Failure", JOptionPane.ERROR_MESSAGE);
				}
				txtRemoveFlight.setText("");
			}
		});

		btnRemoveFlight.setBounds(334, 375, 117, 29);
		frame.getContentPane().add(btnRemoveFlight);

		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerScreen c1 = new CustomerScreen();
				c1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 493, 117, 29);
		frame.getContentPane().add(btnGo_Back);

		table = new JTable();
		table.setBounds(6, 157, 594, 186);
		frame.getContentPane().add(table);

		JButton btnShowFlights = new JButton("Show FLights");
		btnShowFlights.addActionListener(new ActionListener() {

			// button to show all flights from this customer based on customer's username
			// that is saved as bookingUsername in valueObject class.
			public void actionPerformed(ActionEvent e) {

				System.out.println("Show Flights Button Pressed");

				// show booked flights in table display
				try {

					table.setModel(DbUtils.resultSetToTableModel(Queries.showMyFlights()));

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}

		});
		btnShowFlights.setBounds(247, 61, 117, 29);
		frame.getContentPane().add(btnShowFlights);

		JLabel lbRemoveFlight = new JLabel("Remove Flight (id)");
		lbRemoveFlight.setBounds(34, 380, 117, 16);
		frame.getContentPane().add(lbRemoveFlight);

		// text field for user to enter the id of flight to be removed
		txtRemoveFlight = new JTextField();
		txtRemoveFlight.setColumns(10);
		txtRemoveFlight.setBounds(171, 375, 130, 26);
		frame.getContentPane().add(txtRemoveFlight);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {

			// button to refresh table
			public void actionPerformed(ActionEvent e) {
				try {

					table.setModel(DbUtils.resultSetToTableModel(Queries.showMyFlights()));

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}

		});
		btnRefresh.setBounds(463, 375, 117, 29);
		frame.getContentPane().add(btnRefresh);
	}
}
