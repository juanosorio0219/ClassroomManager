package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Classroom {
	
	private UserAccount activeUser;
	private ArrayList <UserAccount> accounts = new ArrayList<UserAccount>();
	
	
	public void createAccount(String username, String password, String photo, String gender, String career,
			LocalDate birthday, String favBrowser) {
		
		UserAccount user = new UserAccount(username, password, photo, gender, career, birthday, favBrowser);
		accounts.add(user); 

	}


	public boolean verifyCredentials(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
