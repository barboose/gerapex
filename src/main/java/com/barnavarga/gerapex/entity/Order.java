package com.barnavarga.gerapex.entity;

import com.barnavarga.gerapex.entity.enums.PaymentMethod;
import com.barnavarga.gerapex.entity.food.FoodDelivery;
import com.barnavarga.gerapex.entity.pharmacy.PharmacyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Data
@JsonSubTypes({
		@JsonSubTypes.Type(value = PharmacyOrder.class, name = "pharmacy"),
		@JsonSubTypes.Type(value = FoodDelivery.class, name = "food-delivery")
})
public abstract class Order<ItemType extends Item> implements Serializable, ApiRequest
{
	private Buyer buyer;
	private List<ItemType> items;
	private PaymentMethod paymentMethod;
}
