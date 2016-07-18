package io.egen.repository;

import java.util.Date;


import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.egen.ApplicationContextProvider;
import io.egen.entity.Alerts;
import io.egen.exception.AlertsException;


@Repository
public class AlertsRepositoryImp implements AlertsRepository{

	private MongoOperations mongoOperations = (MongoOperations)ApplicationContextProvider.getApplicationContext().getBean("mongoTemplateBean");


	@ExceptionHandler(AlertsException.class) 
	public Alerts createAlerts(Alerts alert){
		mongoOperations.save(alert);
		return alert;
	}

	@ExceptionHandler(AlertsException.class) 
	public List<Alerts> readAlerts() {
		return mongoOperations.findAll(Alerts.class);
	}

	@ExceptionHandler(AlertsException.class)
	public List<Alerts> readAlertsByTimeRange(String from, String to) {
		Date fromValue = new Date(Long.parseLong(from));
		Date toValue = new Date(Long.parseLong(to));
		Query query = new Query().addCriteria(Criteria.where("timeStamp").gt(fromValue).lte(toValue));
        return mongoOperations.find(query, Alerts.class);
	}
}
