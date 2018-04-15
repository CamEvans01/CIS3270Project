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

public class My_Account {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					My_Account window = new My_Account();
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
	public My_Account() {
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
		
		JList list = new JList();
		list.setBounds(100, 160, 450, 180);
		frame.getContentPane().add(list);
		
		JButton btnRemove_Flight = new JButton("Remove Flight");
		btnRemove_Flight.setBounds(259, 375, 117, 29);
		frame.getContentPane().add(btnRemove_Flight);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Screen c1 = new Customer_Screen();
				c1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 493, 117, 29);
		frame.getContentPane().add(btnGo_Back);
	}
}
