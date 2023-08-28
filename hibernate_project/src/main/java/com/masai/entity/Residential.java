package com.masai.entity;

import com.masai.ui.Offer;
import com.masai.ui.Owner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Residential {
	@Override
	public String toString() {
		return "Residential [id=" + id + ", area=" + area + ", rent=" + rent + ", location=" + location + ", rooms="
				+ rooms + ", status=" + status + ", owner=" + owner + ", offerAmount=" + offerAmount + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String area;
    private double rent;
    private String location;
    private int rooms;
    private AvailableStatus status;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner; // Reference to the owner of the property
    
    @OneToOne
    private Offer offerAmount;

	public Residential(String area, double rent, String location, int rooms, AvailableStatus status, Owner owner) {
		super();
		this.area = area;
		this.rent = rent;
		this.location = location;
		this.rooms = rooms;
		this.status = status;
		this.owner = owner;
	}

	public Residential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public AvailableStatus getStatus() {
		return status;
	}

	public void setStatus(AvailableStatus status) {
		this.status = status;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

	public Offer getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(Double offerAmount) {
		offerAmount = offerAmount;
	}

	public Residential( String area, double rent, String location, int rooms, AvailableStatus status, Offer offerAmount) {
		super();
		
		this.area = area;
		this.rent = rent;
		this.location = location;
		this.rooms = rooms;
		this.status = status;
		this.offerAmount= offerAmount;
	}

	
	
	public Residential(String area, double rent, String location, int rooms, AvailableStatus status) {
		super();
		this.area = area;
		this.rent = rent;
		this.location = location;
		this.rooms = rooms;
		this.status = status;
	}

	public Residential getPropertyDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    
    
	
    
	
    

	
    
    
}
