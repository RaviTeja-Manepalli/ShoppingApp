package com.shop.dao;


import com.shop.entity.Item;

public interface Dao {
	public Item getItemdao(String itemId, int quant) throws Exception;

	public boolean deleteItem() throws Exception;

	public boolean updateitemdao() throws Exception;

	public boolean displayitemsdao() throws Exception;

	public boolean addItemdao() throws Exception;
    
}
