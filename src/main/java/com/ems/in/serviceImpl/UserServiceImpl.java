package com.ems.in.serviceImpl;
import com.ems.in.entity.*;

import java.util.Optional;


import javax.transaction.Transactional;
import com.ems.in.exception.UserNotFoundException;
import com.ems.in.repo.ILoginRepository;
import com.ems.in.service.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements ILoginService
{
	
	@Autowired
	private ILoginRepository iloginRepository;

	@Override
	public User findByUserIdAndPassword(com.ems.in.entity.User user) 
	{
      Optional<User> opt=iloginRepository.findByUserIdAndPassword(user.getUserId(),user.getPassword());
      if(opt.isPresent())
        {
            return opt.get();
        }
        else
        {
            throw new UserNotFoundException("User not found");
        }
		
	}


   }

	



