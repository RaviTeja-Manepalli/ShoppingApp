package com.shop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Customer {
	private String custId;
	private String custName;
	private String number;
	private List<Item> items;
	// private Date day;
	private double bill;

	public Customer() {
		super();
	}

	public Customer(String custId, String custName, String number, List<Item> items, double bill) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.number = number;
		this.items = items;
		this.bill = bill;
		// this.day = day;
	}

	public Customer(String id, String name, String number2) {
		// TODO Auto-generated constructor stub
		this.custId = id;
		this.custName = name;
		this.number = number2;
		// this.day = day2;

	}

	/*
	 * public Date getDay() { return day; }
	 * 
	 * public void setDay(Date day) { this.day = day; }
	 */

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList();
		}
		return items;

	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		for (Item b : items) {
			bill = bill + b.getQuantity() * b.getPrice();

		}
		this.bill = bill;
	}

}
