package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tenants")
public class Tenant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "name")
private String name;

@Column(name = "Date_Of_birth")
private LocalDate dob;
@Column(name = "Email",unique = true)
private String email;
@Column(name = "Password")
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
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
public Tenant() {
	super();
	// TODO Auto-generated constructor stub
}
public Tenant(String name, LocalDate dob, String email, String password) {
	super();
	this.name = name;
	this.dob = dob;
	this.email = email;
	this.password = password;
}










}
