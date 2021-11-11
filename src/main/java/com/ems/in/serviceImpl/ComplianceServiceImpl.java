package com.ems.in.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ems.in.entity.Compliance;
import com.ems.in.exception.UserNotFoundException;
import com.ems.in.repo.IComplianceRepository;
import com.ems.in.service.IComplianceService;

@Service
@Component
public class ComplianceServiceImpl implements IComplianceService{
	
	@Autowired
	private IComplianceRepository compliancerepo;

	@Override
	public Compliance createRL(Compliance co)  {
		return compliancerepo.save(co);
		
	}

	@Override
	public List<Compliance> getAllRL()  
	{

		 List<Compliance> opt =  compliancerepo.findAll();
		 if(opt != null)
		 {
			 return opt;
		 }
		 else
		 {
			 throw new UserNotFoundException("Users Not Found!");
			 
		 }
	}



	@Override
	public Compliance getComplianceById(int compliancedId) 
	{
	
		 Optional<Compliance> opt = compliancerepo.findById(compliancedId); 
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		 else
		 {
			 throw new UserNotFoundException("User with given id "+compliancedId+" Not available");
			 
		 }
		 
	}
	
}
