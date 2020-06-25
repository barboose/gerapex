package com.barnavarga.gerapex.entity.pharmacy;

import com.barnavarga.gerapex.entity.Order;
import lombok.Data;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Data
public class PharmacyOrder extends Order<PharmacyItem>
{
	private String rewardCardNumber;
}
