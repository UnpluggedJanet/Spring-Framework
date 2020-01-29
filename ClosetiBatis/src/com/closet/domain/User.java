package com.closet.domain;

public class User {
	private int id;
	private String email;
	private String password;
	private String username;
	private String bio;
	private boolean following;
	
	public User() {
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(int id, String email, String password, String username, String bio) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.bio = bio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean getFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}
	
	

}
