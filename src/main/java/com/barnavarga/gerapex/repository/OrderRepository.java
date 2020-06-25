package com.barnavarga.gerapex.repository;

import com.barnavarga.gerapex.entity.Item;
import com.barnavarga.gerapex.entity.Order;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Repository
//@SessionScope
public class OrderRepository<ItemType extends Item> implements Serializable
{
	private List<Order<ItemType>> orders = new LinkedList<>();

	public void add(final Order<ItemType> order)
	{
		orders.add(order);
	}

	public List<Order<ItemType>> fetchAll()
	{
		return orders;
	}
}
