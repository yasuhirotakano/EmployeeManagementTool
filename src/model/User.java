package model;

public class User {
	private int id;
	private String pass;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public User() {
	}
	
	public User(int id, String pass) {
		this.id = id;
		this.pass = pass;
	}
}