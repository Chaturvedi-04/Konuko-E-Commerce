package com.alpha.konuko.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobileno;
	private String mail;
	private int capacity;
	@OneToMany
	List<Order> orderList;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public Carrier(String name, long mobileno, String mail, int capacity, List<Order> orderList) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
		this.capacity = capacity;
		this.orderList = orderList;
	}
	public Carrier() {
		super();
	}
	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", mail=" + mail + ", capacity="
				+ capacity + ", orderList=" + orderList + "]";
	}
	
	
}
