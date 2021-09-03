package model;

import java.time.LocalDate;

public class UserAccount {
	
	private String username;
	private String password;
	private String photo;
	private String gender;
	private String carreer;
	private LocalDate birthday;
	private String favBrowser;
	
	public UserAccount(String username, String password, String photo, String gender, String carreer,
			LocalDate birthday, String favBrowser) {
		
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.gender = gender;
		this.carreer = carreer;
		this.birthday = birthday;
		this.favBrowser = favBrowser;
		
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCarreer() {
		return carreer;
	}

	public void setCarreer(String carreer) {
		this.carreer = carreer;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getFavBrowser() {
		return favBrowser;
	}

	public void setFavBrowser(String favBrowser) {
		this.favBrowser = favBrowser;
	}
	
	

}
