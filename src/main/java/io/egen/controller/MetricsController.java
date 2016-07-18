package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.egen.entity.Metrics;
import io.egen.exception.MetricsException;
import io.egen.repository.MetricsRepositoryImp;

@RestController
@RequestMapping(value = "/metrics")
public final class MetricsController {

	@Autowired
	private MetricsRepositoryImp metricsRepository;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ExceptionHandler(MetricsException.class)
	public ResponseEntity<String> createMetrics(@RequestBody Metrics metrics, UriComponentsBuilder builder){
		HttpHeaders headers = new HttpHeaders();
		metricsRepository.createMetrics(metrics);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/readMetrics", method = RequestMethod.GET)
	@ExceptionHandler(MetricsException.class)
	public List<Metrics> readMetrics(UriComponentsBuilder builder){
		
		List<Metrics> response = metricsRepository.readMetrics();
		return response;
	}

	@RequestMapping(value = "/readMetricsByTimeRange/{fromDate}/{toDate}", method = RequestMethod.GET)
	@ExceptionHandler(MetricsException.class)
	public List<Metrics> readMetricsByTimeRange(@PathVariable(value = "fromDate") String fromDate, 
			@PathVariable(value = "toDate") String toDate){
		
		List<Metrics> response = metricsRepository.readMetricsByTimeRange(fromDate, toDate);
		return response;
	}	 
}
