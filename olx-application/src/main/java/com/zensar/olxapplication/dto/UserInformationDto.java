package com.zensar.olxapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationDto {
	
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
