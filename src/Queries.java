import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListModel;

//class to hold all queries 
public class Queries {
	

	// query to add flight to Flights table using critera from Flights object
	public static void addFlights(Flights f1) {

		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// insert data into Flights table
			String query = "insert into Flights (departure_city, departure_date, departure_time, arrival_city, arrival_date, arrival_time)"
					+ "values (?, ?, ?, ?,?,?)";

			pst = myConn.prepareStatement(query);

			// prepared statements to enter data into flights table. Used to put data where
			// values is a question mark
			pst.setString(1, (f1.getDepartureCity()));
			pst.setString(2, f1.getDepartureDate());
			pst.setString(3, f1.getDepartureTime());
			pst.setString(4, f1.getArrivalCity());
			pst.setString(5, f1.getArrivalDate());
			pst.setString(6, f1.getArrivalTime());

			// update table
			pst.executeUpdate();

		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}

		}
	}

	// query to book a flight based on flight criteria. Criteria is from Flights
	// table
	public static void bookFlight(int idFlight, String username, String departureCity, String departureDate,
			String departureTime, String arrivalCity, String arrivalDate, String arrivalTime) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// insert data into Bookings table

			String query = "insert into Bookings (idFlights, username, departure_city, departure_date, departure_time,  "
					+ "arrival_city, arrival_date,arrival_time)" + "values (?, ?, ?, ?, ?, ?, ?, ?)";

			pst = myConn.prepareStatement(query);

			// insert data into table where it is a question mark in query
			pst.setInt(1, (idFlight));
			pst.setString(2, (ValueObject.bookingUsername));
			pst.setString(3, (departureCity));
			pst.setString(4, (departureDate));
			pst.setString(5, (departureTime));
			pst.setString(6, (arrivalCity));
			pst.setString(7, (arrivalDate));
			pst.setString(8, (arrivalTime));

			// update
			pst.executeUpdate();

		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

	}

	// query to show all personal flights
	public static ResultSet showMyFlights() {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// show all flights given this criteria given the user's username
			String query = "select idFlights, departure_city, departure_date, departure_time,  "
					+ "arrival_city, arrival_date, arrival_time from Bookings where username = '"
					+ ValueObject.bookingUsername + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			return rs;

		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

		return null;

	}

	// query to remove personal flight given id of flight
	public static void removeMyFlight(int idNumber) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// delete flight from personal account given flight id number
			String query = "delete from Bookings where idFlights = '" + idNumber + "'";

			pst = myConn.prepareStatement(query);

			// update
			pst.executeUpdate();

		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

	}

	// query to remove flight from Flights table given flight's id number
	public static void removeFlight(int idNumber) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// delete flight given id number from Flights table
			String query = "delete from Flights where idFlights = '" + idNumber + "'";

			pst = myConn.prepareStatement(query);

			// update
			pst.executeUpdate();

		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

	}

	// query to search flights given city name
	public static ResultSet searchByDepartureCity(String city) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights with matching city name
			String query = "select * from Flights where departure_city = '" + city + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			return rs;

		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
			return null;

	}

	// show all flights from Flights table
	public static ResultSet showFLights() {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights from Flights table
			String query = "select * from Flights";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			return rs;

		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
		return null;

	}

	// check if flight exists based on city
	public static boolean checkFlight(String city) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select flights from Flights table given city name
			String query = "select * from Flights where departure_city = '" + city + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// if the city exists, return true
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}
				}

				}
			}

		return false;
	}

	// check if the flight exists based on an id
	public static boolean checkFlightId(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights from Flights given id
			String query = "select * from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// true if flight exists
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return false;
	}

	// check if flight in personal account exists based on id
	public static boolean checkMyFlightId(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights from Bookings table with given flight id

			String query = "select * from Bookings where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// true if flight is in personal account
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return false;
	}
	
	//Query to create new customer 
	public static void newCustomer(ValueObject vo) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// insert data into Customer table

			String query = "insert into Customer (firstName, lastName, address, zip, state, username, password, email, ssn, recoveryQuestion, recoveryAnswer)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";

			pst = myConn.prepareStatement(query);

			// insert data into query where values is a question mark
			pst.setString(1, vo.getFirstName());
			pst.setString(2, vo.getLastName());
			pst.setString(3, vo.getAddress());
			pst.setString(4, vo.getZipcode());
			pst.setString(5, vo.getState());
			pst.setString(6, vo.getUsername());
			pst.setString(7, vo.getPassword());
			pst.setString(8, vo.getEmail());
			pst.setString(9, vo.getSsn());
			pst.setString(10, vo.getQuestion());
			pst.setString(11, vo.getAnswer());

			// update
			pst.executeUpdate();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

	}
	// retrieve password for customer

	public static String fetchCustomerPassword(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			// 2. Create the statement
			Statement myStmt = myConn.createStatement();

			String query = "select password from Customer where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			ResultSet rs = pst.executeQuery(query);

			rs.next();
			String password = rs.getString("password");

			return password;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;

	}
	
	// query to find customer password

	public static String forgotCustomerPassword(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// retrieve question from database for user

			String query = "select recoveryQuestion from Customer where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String question = rs.getString("recoveryQuestion");

			return question;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;

	}
	
	// query to find answer to security question for customer
		public static String customerAnswer(String username) {
			Connection myConn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
						"sql9259554", "lQ3CmTHLlj");

				Statement myStmt = myConn.createStatement();

				// select answer from Admins table given username
				String query = "select recoveryAnswer from Customer where username = '" + username + "'";

				pst = myConn.prepareStatement(query);

				rs = pst.executeQuery(query);

				// return result
				rs.next();
				String answer = rs.getString("recoveryAnswer");

				return answer;
			}

			catch (Exception exc) {
				exc.printStackTrace();
			} finally {
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						/* ignored */}
					if (myConn != null) {
						try {
							myConn.close();
						} catch (SQLException e) {
							/* ignored */}

					}
				}
			}

			return null;
		}

	// query to create new admin
	public static void newAdmin(ValueObject vo) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// insert data into Admins table

			String query = "insert into Admins (first_name, last_name, address, zip, state, username, password, email, ssn, question, answer)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";

			pst = myConn.prepareStatement(query);

			// insert data into query where values is a question mark
			pst.setString(1, vo.getFirstName());
			pst.setString(2, vo.getLastName());
			pst.setString(3, vo.getAddress());
			pst.setString(4, vo.getZipcode());
			pst.setString(5, vo.getState());
			pst.setString(6, vo.getUsername());
			pst.setString(7, vo.getPassword());
			pst.setString(8, vo.getEmail());
			pst.setString(9, vo.getSsn());
			pst.setString(10, vo.getQuestion());
			pst.setString(11, vo.getAnswer());

			// update
			pst.executeUpdate();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

	}

	// query to find password admin password
	public static String forgotAdminPassword(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// retrieve question from database for user

			String query = "select question from Admins where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String question = rs.getString("question");

			return question;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;

	}

	// query to find answer to security question for admin
	public static String adminAnswer(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select answer from Admins table given username
			String query = "select answer from Admins where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String answer = rs.getString("answer");

			return answer;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;
	}

	// retrieve password for admin
	public static String fetchAdminPassword(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		String password = "";
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			// 2. Create the statement
			Statement myStmt = myConn.createStatement();

			String query = "select password from Admins where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			ResultSet rs = pst.executeQuery(query);

			rs.next();
			
			password = rs.getString("password");
			
			return password;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;

	}

	// find departure city for flight given id
	public static String fetchDepartureCity(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find flight city in Flights table
			String query = "select departure_city from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			ResultSet rs = pst.executeQuery(query);

			// return result
			rs.next();
			String departureCity = rs.getString("departure_city");

			return departureCity;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close the connection
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}

		return null;

	}

	// finde departure date given id
	public static String fetchDepartureDate(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find departure date in Flights table given id
			String query = "select departure_date from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return results
			rs.next();
			String departureDate = rs.getString("departure_date");

			return departureDate;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close connection
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException e) {
						/* ignored */}

				}
			}
		}
		return null;

	}

	// find departure time given id
	public static String fetchDepartureTime(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find departure time in Flights given id query
			String query = "select departure_time from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String departureTime = rs.getString("departure_time");

			return departureTime;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close connection
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

		return null;

	}

	// find arrival city given id
	public static String fetchArrivalCity(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find arrival city for Flights table given id
			String query = "select arrival_city from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String arrivalCity = rs.getString("arrival_city");

			return arrivalCity;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close connection
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

		return null;

	}

	// find arrival date given id
	public static String fetchArrivalDate(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find arrival date given id in Flights table
			String query = "select arrival_date from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String arrivalDate = rs.getString("arrival_date");

			return arrivalDate;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close connection
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

		return null;

	}

	// find arrival time given id
	public static String fetchArrivalTime(int id) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// find arrival time from Flights table given id
			String query = "select arrival_time from Flights where idFlights = '" + id + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery(query);

			// return result
			rs.next();
			String arrivalTime = rs.getString("arrival_time");

			return arrivalTime;
		}

		catch (Exception exc) {
			exc.printStackTrace();

			// close connection
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
		return null;

	}
	
	public static boolean checkAdminUsernameExists(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			
			String query = "select * from Admins where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("username");
				if (usernameCount.equalsIgnoreCase(username)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	//check if admin email is in database
	public static boolean checkAdminEmailExists(String email) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

	
			String query = "select * from Admins where email = '" + email + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("email");
				if (usernameCount.equalsIgnoreCase(email)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	
	public static boolean checkAdminSSNExists(String ssn) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights with matching city name
			String query = "select * from Admins where ssn = '" + ssn + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("ssn");
				if (usernameCount.equalsIgnoreCase(ssn)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	
	public static boolean checkCustomerUsernameExists(String username) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// select all flights with matching city name
			String query = "select * from Customer where username = '" + username + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("username");
				if (usernameCount.equalsIgnoreCase(username)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	//query to check if flight is already booked
	public static boolean checkFlightAlreadyBooked(String username, int flightBooked) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

			// count flights with same id in booking
			String query = "select count(idFlights) from Bookings where username = '" + username + "'" + "and idFlights = '" + flightBooked + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			int flightCount = 0;
			if(rs.next()) {
				flightCount = rs.getInt("Count(idFlights)");
				if(flightCount > 0) {
					return true;
				}
			}
			
			
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	//check if customer email exists in database
	public static boolean checkCustomerEmailExists(String email) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();


			String query = "select * from Customer where email = '" + email + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("email");
				if (usernameCount.equalsIgnoreCase(email)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	//check if ssn is in database
	public static boolean checkCustomerSSNExists(String ssn) {
		Connection myConn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9259554?useSSL=false",
					"sql9259554", "lQ3CmTHLlj");

			Statement myStmt = myConn.createStatement();

		
			String query = "select * from Customer where ssn = '" + ssn + "'";

			pst = myConn.prepareStatement(query);

			rs = pst.executeQuery();

			// return result
			
			String usernameCount;
			if(rs.next()) {
				usernameCount = rs.getString("ssn");
				if (usernameCount.equalsIgnoreCase(ssn)){
					return true;
				}
			}
			
			return false;
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
			return false;

	}
	
}