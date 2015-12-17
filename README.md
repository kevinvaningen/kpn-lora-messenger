# KPN-LoRa-message to MQTT server
A KPN LoRa to MQTT message broker. The ThingPark environment provide configureable routes. This creates a HTTP Post using the following format: [http://zakelijke-community.kpn.com/t5/Data/Application-data-API/ta-p/4768].

*Feel free to contact me for support or colaboration*

##Edit settings in config.properties 
Configure your own MQTT server (I use cloudmqtt.com for testing). Get your MQTT settings and edit the config.properties file in the resources/ directory. For more information, take a look at [https://www.eclipse.org/paho/clients/java/].
Setting parameters are:
```
MQTT_BROKER_URL=tcp:/<url>:<port>
MQTT_BROKER_USERNAME=<user>
MQTT_BROKER_PASSWORKD=<pass>
MQTT_CLIENT_ID=<Name of your mqtt client>
MQTT_QOS=<qos of the delivery. I tested the system with 0>
```

## Build your message server
CUrrently, new config requires new builds (or edit the config.properties in the .jar). To create a package install Maven and JDK 8 and type:
```
mvn package
```

## Online
Get a JRE 8 compatible server with enought outside access (port 8080 by default) and access to the MQTT broker. Run using:
```
java -jar messenger-0.0.1-SNAPSHOT.jar
```

##Set-up
Add a route in the ThingPark environment using the URL: <yourdomain>/loramessage/post
