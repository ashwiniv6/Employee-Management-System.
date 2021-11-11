package com.ems.in.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.in.entity.User;
import com.ems.in.exception.UserNotFoundException;
import com.ems.in.service.ILoginService;

@RestController
@RequestMapping(value="/users1")
@CrossOrigin(value="http://localhost:3000")

public class UserController {
	
    @Autowired(required=true)
    private ILoginService iloginService;

    @PostMapping(value="/login")
    public ResponseEntity<String> findByUserIdAndPassword(@Valid @RequestBody User user) throws UserNotFoundException{
    	
     iloginService.findByUserIdAndPassword(user);
     String msg ="Login Success";
     return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

}
