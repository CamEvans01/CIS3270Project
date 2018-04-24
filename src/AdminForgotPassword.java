

import java.awt.EventQueue;
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
//class for admin to recover password
public class AdminForgotPassword extends JFrame{

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
					AdminForgotPassword window = new AdminForgotPassword();
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
	public AdminForgotPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		//create object to verify criteria
		VerifyInput ans1 = new VerifyInput();
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("Admin Forgot Password");
		lblForgotPassword.setBounds(202, 35, 166, 16);
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
				
				//get username from textfield
				String username = txtUsername.getText();
				
				//set textfield to display security question based with the user's username as parameter
				txtQuestion.setText(Queries.forgotAdminPassword(username));

				//find answer and password from query using user's username as parameter
				String answer = Queries.adminAnswer(username);
				String password = Queries.fetchAdminPassword(username);
				
				//set the answer and password to verifyInput object to be used later
				ans1.setAnswer(answer);
				ans1.setPassword(password);
				
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
				
				//get answer from text field
				String myAnswer = txtAnswer.getText();
				System.out.println(myAnswer);

				//send entered answer from textfield to object for verification
				ans1.setMyAnswer(myAnswer);
				System.out.println(ans1);

				//if the answer is correct...
				if(ans1.isCorrect()) {
				
					//display password in text field 
					txtmyPassword.setText(ans1.getPassword());
					
				}else {
					//display wrong answer message
					JOptionPane.showMessageDialog(null, "incorrect answer", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
				
			
		);
		btnEnter_Answer.setBounds(419, 308, 117, 29);
		frame.getContentPane().add(btnEnter_Answer);
		
		JLabel lblNewLabel_1 = new JLabel("Your Password");
		lblNewLabel_1.setBounds(45, 379, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtmyPassword = new JFormattedTextField();
		txtmyPassword.setBounds(202, 379, 166, 21);
		frame.getContentPane().add(txtmyPassword);
		
		JButton btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//return to main menu
				ReturnToMain m1 = new ReturnToMain();
				m1.returnHome();
				frame.dispose();
				
			}
		});
		btnReturnToLogin.setBounds(202, 443, 147, 29);
		frame.getContentPane().add(btnReturnToLogin);
	}
}
