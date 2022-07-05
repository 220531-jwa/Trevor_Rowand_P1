package dev.rowand.models;

public class User {
	private String username;
	private int id;
	private String password;
	private String first_name;
	private String last_name;
	private float reimburse = 1000; //move to the user project
	private String type;

	public User() {}
	public User(String username, int id, String password, String first_name, String last_name, float reimburse,
			String type) {
		this.username = username;
		this.id = id;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.reimburse = reimburse;
		this.type = type;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public float getReimburse() {
		return reimburse;
	}
	public void setReimburse(float reimburse) {
		this.reimburse = reimburse;
	}
}
