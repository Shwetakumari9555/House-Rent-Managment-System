package com.masai.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name ="Property_Description")

public class PropertyDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
    private String details;
    
    @OneToOne
    private Commercial commercial;
    @OneToOne
   private Residential residential;

	
   
    
	public PropertyDescription(String title, String details, Commercial commercial, Residential residential) {
		super();
		this.title = title;
		this.details = details;
		this.commercial = commercial;
		this.residential = residential;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Commercial getCommercial() {
		return commercial;
	}

	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}

	public Residential getResidential() {
		return residential;
	}

	public PropertyDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyDescription(String title, String details) {
		super();
		this.title = title;
		this.details = details;
	}


	public void setResidential(Residential residential) {
		// TODO Auto-generated method stub
		
	}
    
	
	
    

}
