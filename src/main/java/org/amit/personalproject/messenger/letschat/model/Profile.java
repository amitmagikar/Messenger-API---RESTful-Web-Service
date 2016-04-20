package org.amit.personalproject.messenger.letschat.model;

import java.util.Date;

public class Profile {

	private long id;
	private String username;
	private String firstName;
	private String lastName;
	private Date createdDate;
	
	public Profile(){}
	
	public Profile(long id, String username, String firstName, String lastName){
		
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
