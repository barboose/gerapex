package com.barnavarga.gerapex.service;

import com.barnavarga.gerapex.entity.Item;
import com.barnavarga.gerapex.entity.Order;
import com.barnavarga.gerapex.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Service
public class OrderService<ItemType extends Item> implements Serializable
{
	private final OrderRepository<ItemType> repository;

	@Autowired
	public OrderService(final OrderRepository<ItemType> repository)
	{
		this.repository = repository;
	}

	public void add(final Order<ItemType> order)
	{
		repository.add(order);
	}

	public List<Order<ItemType>> fetchAll()
	{
		return repository.fetchAll();
	}
}
