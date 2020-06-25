package com.barnavarga.gerapex.controller;

import com.barnavarga.gerapex.entity.ApiRequest;
import com.barnavarga.gerapex.entity.Item;
import com.barnavarga.gerapex.entity.Order;
import com.barnavarga.gerapex.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@RestController
public class OrderController<ItemType extends Item, Request extends Order<ItemType> & ApiRequest> implements Serializable
{
	private final OrderService<ItemType> service;

	@Autowired
	public OrderController(final OrderService<ItemType> service)
	{
		this.service = service;
	}

	@GetMapping("/orders")
	public List<Order<ItemType>> fetchOrders()
	{
		return service.fetchAll();
	}

	@PostMapping("/orders")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createNewOrder(@RequestBody final Request order)
	{
		service.add(order);
	}
}
