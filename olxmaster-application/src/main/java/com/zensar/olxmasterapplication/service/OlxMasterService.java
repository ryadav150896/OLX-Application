package com.zensar.olxmasterapplication.service;

import java.util.List;

import com.zensar.olxmasterapplication.dto.OlxMasterCategoriesDto;
import com.zensar.olxmasterapplication.dto.OlxMasterStatusDto;

public interface OlxMasterService {
	
	List<OlxMasterStatusDto> getAllStatus();
	List<OlxMasterCategoriesDto> getAllAdvCategories();


}
