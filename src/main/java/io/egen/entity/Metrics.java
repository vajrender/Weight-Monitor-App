package io.egen.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document(collection="metrics")
public class Metrics {

	@Id
    private String id;
	
    private Integer value;
    
     @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date timeStamp;

        public Metrics(){
    	this.value = 0;
    	this.timeStamp = new Date();
    }

    public Metrics(Integer value, Date timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format("[id = %s, value = %s, timestamp = %s]", id, value, timeStamp);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
} 
