import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class CustomerSearchFlights {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 *///////
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSearchFlights window = new CustomerSearchFlights();
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
	public CustomerSearchFlights() {
		initialize();
	}
	
	
	

	private JTable table;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbAvailable_Flights = new JLabel("Available Flights");
		lbAvailable_Flights.setHorizontalAlignment(SwingConstants.CENTER);
		lbAvailable_Flights.setBounds(250, 6, 121, 16);
		frame.getContentPane().add(lbAvailable_Flights);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 219, 588, 16);
		frame.getContentPane().add(separator);
		
		JLabel lbDeparture_City = new JLabel("Departure City");
		lbDeparture_City.setBounds(69, 269, 102, 16);
		frame.getContentPane().add(lbDeparture_City);
		
		JLabel lbDestination_City = new JLabel("Destination City");
		lbDestination_City.setBounds(69, 316, 102, 16);
		frame.getContentPane().add(lbDestination_City);
		
		JButton btnGo_Back = new JButton("Go Back");
		btnGo_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerScreen c1 = new CustomerScreen();
				c1.newScreen();
				frame.dispose();
			}
		});
		btnGo_Back.setBounds(6, 443, 117, 29);
		frame.getContentPane().add(btnGo_Back);
		
		JButton btnAdd_Flight = new JButton("Book Flight");
		btnAdd_Flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd_Flight.setBounds(301, 360, 117, 29);
		frame.getContentPane().add(btnAdd_Flight);
		
		JButton btnShowAllFlights = new JButton("Show all Flights");
		btnShowAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					table.setModel(DbUtils.resultSetToTableModel(Queries.showFLights()));
				
				
				} catch (Exception exc) {
				exc.printStackTrace();
			}
	}
		});
		btnShowAllFlights.setBounds(121, 360, 143, 29);
		frame.getContentPane().add(btnShowAllFlights);
		
		table = new JTable();
		table.setBounds(6, 34, 588, 154);
		frame.getContentPane().add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(212, 265, 361, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox DestinationBox = new JComboBox();
		DestinationBox.setBounds(212, 312, 159, 27);
		frame.getContentPane().add(DestinationBox);
	}
	
		
	
}
	


	

