package com.ems.in.serviceImpl;



import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.ems.in.entity.StatusReport;
import com.ems.in.repo.IStatusRepository;
import com.ems.in.service.IStatusService;



@Service
public class StatusServiceImpl implements IStatusService
{
@Autowired
private IStatusRepository statusrepo;





@Override
public void createStatusReport(StatusReport statusreport) {

statusrepo.save(statusreport);
}



@Override
public Optional<StatusReport> getAllStatusReport(int statusId) {

return statusrepo.findById(statusId);
}

}