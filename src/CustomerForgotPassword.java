import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class CustomerForgotPassword extends JFrame{
	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtAnswer;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForgotPassword window = new CustomerForgotPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextPane txtQuestion;
	private JFormattedTextField txtmyPassword;
	/**
	 * Create the application.
	 */
	public CustomerForgotPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		VerifyInput ans1 = new VerifyInput();

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("Customer Forgot Password");
		lblForgotPassword.setBounds(202, 35, 183, 16);
		frame.getContentPane().add(lblForgotPassword);
		
		JLabel lbEnter_Username = new JLabel("Enter Username");
		lbEnter_Username.setHorizontalAlignment(SwingConstants.CENTER);
		lbEnter_Username.setBounds(46, 115, 133, 16);
		frame.getContentPane().add(lbEnter_Username);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(202, 110, 166, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnEnter_Username = new JButton("Enter");
		btnEnter_Username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Username Button Pressed");
				
				//get username from textfield
				String username = txtUsername.getText();
				System.out.println(username);
				
				//set textfield to display security question based on the user's username as parameter
				try {
				if (Queries.checkCustomerUsernameExists(username) == false) {
					JOptionPane.showMessageDialog(null, "Username doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
				txtQuestion.setText(Queries.forgotCustomerPassword(username));
				System.out.println("Break");
				
				}catch(Exception exc) {
					exc.printStackTrace();
				}
				
				//find answer and password from query using user's username as parameter
				String answer = Queries.customerAnswer(username);
				System.out.println("Break");

				String password = Queries.fetchCustomerPassword(username);
				System.out.println("Break");

				//set the answer and password to verifyInput object to be used later
				ans1.setAnswer(answer);
				ans1.setPassword(password);
				
				
				System.out.println("Break");

			}

		});
		btnEnter_Username.setBounds(419, 110, 117, 29);
		frame.getContentPane().add(btnEnter_Username);
		
		JLabel lblSecu = new JLabel("Secuirity Question");
		lblSecu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecu.setBounds(202, 171, 147, 16);
		frame.getContentPane().add(lblSecu);
		
		txtQuestion = new JTextPane();
		txtQuestion.setBounds(46, 217, 490, 26);
		frame.getContentPane().add(txtQuestion);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(46, 217, 490, 26);
		frame.getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("Enter Answer");
		lblNewLabel.setBounds(46, 308, 96, 16);
		frame.getContentPane().add(lblNewLabel);
		
		txtAnswer = new JTextField();
		txtAnswer.setBounds(202, 303, 166, 26);
		frame.getContentPane().add(txtAnswer);
		txtAnswer.setColumns(10);
		
		JButton btnEnter_Answer = new JButton("Enter");
		btnEnter_Answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Answer Button Pressed");
				
				//get answer from text field
				String myAnswer = txtAnswer.getText();
				System.out.println(myAnswer);

				
				//send entered answer from textfield to object for verification
					ans1.setMyAnswer(myAnswer);
					System.out.println(ans1.getAnswer());

				
				//if the answer is correct...
				if(ans1.isCorrect()) {
				
					//display password in text field 
					txtmyPassword.setText(ans1.getPassword());
					
				}else {
					//display wrong answer message
					JOptionPane.showMessageDialog(null, "incorrect answer", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
	});
		btnEnter_Answer.setBounds(419, 308, 117, 29);
		frame.getContentPane().add(btnEnter_Answer);
		
		JLabel lblNewLabel_1 = new JLabel("Your Password");
		lblNewLabel_1.setBounds(45, 379, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtmyPassword = new JFormattedTextField();
		txtmyPassword.setBounds(202, 379, 166, 21);
		frame.getContentPane().add(txtmyPassword);
		
		JFormattedTextField txtPassword = new JFormattedTextField();
		txtPassword.setBounds(202, 379, 166, 21);
		frame.getContentPane().add(txtPassword);
		
		JButton btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnToMain m1 = new ReturnToMain();
				m1.returnHome();
				frame.dispose();
				
			}
		});
		btnReturnToLogin.setBounds(202, 443, 147, 29);
		frame.getContentPane().add(btnReturnToLogin);
	}
}
