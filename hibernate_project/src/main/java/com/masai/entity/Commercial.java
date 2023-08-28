package com.masai.entity;

import com.masai.ui.Owner;
import com.masai.ui.Tenant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Commercial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double area;
	private double rent;
	private String Location;
	private AvailableStatus status;
	
	private Double OfferAmount;
	
	
	@ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner; // Reference to the owner of the property
	
	@OneToOne
	private Tenant tenant;

	public Commercial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commercial(double area, double rent, String location, AvailableStatus status, Double offerAmount,
			Owner owner, Tenant tenant) {
		super();
		this.area = area;
		this.rent = rent;
		Location = location;
		this.status = status;
		OfferAmount = offerAmount;
		this.owner = owner;
		this.tenant = tenant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public AvailableStatus getStatus() {
		return status;
	}

	public void setStatus(AvailableStatus status) {
		this.status = status;
	}

	public Double getOfferAmount() {
		return OfferAmount;
	}

	public void setOfferAmount(Double offerAmount) {
		OfferAmount = offerAmount;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Commercial(double area, double rent, String location, AvailableStatus status) {
		super();
		this.area = area;
		this.rent = rent;
		Location = location;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Commercial [id=" + id + ", area=" + area + ", rent=" + rent + ", Location=" + Location + ", status="
				+ status + ", OfferAmount=" + OfferAmount + ", owner=" + owner + ", tenant=" + tenant + "]";
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
		
	

}
