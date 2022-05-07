package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dto.UserInformationDto;
import com.zensar.olxapplication.entity.UserInformation;
import com.zensar.olxapplication.repository.UserInformationRepository;

@Service
public class UserInformationServiceImpl implements UserInformationService {
	@Autowired
	private UserInformationRepository userInformationRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	//static List<UserInformation> userInformationList = new ArrayList<UserInformation>();


	public  String loginUser(UserInformation userLogin, String token) {
		if (userLogin.getUserName().equals("anand") && userLogin.getPassword().equals("anand123")) {
			
			return "login Successfull!!";
		}
		else {
		
		return "Authentication Failed!!";

	}
	}
	public List<UserInformationDto> getUserInformation(String token) {
		List<UserInformation> userInformation=userInformationRepository.findAll();
		
		 List<UserInformationDto> userInformationDtos = new ArrayList<>();
		 
		if (token.equals("ry66540")) {
			
			 for(UserInformation user:userInformation) {
			
			UserInformationDto newUserInformation=modelMapper.map(user,UserInformationDto.class);
			userInformationDtos.add(newUserInformation);
			 }return userInformationDtos;

		}else {
		
		return null;
	}
	}
	
	public UserInformationDto registerUser(UserInformationDto userInformationDto) {
		
		UserInformation newUser=modelMapper.map(userInformationDto, UserInformation.class);
		UserInformation save = userInformationRepository.save(newUser);
		return modelMapper.map(save,UserInformationDto.class);

	}

	
	public boolean logoutUser(String token) {
		if(token.equals("ry66540")) {
		userInformationRepository.deleteAll();;
		return true;
	}else {
		return false;
	}
	}
}
		
	
		/*for (UserInformation user : userInformationRepository) {

			if (token.equals("ry66540")) {
				userInformationList.remove(user);
				return true;
			} else {
				return false;

			}
		
	
		}
		return false;
		}
}	*/
		
		
		
		

