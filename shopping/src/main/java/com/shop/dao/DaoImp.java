package com.shop.dao;

import com.shop.entity.Item;
import java.sql.*;
import java.util.Scanner;

import com.utility.DBUtil;

public class DaoImp implements Dao {
	static DBUtil db = new DBUtil();
	static Scanner sc = new Scanner(System.in);

	public Item getItemdao(String itemId, int quant) throws Exception {
		// TODO Auto-generated method stub
		Statement st = db.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from item ");
		while (rs.next()) {
			if (rs.getString(1).equals(itemId) == true) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				double price = rs.getDouble(4);
				int res = rs.getInt(3) - quant;
				String query = String.format("update Item set Quantity= ? where ItemId= ? ");
				PreparedStatement pst = db.getConnection().prepareStatement(query);
				pst.setInt(1, res);
				pst.setString(2, id);
				pst.executeUpdate();
				// System.out.println();
				// pst.setString(2, id);
				Item it = new Item(id, name, price, quant);
				st.close();
				rs.close();
				return it;
			}
		}
		st.close();
		rs.close();
		System.out.println("No item in the list");
		return null;
	}

	public boolean deleteItem() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter item id to delete");
		String itemid = sc.nextLine();
		Statement st = db.getConnection().createStatement();
		String sql = "delete from Item where ItemId=   '" + itemid + "' ";
		st.executeUpdate(sql);
		st.close();
		return false;
	}

	public boolean updateitemdao() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter item id to update quantity");
		String itemid = sc.nextLine();
		Statement st = db.getConnection().createStatement();
		System.out.println("enter quantity");
		int quant = sc.nextInt();
		String sql = String.format("update Item set Quantity = %d where ItemId=   '" + itemid + "'", quant);
		st.execute(sql);
		st.close();
		return true;
	}

	public boolean displayitemsdao() throws Exception {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs1 = null;
		try {
			st = db.getConnection().createStatement();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			rs1 = st.executeQuery("select * from item order by price,Quantity ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs1.next()) {
			System.out.println(rs1.getString(1) + " " + rs1.getString(2) + rs1.getDouble(4) + " " + rs1.getInt(3));

		}
		st.close();
		rs1.close();

		return true;
	}

	public boolean addItemdao() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter item id to delete");
		String itemid = sc.nextLine();
		System.out.println("ENter name");
		String name = sc.nextLine();
		System.out.println("Enter quantity");
		int quant = sc.nextInt();
		System.out.println("Enter price");
		double price = sc.nextDouble();
		Statement st = db.getConnection().createStatement();
		String sql = String.format("insert into item values('%s','%s',%d,%f)", itemid, name, quant, price);
		st.executeUpdate(sql);
		st.close();
		return true;

	}

}
