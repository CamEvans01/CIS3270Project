
//class to verify password is correct and to verify answer to security question
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VerifyInput {
	String myAnswer, answer, password, checkPassword;

	public VerifyInput() {

	}

	// constructor to find answer to security question
	public VerifyInput(String myAnswer, String answer, String password) {
		this.myAnswer = myAnswer;
		this.answer = answer;
		this.password = password;

	}

	// constructor to verify password
	public VerifyInput(String password, String checkPassword) {
		this.password = password;
		this.checkPassword = checkPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMyAnswer() {
		return myAnswer;
	}

	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	// verify given answer matches with security question answer
	public boolean isCorrect() {
		if (getMyAnswer().equalsIgnoreCase(getAnswer())) {

			return true;
		}
		return false;
	}

	// verify if given password equals stored password
	public boolean Verification() {
		if (getPassword().equals(getCheckPassword())) {
			return true;
		}
		return false;
	}

	//determine if first name is all letters
	public boolean firstNameAllLetters(ValueObject vo) {
		String firstName = vo.getFirstName();
		int letterCount = 0;

		for (int i = 0; i < firstName.length(); i++) {
			if (Character.isLetter(firstName.charAt(i))) {
				letterCount++;
			}
		}
		if (letterCount != firstName.length() || firstName.length() <= 1) {
			return false;
		}
		return true;

	}
	//determine if last name is all letters
	public boolean lastNameAllLetters(ValueObject vo) {
		String lastName = vo.getLastName();
		int letterCount = 0;

		for (int i = 0; i < lastName.length(); i++) {
			if (Character.isLetter(lastName.charAt(i))) {
				letterCount++;
			}
		}
		if (letterCount != lastName.length() || lastName.length() <= 1) {
			return false;
		}
		return true;

	}
	//determine if state is all letters
	public boolean stateAllLetters(ValueObject vo) {
		String state = vo.getState();
		int letterCount = 0;

		for (int i = 0; i < state.length(); i++) {
			if (Character.isLetter(state.charAt(i))) {
				letterCount++;
			}
		}
		if (letterCount != state.length() || state.length() <= 1) {
			return false;
		}
		return true;
	}
	//determine if zipode is legal
	public boolean zipcodeVerify(ValueObject vo) {
		String zipcode = vo.getZipcode().replaceAll("\\s+", " ");
		int numberCount = 0;

		for (int i = 0; i < zipcode.length(); i++) {
			if (Character.isDigit(zipcode.charAt(i))) {
				numberCount++;
			}
		}
		if (numberCount != zipcode.length() || zipcode.length() != 5) {
			return false;
		}
		return true;
	}

	//determine if ssn is legal
	public boolean ssnVerify(ValueObject vo) {
		String ssn = vo.getSsn().replaceAll("\\s+", " ");
		int numberCount = 0;

		for (int i = 0; i < ssn.length(); i++) {
			if (Character.isDigit(ssn.charAt(i))) {
				numberCount++;
			}
		}
		if (numberCount != ssn.length() || ssn.length() != 9) {
			return false;
		}
		return true;
	}

	//determine if email is legal
	public boolean emailVerify(ValueObject vo) {
		String email = vo.getEmail();
		Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{3,6}$", Pattern.CASE_INSENSITIVE) .matcher(email);
		if (matcher.find()) {
			return true;
		}
		return false;

	}
	//determine if departure city is all letters
	public boolean departureCityAllLetters(Flights f1) {
		String state = f1.getDepartureCity().replaceAll("\\s+", " ");
		int letterCount = 0;

		for (int i = 0; i < state.length(); i++) {
			if (Character.isLetter(state.charAt(i))) {
				letterCount++;
			}
		}
		if (letterCount != state.length() || state.length() <= 1) {
			return false;
		}
		return true;
	}
	//determine if arrival city is all letters
	public boolean arrivalCityAllLetters(Flights f1) {
		String state = f1.getArrivalCity().replaceAll("\\s+", " ");
		int letterCount = 0;

		for (int i = 0; i < state.length(); i++) {
			if (Character.isLetter(state.charAt(i))) {
				letterCount++;
			}
		}
		if (letterCount != state.length() || state.length() <= 1) {
			return false;
		}
		return true;
	}
	//determine if date is legal
	public boolean verifyDateFormat(String s) {
		Pattern p = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		if(p.matcher(s).matches()) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	//determine if time is legal
	public boolean verifyTimeFormat(String s) {
		Pattern p = Pattern.compile("\\d{2}:\\d{2}");
		if(p.matcher(s).matches()) {
			return true;
		}else {
			return false;
		}
		
		
	}

}