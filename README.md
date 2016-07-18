# EGEN CODING CHALLENGE LEVEL 2

The goal of this exercise is to build a system that works like an IoT platform – in this case, a personal weight tracker. This system is responsible for,
•	Consuming data sent from different sensors (emulators)
•	Storing the received data in MongoDB
•	Running the data through different rules to make basic predictions

## TECHNOLOGIES USED
1. Morphia API
2. EasyRules
3. MongoDB

## IDE : Eclipse

**Operating System - Windows 10**

We have 2 controllers in the project

- Metric Controller performs the following operations
  create – this is the API that will consume data from the sensor emulator
  read – reads all the metrics stored in your database
  readByTimeRange – reads all the metrics that were created between the given two timestamps.
  
- Alerts Controller perform following operations
  read – reads all alerts that are stored in the database
  readByTimeRange – reads all alerts that are created between the given two timestamps
  
 I created 2 rules in this project:
 
 **UnderWeightRule**: If the weight of the person drops below 10% of his base weight, it will create a new alert and save it in the MongoDB.
 
 **OverWeightRule**: if the weight of the person shoots 10% over his base weight, it will create a new alert and save it in the MongoDB.
 
## STEPS TO RUN THE PROJECT

- Install MongoDb in the system.

- Download the Emulator-Sensor program from [I'm an inline-style link] https://github.com/egen/sensor-emulator and import it into Eclipse as Existing Maven Project. Right Click on the project Run As --> Maven clean and then Run As --> Maven install. A .jar with name sensor-emulator-0.0.1-SNAPSHOT.jar will be generated inside the target folder.

- Download the project as .zip from github and extract it. Import it into Eclipse as Existing Maven Project. Right Click on the project Run As --> Maven clean and then Run As --> Maven install. A .jar with name WeightMonitor-0.0.1-SNAPSHOT.jar will be created inside the target folder.

- Run the MongoDB.

- Open command Prompt, navigate to the target folder of WeightMonitor project and use the following command
  
  > java -jar WeightMonitor-0.0.1-SNAPSHOT.jar
  
- Open another Command prompt and navigate to the target folder of Emulator-Sensor project and use the following command

 > java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/metricsHandler/createMetrics    sensor-emulator-0.0.1-SNAPSHOT.jar
 
 Here the -Dbase.value can be set to any value, it will be taken as the base weight value.
 
 Use the following URL on the browser to read the metrics and the alerts
 
 http://localhost:8080/metrics/readMetrics  - used to get all the metrics
 
 http://localhost:8080/metrics/readMetricsByTimeRange/{from value}/{to value} - used to get the metrics between start time and end time.
 
  http://localhost:8080/alerts/readAlerts  - used to get all the alerts
 
 http://localhost:8080/alerts/readAlertsByTimeRange/{from value}/{to value} - used to get the alerts between start time and end time.
 
 

 
 
 
 