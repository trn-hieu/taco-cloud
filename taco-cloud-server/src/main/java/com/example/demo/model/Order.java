package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date placedAt;
	private String name; 
	private String street; 
	private String city; 
	private String state; 
	private String zip; 
	private String ccNumber; 
	private String ccExpiration; 
	private String ccCVV;
	@ManyToMany(targetEntity=Taco.class,cascade = CascadeType.ALL)
	private List<Taco> tacos;
	@PrePersist
	void placedAt() {
	this.placedAt = new Date();
	}
	public Order() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getCcExpiration() {
		return ccExpiration;
	}
	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}
	public String getCcCVV() {
		return ccCVV;
	}
	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getPlacedAt() {
		return placedAt;
	}
	public void setPlacedAt(Date placeAt) {
		this.placedAt = placeAt;
	}
	public List<Taco> getTacos() {
		return tacos;
	}
	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	} 

	
}
