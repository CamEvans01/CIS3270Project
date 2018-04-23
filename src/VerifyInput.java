//class to verify password is correct and to verify answer to security question
public class VerifyInput {
	String myAnswer, answer, password, checkPassword;
	
	public VerifyInput() {
		
	}
	//constructor to find answer to security question
	public VerifyInput(String myAnswer, String answer, String password) {
		this.myAnswer = myAnswer;
		this.answer = answer;
		this.password = password;
		
	}
	//constructor to verify password
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
	//verify given answer matches with security question answer
	public boolean isCorrect() {
		if(getMyAnswer().equalsIgnoreCase(getAnswer())){
			
			return true;
		}
		return false;
	}
	
	//verify if given password equals stored password
	public boolean Verification() {
		if(getPassword().equals(getCheckPassword())) {
			return true;
		}
			return false;
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

}
