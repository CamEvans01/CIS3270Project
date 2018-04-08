import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
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
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(279, 6, 90, 16);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(87, 142, 75, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(87, 228, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin");
		lblNewLabel_2.setBounds(98, 78, 75, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Customer");
		lblNewLabel_3.setBounds(449, 78, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setBounds(449, 142, 83, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(449, 228, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnAdminLogin = new JButton("Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminLogin.setBounds(62, 330, 117, 29);
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnAdminRegister = new JButton("Register");
		btnAdminRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminRegister.setBounds(62, 400, 117, 29);
		frame.getContentPane().add(btnAdminRegister);
		
		JButton btnCustomerLogin = new JButton("Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomerLogin.setBounds(426, 330, 117, 29);
		frame.getContentPane().add(btnCustomerLogin);
		
		JButton btnCustomerRegister = new JButton("Register");
		btnCustomerRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomerRegister.setBounds(426, 400, 117, 29);
		frame.getContentPane().add(btnCustomerRegister);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(62, 270, 117, 16);
		frame.getContentPane().add(textPane);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(62, 178, 117, 26);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(426, 170, 117, 26);
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(426, 270, 117, 26);
		frame.getContentPane().add(formattedTextField_2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(301, 78, 10, 351);
		frame.getContentPane().add(separator);
		frame.setVisible(true);
	}
}
