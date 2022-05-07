package com.zensar.olxapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.dto.UserInformationDto;
import com.zensar.olxapplication.entity.UserInformation;
import com.zensar.olxapplication.service.UserInformationService;

@RestController
public class UserInformationController {
	@Autowired
	private UserInformationService userInformationService;
	
	
	//login a user
	//http:localhost:5050/user/authenticate
	//@ApiOperation("Athenticate User")
	@PostMapping(value = "/user/authenticate", consumes =  {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
			, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> loginUser(@RequestBody UserInformation userLogin, String token) {

		 String loginResult=userInformationService.loginUser(userLogin, token);
		if(loginResult.equals("login Successfull!!")) {
			token="ry66540";
			return new ResponseEntity<String>(loginResult +" "+ token, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(loginResult, HttpStatus.BAD_REQUEST);
		
		
	}
}

	// Get the user
	// http:localhost:5050/user
	//@ApiOperation("Getting an User")
	//@ApiResponse(code = 200, message = "Got the User")
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<UserInformationDto> getUserInformation(@RequestHeader("auth-token") String token) {
		return userInformationService.getUserInformation(token);
	}

	// To Add new user
	// http:localhost:5050/user
	//@ApiOperation("Adding new User")
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserInformationDto registerUser(@RequestBody UserInformationDto userData) {
		return userInformationService.registerUser(userData);
	}

	// to delete existing user
	// http:localhost:5050/user/logout
	//@ApiOperation("Logout User")
	@DeleteMapping("/user/logout")
	public boolean logoutUser(@RequestHeader("auth-token") String token) {
		boolean logoutResult= userInformationService.logoutUser(token);
		return logoutResult;


		}
	}
