package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dto.UserInformationDto;
import com.zensar.olxapplication.entity.Token;
import com.zensar.olxapplication.entity.UserInformation;
import com.zensar.olxapplication.repository.UserInformationRepository;





@Service
public class UserInformationServiceImpl implements UserInformationService {
	@Autowired
	private UserInformationRepository userInformationRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Token token;
	
	//static List<UserInformation> userInformationList = new ArrayList<UserInformation>();

		//Token token =new Token();
	public  Token loginUser(UserInformation userLogin) {
		if (userLogin.getUserName().equals("anand") && userLogin.getPassword().equals("anand123")) {
			token.setKey("auth-token");
		    token.setValue("ry66540");
		    
		return token;
		}else {
		return null;
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
		userInformationRepository.deleteAll();
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
		
		
		
		

