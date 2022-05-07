package com.zensar.olxmasterapplication.entity;

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
//@ApiModel("This is OlxMasterStatus Model")
@Entity //to map class with database
public class OlxMasterStatus {
	
	//@ApiModelProperty("id of Integer Type")
	@Id //to make id primary
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statusId;
	
	//@ApiModelProperty("status of String Type")
	private String Status;
    
}
