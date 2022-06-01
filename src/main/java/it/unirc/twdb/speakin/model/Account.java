package it.unirc.twdb.speakin.model;

public class Account {
	private String email;
	private String password;
	private int type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Account(String email, String password, int type) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", type=" + type + "]";
	}
	
}
