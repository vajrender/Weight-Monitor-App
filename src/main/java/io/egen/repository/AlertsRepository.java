package io.egen.repository;

import java.util.List;

import io.egen.entity.Alerts;

public interface AlertsRepository {
	
	public Alerts createAlerts(Alerts alert);
	
	public List<Alerts> readAlerts();
	
	public List<Alerts> readAlertsByTimeRange(String from, String to);

}
