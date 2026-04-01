package com.velocity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.velocity.dto.PolicyDto;
import com.velocity.dto.ResponseDto;
import com.velocity.dto.UserDto;
import com.velocity.repository.UserRepository;
import com.velocity.service.UserService;
import com.velocity.user.User;

@Service
public class UserServiceImpl implements UserService {

	// inject webClient
	@Autowired
	private WebClient webClient;

	@Override
	public User savUser(User user) {
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public ResponseDto getUser(int id) {
		// create object of responseDto
		ResponseDto responseDto = new ResponseDto();
		// get the user id
		User user = userRepository.findById(id);
		UserDto userDto = mapToUsers(user);
		PolicyDto policyDto = webClient.get().uri("http://localhost:8283/getPolicy/" + user.getId()).retrieve()
				.bodyToMono(PolicyDto.class).block();
		// set into responseto object
		responseDto.setUser(userDto);
		responseDto.setPolicy(policyDto);
		return responseDto;
	}

	public UserDto mapToUsers(User user) {
		// get the value from user and set it into userDto Object
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
