package enteties.impl;

import enteties.User;

public class DefaultUser implements User {
	private static int userCounter = 0;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int id;
	
	{
		id = ++userCounter;
	}
	
	public DefaultUser() {
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + "\t\t" +
				"Last Name: " + this.getLastName() + "\t\t" +
				"Email: " + this.getEmail();
	}

	@Override
	public void setPassword(String password) {
		if(password == null) {
			return;
		}
		this.password = password;
	}

	@Override
	public void setEmail(String email) {
		if(email == null) {
			return;
		}
		this.email = email;
	}

	@Override
	public int getId() {
		
		return id;
	}
	
	void clearState() {
		userCounter = 0;
	}
}
