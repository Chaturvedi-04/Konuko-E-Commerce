package com.alpha.konuko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int quantity;
	private String category;
	private double pricePerUnit;
	private String brandName;
	private String description;
	private String availabilityStatus;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public Product(String name, int quantity, String category, double pricePerUnit, String brandName,
			String description, String availabilityStatus) {
		super();
//		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.pricePerUnit = pricePerUnit;
		this.brandName = brandName;
		this.description = description;
		this.availabilityStatus = availabilityStatus;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", category=" + category
				+ ", pricePerUnit=" + pricePerUnit + ", brandName=" + brandName + ", description=" + description
				+ ", availabilityStatus=" + availabilityStatus + "]";
	}
	
}
