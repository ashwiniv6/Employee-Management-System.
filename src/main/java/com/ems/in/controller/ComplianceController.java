package com.ems.in.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ems.in.entity.Compliance;
import com.ems.in.service.IComplianceService;

@Controller
@RequestMapping(value = "/compliance")
@CrossOrigin(value="http://localhost:3000")
public class ComplianceController 
{
 
	@Autowired
	private IComplianceService complianceservice;
	
	/*
	 * http:localhost:8080/compliance/create
	 */
	
		
		@PostMapping(value = "/create")
	    public ResponseEntity<String> createRL(@Valid @RequestBody Compliance compliance)
	    {
	        complianceservice.createRL(compliance);
	        String msg = "your compliance registered successfully";
	        return new  ResponseEntity<String>(msg, HttpStatus.CREATED);
	    }
	
	
	/*
	 * http:localhost:8080/compliance/getAll
	 */
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Compliance>> getAllRL() 
	{
		return new ResponseEntity<List<Compliance>>(complianceservice.getAllRL(), HttpStatus.OK);
		
	}
	


	
	@GetMapping(value = "/{compliancedId}")
    public ResponseEntity<Compliance> getComplianceById(@PathVariable int compliancedId)
    {

            return new ResponseEntity<Compliance>(complianceservice.getComplianceById(compliancedId), HttpStatus.OK);

    }
	
	
}
