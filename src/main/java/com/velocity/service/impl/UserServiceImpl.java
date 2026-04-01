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

	@Override
    public String test() {
        return "User Service Running 🚀";
}

}
