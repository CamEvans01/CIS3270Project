
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
//class to allow admins to add and remove personal flights
public class AdminMyAccount {

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
					AdminMyAccount window = new AdminMyAccount();
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
	public AdminMyAccount() {
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
		
		JButton btnRemove_Flight = new JButton("Remove Flight");
		btnRemove_Flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get flight id from textfield and cast to int value
				String stringidFlight = txtRemoveFlight.getText();
				int idFlight = Integer.parseInt(stringidFlight);
				
				//if the flight is booked...
				if (Queries.checkMyFlightId(idFlight)) {
					
				//run query to remove flight based on its id
				try {
				Queries.removeMyFlight(idFlight);
				
				//show confirmation message
				JOptionPane.showMessageDialog(null, "flight removed", "Success", JOptionPane.INFORMATION_MESSAGE);
				
				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}else {
				//show failure message
				JOptionPane.showMessageDialog(null, "Invalid Flight", "Failure", JOptionPane.ERROR_MESSAGE);
			}
				txtRemoveFlight.setText("");
			}
		});
		btnRemove_Flight.setBounds(324, 387, 117, 29);
		frame.getContentPane().add(btnRemove_Flight);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//go back to admin main screen
				AdminScreen a1 = new AdminScreen();
				a1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 493, 117, 29);
		frame.getContentPane().add(btnGo_Back);
		
		table = new JTable();
		table.setBounds(6, 133, 594, 186);
		frame.getContentPane().add(table);
		
		JLabel lblRemoveFlightid = new JLabel("Remove Flight (id)");
		lblRemoveFlightid.setBounds(31, 392, 117, 16);
		frame.getContentPane().add(lblRemoveFlightid);
		
		txtRemoveFlight = new JTextField();
		txtRemoveFlight.setBounds(171, 387, 130, 26);
		frame.getContentPane().add(txtRemoveFlight);
		txtRemoveFlight.setColumns(10);
		
		JButton btnShowFlights = new JButton("Show Flights");
		btnShowFlights.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					//show booked flights in table display 
					try {

						table.setModel(DbUtils.resultSetToTableModel(Queries.showMyFlights()));

					} catch (Exception exc) {
						exc.printStackTrace();
					}
				}
					
			
		});
		btnShowFlights.setBounds(247, 62, 117, 29);
		frame.getContentPane().add(btnShowFlights);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//refresh data in table display
				try {

					table.setModel(DbUtils.resultSetToTableModel(Queries.showMyFlights()));

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
				
		});
		btnRefresh.setBounds(477, 387, 117, 29);
		frame.getContentPane().add(btnRefresh);
	}
		
}
