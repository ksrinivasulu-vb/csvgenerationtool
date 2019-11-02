package com.printizen.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6712999598920356440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String password;
	private String email;
	private int isactive;
	
	
	protected User () {}
	
	public User(String Name, String Password, String Email, int isActive) {
		this.name = Name;
		this.password = Password;
		this.email= Email;
		this.isactive=isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
	 @Override
	  public String toString() {
	    return String.format("Userd=%d, Name='%s', email='%s',, Active='%s']", id, name, email,isactive);
	  }
	
	
	
}
