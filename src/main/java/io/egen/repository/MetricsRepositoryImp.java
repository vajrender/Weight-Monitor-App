package io.egen.repository;

import java.util.Date;

import java.util.List;

import org.easyrules.api.RulesEngine;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.egen.ApplicationContextProvider;
import io.egen.entity.Metrics;
import io.egen.exception.MetricsException;
import io.egen.rules.OverWeightRule;
import io.egen.rules.UnderWeightRule;

@Repository
public class MetricsRepositoryImp implements MetricsRepository{

	private MongoOperations mongoOperations = (MongoOperations)ApplicationContextProvider.getApplicationContext().getBean("mongoTemplateBean");
	private RulesEngine rulesEngine = (RulesEngine)ApplicationContextProvider.getApplicationContext().getBean("rulesEngine");
	private OverWeightRule overWeightRule = (OverWeightRule)ApplicationContextProvider.getApplicationContext().getBean("overWeightRuleBean");
	private UnderWeightRule underWeightRule = (UnderWeightRule)ApplicationContextProvider.getApplicationContext().getBean("underWeightRuleBean");

	@ExceptionHandler(MetricsException.class)
	public Metrics createMetrics(Metrics metrics) {
		if(OverWeightRule.getOverWeightValue() == null){
			OverWeightRule.setOverWeightValue(metrics.getValue()+(metrics.getValue()/10));
		}
		if(UnderWeightRule.getUnderWeightValue() == null){
			UnderWeightRule.setUnderWeightValue(metrics.getValue()-(metrics.getValue()/10));
		}
		overWeightRule.setMetrics(metrics);
	 	underWeightRule.setMetrics(metrics);
		rulesEngine.fireRules();
		mongoOperations.save(metrics);
		return metrics;
	}

	@ExceptionHandler(MetricsException.class)
	public List<Metrics> readMetrics() {
		return mongoOperations.findAll(Metrics.class);
	}

	@ExceptionHandler(MetricsException.class) 
	public List<Metrics> readMetricsByTimeRange(String from, String to) {
		Date fromValue = new Date(Long.parseLong(from));
		Date toValue = new Date(Long.parseLong(to));
		Query query = new Query().addCriteria(Criteria.where("timeStamp").gt(fromValue).lte(toValue));
        return mongoOperations.find(query, Metrics.class);
			
	}	
}
