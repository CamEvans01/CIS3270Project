import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomerRegister extends JFrame {

    private JFrame frame;
	private JTextField txtFirst_Name;
	private JTextField txtLast_Name;
	private JTextField txtAddress;
	private JTextField txtZipcode;
	private JTextField txtState;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTextField txtQuestion;
	private JTextField txtAnswer;
	private JTextField txtSsn;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegister window = new CustomerRegister();
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
	public CustomerRegister() {
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
		
		JLabel btnNew_Customer = new JLabel("New Customer");
		btnNew_Customer.setHorizontalAlignment(SwingConstants.CENTER);
		btnNew_Customer.setBounds(271, 6, 110, 16);
		frame.getContentPane().add(btnNew_Customer);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(37, 75, 80, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(37, 113, 80, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(37, 151, 80, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Zipcode");
		lblNewLabel_3.setBounds(37, 189, 80, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("State");
		lblNewLabel_4.setBounds(37, 227, 80, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setBounds(37, 265, 80, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(37, 303, 80, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(37, 341, 80, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Security Question");
		lblNewLabel_8.setBounds(37, 406, 120, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Security Answer");
		lblNewLabel_9.setBounds(37, 444, 120, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		txtFirst_Name = new JTextField();
		txtFirst_Name.setBounds(180, 70, 370, 26);
		frame.getContentPane().add(txtFirst_Name);
		txtFirst_Name.setColumns(10);
		
		txtLast_Name = new JTextField();
		txtLast_Name.setBounds(180, 113, 370, 26);
		frame.getContentPane().add(txtLast_Name);
		txtLast_Name.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(180, 151, 370, 26);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtZipcode = new JTextField();
		txtZipcode.setBounds(180, 189, 370, 26);
		frame.getContentPane().add(txtZipcode);
		txtZipcode.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(180, 227, 370, 26);
		frame.getContentPane().add(txtState);
		txtState.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(180, 265, 370, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(180, 303, 370, 26);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(180, 341, 370, 26);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtQuestion = new JTextField();
		txtQuestion.setBounds(180, 401, 370, 26);
		frame.getContentPane().add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtAnswer = new JTextField();
		txtAnswer.setBounds(180, 439, 370, 26);
		frame.getContentPane().add(txtAnswer);
		txtAnswer.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Create Account Button Pressed");
				
				// create valueObject object to hold values entered from text fields
				ValueObject vo = new ValueObject();
				vo.setFirstName(txtFirst_Name.getText());
				vo.setLastName(txtLast_Name.getText());
				vo.setAddress(txtAddress.getText());
				vo.setZipcode(txtZipcode.getText());
				vo.setState(txtState.getText());
				vo.setUsername(txtUsername.getText());
				vo.setPassword(txtPassword.getText());
				vo.setEmail(txtEmail.getText());
				vo.setSsn(txtSsn.getText());
				vo.setSecurityQuestion(txtQuestion.getText());
				vo.setAnswer(txtAnswer.getText());
				
				VerifyInput v1 = new VerifyInput();
				if (v1.firstNameAllLetters(vo) == false || v1.lastNameAllLetters(vo) == false) {
					JOptionPane.showMessageDialog(null, "Enter a valid first and last name", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if(txtAddress.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter value for address", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(v1.zipcodeVerify(vo) == false){
					JOptionPane.showMessageDialog(null, "zipcode must be 5 digits long", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if(v1.stateAllLetters(vo) == false){
					JOptionPane.showMessageDialog(null, "State must contain letters only", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if(txtUsername.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter value for username", "Error", JOptionPane.ERROR_MESSAGE);
						
				}else if(Queries.checkCustomerUsernameExists(vo.getUsername())) {
					JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if (txtPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter value for password", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if(v1.emailVerify(vo) == false) {
					JOptionPane.showMessageDialog(null, "Enter a valid email address: x@x.com", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(Queries.checkCustomerEmailExists(vo.getEmail())) {
					//JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if(v1.ssnVerify(vo) == false){
					JOptionPane.showMessageDialog(null, "SSN must be 9 digits long", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(Queries.checkCustomerSSNExists(vo.getSsn())) {
					//JOptionPane.showMessageDialog(null, "SSN already exists", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else if (txtQuestion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter a security question", "Error", JOptionPane.ERROR_MESSAGE);
						
				}else if (txtAnswer.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter an answer", "Error", JOptionPane.ERROR_MESSAGE);
				
				}else {

				// send object to query to create new object
				try {
					Queries.newCustomer(vo);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				txtFirst_Name.setText("");
				txtLast_Name.setText("");
				txtAddress.setText("");
				txtZipcode.setText("");
				txtState.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				txtEmail.setText("");
				txtSsn.setText("");
				txtQuestion.setText("");
				txtAnswer.setText("");
				JOptionPane.showMessageDialog(null, "Customer Created", "Update", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		
		btnCreateAccount.setBounds(271, 493, 130, 29);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnToMain m1 = new ReturnToMain();
				m1.returnHome();
				frame.dispose();
			}
		});
		btnMainMenu.setBounds(0, 1, 117, 29);
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(37, 378, 61, 16);
		frame.getContentPane().add(lblSsn);
		
		txtSsn = new JTextField();
		txtSsn.setBounds(180, 373, 370, 26);
		frame.getContentPane().add(txtSsn);
		txtSsn.setColumns(10);
	}
}
