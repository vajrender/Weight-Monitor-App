package io.egen.repository;

import java.util.List;

import io.egen.entity.Metrics;

public interface MetricsRepository {

	public Metrics createMetrics(Metrics metrics);
	
	public List<Metrics> readMetrics();
	
	public List<Metrics> readMetricsByTimeRange(String from, String to);
}
