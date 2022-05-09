package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.dto.UserInformationDto;
import com.zensar.olxapplication.entity.Token;
import com.zensar.olxapplication.entity.UserInformation;




public interface UserInformationService {
	Token loginUser(UserInformation userLogin) ;
	List<UserInformationDto> getUserInformation(String token); 
	UserInformationDto registerUser( UserInformationDto userData);
	boolean logoutUser( String token);

}
