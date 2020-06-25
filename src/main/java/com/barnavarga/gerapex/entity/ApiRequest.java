package com.barnavarga.gerapex.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public interface ApiRequest
{

}
