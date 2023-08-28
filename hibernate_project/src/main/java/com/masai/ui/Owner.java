package com.masai.ui;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.masai.entity.Commercial;
import com.masai.entity.Residential;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Owners")
public class Owner {//refer
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "name")
private String name;

@Column(name = "Date_Of_birth", nullable = false  )
private LocalDate dob;
@Column(name = "Email", nullable = false,unique = true)
private String email;
@Column(name = "Password" , nullable = false)
private String password;


@OneToMany(mappedBy = "owner", fetch =FetchType.LAZY)

private Set<Offer> offer = new HashSet<Offer>();

@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Commercial> commercialProperties = new HashSet<>();
@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Residential> residentialProperties = new HashSet<>();



public Owner(String name, LocalDate dob, String email, String password, Set<Offer> offer,
		Set<Commercial> commercialProperties, Set<Residential> residentialProperties) {
	super();
	this.name = name;
	this.dob = dob;
	this.email = email;
	this.password = password;
	this.offer = offer;
	this.commercialProperties = commercialProperties;
	this.residentialProperties = residentialProperties;
}



public Owner() {
	super();
	// TODO Auto-generated constructor stub
}



public int getId() {
	return id;
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



public Set<Offer> getOffer() {
	return offer;
}



public void setOffer(Set<Offer> offer) {
	this.offer = offer;
}



public Set<Commercial> getCommercialProperties() {
	return commercialProperties;
}



public void setCommercialProperties(Set<Commercial> commercialProperties) {
	this.commercialProperties = commercialProperties;
}



public Set<Residential> getResidentialProperties() {
	return residentialProperties;
}



public void setResidentialProperties(Set<Residential> residentialProperties) {
	this.residentialProperties = residentialProperties;
}








}
