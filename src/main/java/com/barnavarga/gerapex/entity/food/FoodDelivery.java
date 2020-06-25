package com.barnavarga.gerapex.entity.food;

import com.barnavarga.gerapex.entity.Order;
import lombok.Data;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Data
public class FoodDelivery extends Order<FoodItem>
{
	private String couponCode;
	private String comment;
}
