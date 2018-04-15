import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Forgot_Password extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_Password window = new Forgot_Password();
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
	public Forgot_Password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setBounds(236, 35, 113, 16);
		frame.getContentPane().add(lblForgotPassword);
		
		JLabel lbEnter_Username = new JLabel("Enter Username");
		lbEnter_Username.setHorizontalAlignment(SwingConstants.CENTER);
		lbEnter_Username.setBounds(46, 115, 133, 16);
		frame.getContentPane().add(lbEnter_Username);
		
		textField = new JTextField();
		textField.setBounds(202, 110, 166, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnter_Username = new JButton("Enter");
		btnEnter_Username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter_Username.setBounds(419, 110, 117, 29);
		frame.getContentPane().add(btnEnter_Username);
		
		JLabel lblSecu = new JLabel("Secuirity Question");
		lblSecu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecu.setBounds(202, 171, 147, 16);
		frame.getContentPane().add(lblSecu);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(46, 217, 490, 26);
		frame.getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("Enter Answer");
		lblNewLabel.setBounds(46, 308, 96, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 303, 166, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEnter_Answer = new JButton("Enter");
		btnEnter_Answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter_Answer.setBounds(419, 308, 117, 29);
		frame.getContentPane().add(btnEnter_Answer);
		
		JLabel lblNewLabel_1 = new JLabel("Your Password");
		lblNewLabel_1.setBounds(45, 379, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(202, 379, 166, 21);
		frame.getContentPane().add(formattedTextField);
		
		JButton btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return_To_Main m1 = new Return_To_Main();
				m1.returnHome();
				frame.dispose();
				
			}
		});
		btnReturnToLogin.setBounds(202, 443, 147, 29);
		frame.getContentPane().add(btnReturnToLogin);
	}
}
