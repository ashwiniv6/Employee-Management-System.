package com.ems.in.service;

import java.util.List;
import com.ems.in.entity.Compliance;

public interface IComplianceService 
{
	
	public Compliance createRL(Compliance co);
	
	public List<Compliance> getAllRL() ;

//	public Compliance getAllRL(String userId) ;
	
	public Compliance getComplianceById(int compliancedId);

}
