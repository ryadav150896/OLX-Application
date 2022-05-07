package com.zensar.olxadvertiseapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiseapplication.dto.AdvertisementDto;
import com.zensar.olxadvertiseapplication.entity.Advertisement;
import com.zensar.olxadvertiseapplication.exception.InvalidAdvertiseException;
import com.zensar.olxadvertiseapplication.service.AdvertisementService;

@RestController
public class AdvertiseController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	// post a new Advertisement
	// http//localhost:1010/advertise
	@PostMapping(value = "/advertise", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	//@ApiOperation("Create New Advertise")
	public ResponseEntity<AdvertisementDto> createNewAdvertise(@RequestBody AdvertisementDto advertise,
			@RequestHeader("auth-token") String token) {

		AdvertisementDto advertisement = advertisementService.createNewAdvertise(advertise, token);
		if (advertisement == null) {
			return new ResponseEntity<AdvertisementDto>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<AdvertisementDto>(advertisement, HttpStatus.CREATED);
		}

	}

	// Reads specific advertisement posed by logged in user
	// http//localhost:1010/user/advertise/
	@GetMapping(value = "/user/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	//@ApiOperation("Get specific Advertise")
	public AdvertisementDto getAdvertise(@PathVariable long id) throws InvalidAdvertiseException {

		return advertisementService.getAdvertise(id);
	}

	// to update existing Advertisement
	// http//localhost:1010/advertise/
	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	//@ApiOperation("Update Available Advertisement")
	public AdvertisementDto updateAdvertisement(@PathVariable int id, @RequestBody Advertisement advertise,
			@RequestHeader("auth-token") String token) throws InvalidAdvertiseException {
		return advertisementService.updateAdvertisement(id, advertise, token);
	}

	// Reads all advertisements posted by logged in user
	// http//localhost:1010/user/advertise
	
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	//@ApiOperation("Get All Advertise")
	public ResponseEntity<List<AdvertisementDto>> getAllAdvertisements(@RequestHeader("auth-token") String token) {
		List<AdvertisementDto> advertisement = advertisementService.getAllAdvertisements(token);
		if (advertisement == null) {
			return new ResponseEntity<List<AdvertisementDto>>(HttpStatus.BAD_REQUEST);
		} else {

			return new ResponseEntity<List<AdvertisementDto>>(advertisement, HttpStatus.ACCEPTED);
		}
	}

	// Deletes specific advertisement posted by logged in user
	// http//localhost:1010/user/advertise/
	@DeleteMapping("/user/advertise/{postId}")
	//@ApiOperation("Delete specific Advertisement")
	public boolean deleteAdvertisement(@PathVariable int postId, @RequestHeader("auth-token") String token) {
		
		boolean resultOfDelete=advertisementService.deleteAdvertisement(token, postId);
		
		return resultOfDelete;
	
	}
	//get advertisement based on filter
	//http://localhost:1010/advertise/search/filtercriteria
	@GetMapping(value="/advertise/search/filtercriteria",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Advertisement filterBasedSearchAdvertise()
	{
		return advertisementService.filterBasedSearchAdvertise();
	}
	
	//Matches advertisements using the peovided 'searchText' within all fields of an advertise
	//http://localhost:1010/advertise/search
	@GetMapping(value="/advertise/search",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Advertisement searchAdvertise()
	{
		return advertisementService.searchBasedSearchtextAdvertise();
	}
	
	// get the details of advertise
	// http//localhost:1010/advertise/

	@GetMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	//@ApiOperation("get Advertise details")
	public ResponseEntity<AdvertisementDto> getAdvertisedetails(Advertisement advertiseDetails,@PathVariable int id,
			@RequestHeader("auth-token") String token) {
		AdvertisementDto advertiseDetails1=advertisementService.getAdvertisedetails(advertiseDetails, id, token);
		if(advertiseDetails1==null) {
			return new ResponseEntity<AdvertisementDto>(HttpStatus.BAD_REQUEST);
			

		} else {
			
			return new ResponseEntity<AdvertisementDto>(advertiseDetails1, HttpStatus.OK);
		}

}
	}
