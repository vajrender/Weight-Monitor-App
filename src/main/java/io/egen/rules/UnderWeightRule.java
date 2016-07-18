package io.egen.rules;

import java.util.Date;


import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import io.egen.ApplicationContextProvider;
import io.egen.entity.Alerts;
import io.egen.entity.Metrics;
import io.egen.repository.AlertsRepositoryImp;


@Rule(name= "UNDER WEIGHT RULE")
public class UnderWeightRule {
 
	private static Integer underWeightValue;  
	private Metrics metrics;
	private AlertsRepositoryImp alertsDelegate = (AlertsRepositoryImp)ApplicationContextProvider.getApplicationContext().getBean("alertsRepositoryBean");	
	
	@Condition
	
	public boolean when(){
		
		if(metrics.getValue() < UnderWeightRule.underWeightValue)
			return true;
		else
			return false;
		}

	@Action
	public void then(){
		Alerts alert = new Alerts();
		alert.setAlert("UNDER WEIGHT ALERT: Weight is lesser than 10 percent of base weight");		 
		alert.setTimeStamp(new Date());
		alertsDelegate.createAlerts(alert);
		
	}

	public static Integer getUnderWeightValue() {
		return underWeightValue;
	}

	public static void setUnderWeightValue(Integer underWeightValue) {
		UnderWeightRule.underWeightValue = underWeightValue;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}

}
