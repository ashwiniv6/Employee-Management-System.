package com.ems.in.service;

import com.ems.in.entity.User;
import com.ems.in.exception.UserNotFoundException;


public interface ILoginService {
	
    public User findByUserIdAndPassword(User user) throws UserNotFoundException;


}
