package com.zensar.olxapplication.entity;



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
//@ApiModel("This is UserInformation Model")
@Entity //to map the class with db
public class UserInformation {
	//@ApiModelProperty("Id of Integer Type")
	@Id  //to make id as primary
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//@ApiModelProperty("firstName of String Type")
	private String firstName;
	
	//@ApiModelProperty("LastName of String Type")
	private String lastName;
	
	//@ApiModelProperty("username of String type")
	private String userName;
	
	//@ApiModelProperty("password of String type")
	private String password;
	
	//@ApiModelProperty("email of string Type")
	private String email;
	
	//@ApiModelProperty("phone no. of String Type")
	private String phone;
}
