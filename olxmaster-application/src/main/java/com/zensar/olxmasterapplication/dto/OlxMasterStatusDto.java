package com.zensar.olxmasterapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlxMasterStatusDto {
	
     private int statusId;
	
	//@ApiModelProperty("status of String Type")
	private String Status;


}
