package com.ems.in.service;



import java.util.Optional;



import com.ems.in.entity.StatusReport;



public interface IStatusService {
public void createStatusReport(StatusReport statusreport);
public Optional<StatusReport> getAllStatusReport(int statusId);



}