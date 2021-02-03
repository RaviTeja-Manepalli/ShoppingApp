package com.shop.service;

import java.util.List;

import com.shop.entity.Customer;

public interface ShopService {
	public List<Customer> addCustomers(List<Customer> c) throws Exception;

	public List<Customer> shopItems(List<Customer> c) throws Exception;

	public boolean getCustomerDetails(List<Customer> c);

	public boolean addItem() throws Exception;

	public boolean deleteItem() throws Exception;

	public boolean updateItemquant() throws Exception;

	public boolean dispalyItemsSortedApp() throws Exception;

}
