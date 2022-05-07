package com.zensar.olxmasterapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxmasterapplication.dto.OlxMasterCategoriesDto;
import com.zensar.olxmasterapplication.dto.OlxMasterStatusDto;
import com.zensar.olxmasterapplication.entity.OlxMasterCategories;
import com.zensar.olxmasterapplication.entity.OlxMasterStatus;
import com.zensar.olxmasterapplication.repository.OlxMasterCategoriesRepository;
import com.zensar.olxmasterapplication.repository.OlxMasterStatusRepository;

@Service
public class OlxMasterServiceImpl implements OlxMasterService {

	@Autowired
	private OlxMasterStatusRepository olxMasterStatusRepository;
	
	@Autowired
	private OlxMasterCategoriesRepository olxMasterCategoriesRepository;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * static List<OlxMasterStatus> listOfStatus=new ArrayList();
	 * 
	 * static {
	 * 
	 * listOfStatus.add(new OlxMasterStatus(1,"OPEN")); listOfStatus.add(new
	 * OlxMasterStatus(2,"CLOSED")); }
	 */
	@Override
	public List<OlxMasterStatusDto> getAllStatus() {

		List<OlxMasterStatus> statuslist = olxMasterStatusRepository.findAll();

		// List<OlxMasterStatusDto> statusDtos = new ArrayList<>();
		//statuslist.add(new OlxMasterStatus(1, "OPEN"));
		//statuslist.add(new OlxMasterStatus(2, "CLOSED"));
		List<OlxMasterStatusDto> statusDtos = new ArrayList<>();
		for (OlxMasterStatus status : statuslist) {

			OlxMasterStatusDto newstatus = modelMapper.map(status, OlxMasterStatusDto.class);
			statusDtos.add(newstatus);
		}
		return statusDtos;

	}

	/*
	 * static List<OlxMasterCategories> listOfCategories=new ArrayList();
	 * 
	 * static {
	 * 
	 * listOfCategories.add(new OlxMasterCategories(1,"Furniture"));
	 * listOfCategories.add(new OlxMasterCategories(2,"Cars"));
	 * listOfCategories.add(new OlxMasterCategories(3,"Mobiles"));
	 * listOfCategories.add(new OlxMasterCategories(4,"Real Estate"));
	 * listOfCategories.add(new OlxMasterCategories(5,"Sports")); }
	 */

	@Override
	public List<OlxMasterCategoriesDto> getAllAdvCategories() {

		List<OlxMasterCategories> categorieslist = olxMasterCategoriesRepository.findAll();

		/*categorieslist.add(new OlxMasterCategories(1, "Furniture"));
		categorieslist.add(new OlxMasterCategories(2, "Cars"));
		categorieslist.add(new OlxMasterCategories(3, "Mobiles"));
		categorieslist.add(new OlxMasterCategories(4, "Real Estate"));
		categorieslist.add(new OlxMasterCategories(5, "Sports"));*/
		// return olxMasterCategoriesRepository.findAll();

		List<OlxMasterCategoriesDto> categoryDtos = new ArrayList<>();
		for (OlxMasterCategories category : categorieslist) {

			OlxMasterCategoriesDto newCategoryDto = modelMapper.map(category, OlxMasterCategoriesDto.class);
			categoryDtos.add(newCategoryDto);
		}
		return categoryDtos;
	}
}