package com.alpha.konuko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String city;
	private int pincode;
	private String state;
	private String country;
	private String addressDescription;
	private long mobileno;
	private String addressType;
	@Override
	public String toString() {
		return "Addresses [id=" + id + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country="
				+ country + ", addressDescription=" + addressDescription + ", mobileno=" + mobileno + ", addressType="
				+ addressType + "]";
	}
	public Address(String city, int pincode, String state, String country, String addressDescription, long mobileno,
			String addressType) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.addressDescription = addressDescription;
		this.mobileno = mobileno;
		this.addressType = addressType;
	}
	public Address() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddressDescription() {
		return addressDescription;
	}
	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	

}
