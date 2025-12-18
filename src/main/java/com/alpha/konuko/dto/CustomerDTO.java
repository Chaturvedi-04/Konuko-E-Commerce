package com.alpha.konuko.dto;

import com.alpha.konuko.entity.Address;

public class CustomerDTO {
	
	private String name;
	private long mobileno;
	private String mail;
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public CustomerDTO(String name, long mobileno, String mail, Address address) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
		this.address = address;
	}
	public CustomerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", mobileno=" + mobileno + ", mail=" + mail + ", address=" + address + "]";
	}

}
