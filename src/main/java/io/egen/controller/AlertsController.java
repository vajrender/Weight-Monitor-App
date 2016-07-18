package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.egen.entity.Alerts;
import io.egen.exception.AlertsException;
import io.egen.repository.AlertsRepositoryImp;


@RestController
@RequestMapping(value = "/alerts")
public final class AlertsController {

	@Autowired
	private AlertsRepositoryImp alertsRepository ; 

	@RequestMapping(value = "/readAlerts", method = RequestMethod.GET)
	@ExceptionHandler(AlertsException.class)
	public List<Alerts> readAlerts(UriComponentsBuilder builder){
		
		List<Alerts> response = alertsRepository.readAlerts();
		return response;
	}
	
	@RequestMapping(value = "/readAlertsByTimeRange/{fromDate}/{toDate}", method = RequestMethod.GET)
	@ExceptionHandler(AlertsException.class)
	public List<Alerts> readAlertsByTimeRange(@PathVariable(value = "fromDate") String fromDate, 
			@PathVariable(value = "toDate") String toDate){
		
		List<Alerts> response = alertsRepository.readAlertsByTimeRange(fromDate, toDate);
		return response;
	}
	
	 
}
