package com.alpha.konuko.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobileno;
	private String mail;
	@OneToMany
	List<Address> addressesList = new ArrayList<Address>();
	@OneToMany
	List<Order> orderList;
	@OneToMany
	List<Product> cart;
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
	public List<Address> getAddressesList() {
		return addressesList;
	}
	public void setAddressesList(List<Address> addressesList) {
		this.addressesList = addressesList;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public List<Product> getCart() {
		return cart;
	}
	public void setProductList(List<Product> cart) {
		this.cart = cart;
	}
	public Customer(String name, long mobileno, String mail, List<Address> addressesList, List<Order> orderList,
			List<Product> cart) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.mail = mail;
		this.addressesList = addressesList;
		this.orderList = orderList;
		this.cart = cart;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", mail=" + mail
				+ ", addressesList=" + addressesList + ", orderList=" + orderList + ", cart=" + cart
				+ "]";
	}
	
}
