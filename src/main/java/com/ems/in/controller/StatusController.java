package com.ems.in.controller;



import java.util.Optional;

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
import com.ems.in.entity.StatusReport;
import com.ems.in.service.IStatusService;


@Controller
@RequestMapping(value = "/status")
@CrossOrigin(origins = "http://localhost:3000")
public class StatusController
{

@Autowired
private IStatusService statusservice;

/*
* http:localhost:8080/status/statusreport
*/
@PostMapping(value = "/statusreport")
public ResponseEntity<String> createStatusReport(@Valid @RequestBody StatusReport statusreport)
{
statusservice.createStatusReport(statusreport);
return new ResponseEntity<String>("report created",HttpStatus.ACCEPTED);

}



/*
* http:localhost:8080/status/statusreport/{statusId}
*/
@GetMapping(value = "/statusreport/{statusId}")
public ResponseEntity<Optional<StatusReport>> getAllStatusReport(@PathVariable int statusId)
{
Optional<StatusReport> getallstatusreport = statusservice.getAllStatusReport(statusId);
return new ResponseEntity<Optional<StatusReport>>(getallstatusreport,HttpStatus.OK);
}






}