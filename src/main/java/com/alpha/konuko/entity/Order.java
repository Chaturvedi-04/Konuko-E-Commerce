package com.alpha.konuko.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Carrier carrier;
	private String orderStatus;
	private String date;
	@OneToOne
	private Address pickupLocation;
	@OneToOne 
	private Address deliveryLocation;
	private String expectedDeliverDate;
	private double totalPrice;
	@OneToMany
	List<Product> purchaseList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Address getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(Address pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public Address getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(Address deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	public String getExpectedDeliverDate() {
		return expectedDeliverDate;
	}
	public void setExpectedDeliverDate(String expectedDeliverDate) {
		this.expectedDeliverDate = expectedDeliverDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Product> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(List<Product> purchaseList) {
		this.purchaseList = purchaseList;
	}
	public Order(Customer customer, Carrier carrier, String orderStatus, String date, Address pickupLocation,
			Address deliveryLocation, String expectedDeliverDate, double totalPrice, List<Product> purchaseList) {
		super();
		this.customer = customer;
		this.carrier = carrier;
		this.orderStatus = orderStatus;
		this.date = date;
		this.pickupLocation = pickupLocation;
		this.deliveryLocation = deliveryLocation;
		this.expectedDeliverDate = expectedDeliverDate;
		this.totalPrice = totalPrice;
		this.purchaseList = purchaseList;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", carrier=" + carrier + ", orderStatus=" + orderStatus
				+ ", date=" + date + ", pickupLocation=" + pickupLocation + ", deliveryLocation=" + deliveryLocation
				+ ", expectedDeliverDate=" + expectedDeliverDate + ", totalPrice=" + totalPrice + ", purchaseList="
				+ purchaseList + "]";
	}
	
}
