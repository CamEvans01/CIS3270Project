
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//class used to register new admins
public class AdminRegister extends JFrame {

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
					AdminRegister window = new AdminRegister();
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
	public AdminRegister() {
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

		JLabel lblNewAdmnin = new JLabel("New Admin");
		lblNewAdmnin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAdmnin.setBounds(271, 6, 95, 16);
		frame.getContentPane().add(lblNewAdmnin);

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
		lblNewLabel_8.setBounds(37, 404, 120, 16);
		frame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Security Answer");
		lblNewLabel_9.setBounds(37, 442, 120, 16);
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
		txtQuestion.setBounds(180, 399, 370, 26);
		frame.getContentPane().add(txtQuestion);
		txtQuestion.setColumns(10);

		txtAnswer = new JTextField();
		txtAnswer.setBounds(180, 437, 370, 26);
		frame.getContentPane().add(txtAnswer);
		txtAnswer.setColumns(10);

		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// create valueObject object to hold values entered from text fields
				ValueObject vo = new ValueObject();
				vo.firstName = txtFirst_Name.getText();
				vo.lastName = txtLast_Name.getText();
				vo.address = txtAddress.getText();
				vo.zipcode = txtZipcode.getText();
				vo.state = txtState.getText();
				vo.username = txtUsername.getText();
				vo.password = txtPassword.getText();
				vo.email = txtEmail.getText();
				vo.ssn = txtSsn.getText();
				vo.question = txtQuestion.getText();
				vo.answer = txtAnswer.getText();

				// send object to query to create new object
				try {
					Queries.newAdmin(vo);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				txtFirst_Name.setText(" ");
				txtLast_Name.setText(" ");
				txtAddress.setText(" ");
				txtZipcode.setText(" ");
				txtState.setText(" ");
				txtUsername.setText(" ");
				txtPassword.setText(" ");
				txtEmail.setText(" ");
				txtSsn.setText(" ");
				txtQuestion.setText(" ");
				txtAnswer.setText(" ");
				JOptionPane.showMessageDialog(null, "Admin Created", "Update", JOptionPane.INFORMATION_MESSAGE);

			}

		});
		btnCreateAccount.setBounds(271, 493, 130, 29);
		frame.getContentPane().add(btnCreateAccount);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//return to main menu
				ReturnToMain m1 = new ReturnToMain();
				m1.returnHome();
				frame.dispose();
			}
		});
		btnMainMenu.setBounds(0, 1, 117, 29);
		frame.getContentPane().add(btnMainMenu);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(37, 376, 61, 16);
		frame.getContentPane().add(lblSsn);

		txtSsn = new JTextField();
		txtSsn.setBounds(180, 371, 370, 26);
		frame.getContentPane().add(txtSsn);
		txtSsn.setColumns(10);
	}
}
