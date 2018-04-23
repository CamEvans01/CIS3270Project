import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
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
		
		JButton btnRemove_Flight = new JButton("Remove Flight");
		btnRemove_Flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove_Flight.setBounds(334, 375, 117, 29);
		frame.getContentPane().add(btnRemove_Flight);
		
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
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowFlights.setBounds(247, 61, 117, 29);
		frame.getContentPane().add(btnShowFlights);
		
		JLabel lbRemoveFlight = new JLabel("Remove Flight (id)");
		lbRemoveFlight.setBounds(34, 380, 117, 16);
		frame.getContentPane().add(lbRemoveFlight);
		
		txtRemoveFlight = new JTextField();
		txtRemoveFlight.setColumns(10);
		txtRemoveFlight.setBounds(171, 375, 130, 26);
		frame.getContentPane().add(txtRemoveFlight);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(463, 375, 117, 29);
		frame.getContentPane().add(btnRefresh);
	}
}
