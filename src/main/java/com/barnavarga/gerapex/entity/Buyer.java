package com.barnavarga.gerapex.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@Data
public class Buyer implements Serializable
{
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
}
