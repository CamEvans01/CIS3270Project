import java.awt.EventQueue;

//For SQL
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Customer_Screen extends JFrame{
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Screen window = new Customer_Screen();
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
	public Customer_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbWelcome = new JLabel("Welcome");
		lbWelcome.setBounds(144, 6, 71, 16);
		lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbWelcome);
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.setBounds(112, 86, 130, 50);
		frame.getContentPane().add(btnMyAccount);
		
		JButton btnSearch = new JButton("Search Flights");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(112, 200, 130, 50);
		frame.getContentPane().add(btnSearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(6, 343, 117, 29);
		frame.getContentPane().add(btnLogout);
	}

}
