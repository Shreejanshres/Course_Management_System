package coursemanagement;

import java.util.regex.Pattern;

public class RegexTest {
	public boolean checkEmail(String email) {
		String emailtest="^\\S+\\d+@eclass\\.edu\\.np$";
		if((Pattern.matches(emailtest,email)==true)){
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean checkPassword(String password) {
		String passwordtest="^([\\S]+[\\d]+)$";
		if(Pattern.matches(passwordtest, password)==true) {
			return true;
		}
		else {
			return false;
		}
	}
}
