package com.shop.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.shop.dao.Dao;
import com.shop.dao.DaoImp;
import com.shop.entity.Customer;
import com.shop.entity.Item;

public class ShopServiceImp implements ShopService {
	static Scanner sc;
	Dao dao = new DaoImp();

	public List<Customer> addCustomers(List<Customer> c) throws Exception {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		System.out.println("Enter Customer name");
		String name = sc.nextLine();
		System.out.println("Enter Customer Id ");
		String Id = sc.nextLine();
		System.out.println("Enter mobile no ");
		String number = sc.nextLine();
		//System.out.println("Enter date");
		//String d = sc.nextLine();
		//*Date day =  new SimpleDateFormat("dd/MM/yyyy").parse(d); 
		Customer cust = new Customer(Id, name, number);
		c.add(cust);
		return c;
	}

	public List<Customer> shopItems(List<Customer> c) throws Exception {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		System.out.println("Enter customer Id");
		String custId = sc.nextLine();
		for (Customer cust : c) {
			if (cust.getCustId().equals(custId) == true) {
				System.out.println("Enter item id to buy");
				String itemId = sc.nextLine();
				System.out.println("Enter quant to buy");
				int quant = sc.nextInt();
				if (addItemtoCustomer(itemId, quant, cust) == true) {
					System.out.println("item shopped " + itemId);
					return c;

				}

			}
		}
		System.out.println("transaction failed invalid customerId or Item id selected");

		return c;
	}

	private boolean addItemtoCustomer(String itemId, int quant, Customer cust) throws Exception {
		// TODO Auto-generated method stub
		Item it = dao.getItemdao(itemId, quant);
		List<Item> i= cust.getItems();
		i.add(it);
		cust.setItems(i);;
		return true;
	}

	public boolean getCustomerDetails(List<Customer> c) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		System.out.println("Enter customer id");
		String custId = sc.nextLine();
		for (Customer cust : c) {
			if (cust.getCustId().equals(custId) == true) {
				System.out.println("Customer details are " + cust.getCustName() + " " + cust.getCustId() + " "
						+ cust.getNumber() + " " + cust.getBill());
				for (Item it : cust.getItems()) {
					System.out.println(it.getItemId() + " " + it.getPrice() + " " + it.getQuantity());
				}
			}
		}
		return false;
	}

	public boolean addItem() throws Exception {
		// TODO Auto-generated method stub
		boolean res = dao.addItemdao();
		if (res == true)
			System.out.println("Item added successfully");

		return false;
	}

	public boolean deleteItem() throws Exception {
		// TODO Auto-generated method stub
		dao.deleteItem();
		return false;
	}

	public boolean updateItemquant() throws Exception {
		// TODO Auto-generated method stub

		boolean b = dao.updateitemdao();
		if (b == true)
			System.out.println("Succesfully updated item quant");
		return false;
	}

	public boolean dispalyItemsSortedApp() throws Exception {
		// TODO Auto-generated method stub
		dao.displayitemsdao();
		return false;
	}

}
