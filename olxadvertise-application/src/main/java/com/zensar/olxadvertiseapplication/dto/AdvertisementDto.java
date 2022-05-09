package com.zensar.olxadvertiseapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto {
	
	
	private long id;
	private String title;
	private long price;
	private String description;
	private String userName;
	private long createdDate;
	private long modifiedDate;
	private String status;
}
