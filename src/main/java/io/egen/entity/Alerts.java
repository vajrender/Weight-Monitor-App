package io.egen.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document(collection="alerts")
public class Alerts {
 
	@Id 
    private String id;
	
    private String alert;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date timeStamp;

    public Alerts(){
    	this.alert = null;
    	this.timeStamp = new Date();
    }

    public Alerts(String alert, Date timeStamp){
        this.alert = alert;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format("[id = %s, alert = %s, timestamp = %s]", id, alert, timeStamp);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

} 
