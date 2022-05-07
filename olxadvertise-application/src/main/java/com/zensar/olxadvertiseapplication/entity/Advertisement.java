package com.zensar.olxadvertiseapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel("This is Advertisement Model")
@Entity //to map class with db
public class Advertisement {
	
	//@ApiModelProperty("id of Integer type")
	@Id //to make id as primary
	@GeneratedValue(strategy = GenerationType.AUTO)// for auto generation of id
	private int id;
	
	//@ApiModelProperty("title of String Type type")
	private String title;
	
	//@ApiModelProperty("price of String Type type")
	private long price;
	
	//@ApiModelProperty("category of String Type type")
	
	
	//@ApiModelProperty("description of String Type type")
	private String description;
	
	//@ApiModelProperty("userName of String Type type")
	private String userName;
	
	//@ApiModelProperty("createdDate of String Type type")
	private long createdDate;
	
	//@ApiModelProperty("modifiedDate of String Type type")
	private long modifiedDate;
	
	//@ApiModelProperty("status of String Type type")
	private String status;

}
