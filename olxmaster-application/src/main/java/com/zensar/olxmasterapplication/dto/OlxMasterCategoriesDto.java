package com.zensar.olxmasterapplication.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlxMasterCategoriesDto {
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	private String category;

}
