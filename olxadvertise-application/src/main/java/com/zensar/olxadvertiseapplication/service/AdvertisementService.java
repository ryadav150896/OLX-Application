package com.zensar.olxadvertiseapplication.service;

import java.util.List;

import com.zensar.olxadvertiseapplication.dto.AdvertisementDto;
import com.zensar.olxadvertiseapplication.entity.Advertisement;
import com.zensar.olxadvertiseapplication.exception.InvalidAdvertiseException;


public interface AdvertisementService {
	
	AdvertisementDto createNewAdvertise(AdvertisementDto advertiseDto, String token);
	AdvertisementDto getAdvertise(long id) throws InvalidAdvertiseException;
	AdvertisementDto updateAdvertisement( int id,Advertisement advertise,String token) throws InvalidAdvertiseException; 
	List<AdvertisementDto> getAllAdvertisements( String token);
	boolean deleteAdvertisement( String token,long id);
	public Advertisement filterBasedSearchAdvertise();
	public Advertisement searchBasedSearchtextAdvertise();
	AdvertisementDto getAdvertisedetails(Advertisement advertiseDetails, long id, String token);
	
}