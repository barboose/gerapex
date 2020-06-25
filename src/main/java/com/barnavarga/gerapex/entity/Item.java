package com.barnavarga.gerapex.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Data
public abstract class Item implements Serializable
{
	private String name;
	private double quantity;
	private String unit;
}
