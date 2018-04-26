//class to hold user's information and to be sent to query
public class ValueObject {
	public String firstName, lastName, address, zipcode, state, username,password, email, ssn, question, answer;
	
	//static username to be used for booking flights and searching for booked flights. Same username as registered username
	static String bookingUsername;

	
	public ValueObject() {
		
	}
	
	//constructor to hold information from register page. Sent to query
	public  ValueObject(String firstName, String lastName, String address, String zipcode, String state,  String username, 
			String password, String email, String ssn, String question, String answer) {
		
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.zipcode = zipcode;
			this.state = state;
			this.username = username;
			this.password = password;
			this.email = email;
			this.ssn = ssn;
			this.question = question;
			this.answer = answer;
		}
	
	//constructor to hold the user's username to be used later when booking flights and searching for booked flights
	public ValueObject(String bookingUsername) {
		ValueObject.bookingUsername= bookingUsername;
	}

	public static String getBookingUsername() {
		return bookingUsername;
	}

	public static void setBookingUsername(String bookingUsername) {
		ValueObject.bookingUsername = bookingUsername;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcoe) {
		this.zipcode = zipcoe;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getQuestion() {
		return question;
	}

	public void setSecurityQuestion(String question) {
		this.question = question;
	}
	

}
