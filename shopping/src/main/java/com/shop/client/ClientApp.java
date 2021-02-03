package com.shop.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shop.service.ShopService;
import com.shop.service.ShopServiceImp;
import com.shop.entity.Customer;
import com.shop.entity.Item;

public class ClientApp {
	static Scanner sc = new Scanner(System.in);
	static List<Customer> c = new ArrayList<Customer>();
	static List<Item> i = new ArrayList<Item>();
	static ShopService shop = new ShopServiceImp();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			System.out.println("1. Sign up");
			System.out.println("2. shop item ");
			System.out.println("3. get Customer details");
			System.out.println("4. Update items quantity");
			System.out.println("5. Delete the item");
			System.out.println("6. Add item");
			System.out.println("7. display items sorted on price and quantity");
			System.out.println("8. Exit ");
			System.out.println("Enter ur choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				c = shop.addCustomers(c);
				break;
			case 2:
				c = shop.shopItems(c);
				break;
			case 3:
				boolean res = shop.getCustomerDetails(c);
				if(res==false)
					System.out.println("No customer is present");
				break;
			case 4:
				boolean r = shop.updateItemquant();
				break;
			case 5:
				boolean r1 = shop.deleteItem();
				break;
			case 6:
			   shop.addItem();
				break;
			case 7:
				shop.dispalyItemsSortedApp();
				break;
			case 8:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice");

			}
		} while (choice != 8);

	}

}
