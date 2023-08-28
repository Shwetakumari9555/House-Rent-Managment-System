package com.masai.ui;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Offer {//owning side 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Offer_Amount")
	private Double Amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Owner_id")
	private Owner owner;
	
	private boolean accepted;

	public int getId() {
		return id;
	}

	
	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(Double amount, boolean accepted) {
		super();
		Amount = amount;
		this.accepted = accepted;
	}
	
	
	
	
	
	
	
}
