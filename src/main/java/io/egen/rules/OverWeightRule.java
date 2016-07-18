package io.egen.rules;

import org.easyrules.annotation.Action;

import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import io.egen.ApplicationContextProvider;
import io.egen.entity.Alerts;
import io.egen.entity.Metrics;
import io.egen.repository.AlertsRepositoryImp;

@Rule(name = "OVER WEIGHT RULE")
public class OverWeightRule {
	
	private static Integer overWeightValue;
	private Metrics metrics;
	private AlertsRepositoryImp alertsDelegate = (AlertsRepositoryImp)ApplicationContextProvider.getApplicationContext().getBean("alertsRepositoryBean");
		
	@Condition
	
	public boolean when(){
		 
		if(metrics.getValue() > overWeightValue)
			return true;
		else
			return false;
		
	}

	@Action
	public void then(){
		Alerts alert = new Alerts();
		alert.setAlert("OVER WEIGHT ALERT: Weight is greater than 10 percent of base weight");		 
		alert.setTimeStamp(metrics.getTimeStamp());
		alertsDelegate.createAlerts(alert);
	}

	public static Integer getOverWeightValue() {
		return overWeightValue;
	}

	public static void setOverWeightValue(Integer overWeightValue) {
		OverWeightRule.overWeightValue = overWeightValue;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}




}
