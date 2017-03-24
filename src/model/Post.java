package model;

import java.io.Serializable;

public class Post implements Serializable{
	
	private int id;
	private String postName;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostName() {
		return this.postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public Post() {
	}
	
	public Post(int id, String postName) {
		super();
		this.id = id;
		this.postName = postName;
	}
}