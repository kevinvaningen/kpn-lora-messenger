package nl.kevinvaningen.lora;

import nl.kevinvaningen.lora.mqtt.BrokerConfiguration;
import nl.kevinvaningen.lora.mqtt.ConfigurationReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoRaMessengerApplication {

    private static BrokerConfiguration MQTTCONFIGURATION;
    private final static Logger LOGGER = LoggerFactory.getLogger(LoRaMessengerApplication.class);
    private final static ConfigurationReader configurationReader = new ConfigurationReader();

    /***
     * Main Spring Boot runtime method. Use it to innitialize the serversoftware and embedded webserver
     * @param args
     */
    public static void main(String[] args) {
        //SpringApplication.run(LoRaMessengerApplication.class, args);
        LOGGER.info("Starting messenger application.");

        MQTTCONFIGURATION = configurationReader.getBrokerConfiguration();


        if(MQTTCONFIGURATION != null) {
            SpringApplication.run(LoRaMessengerApplication.class, args);
            LOGGER.debug("Broker configuration-url is: "+MQTTCONFIGURATION.getBrokerUrl());
        }else{
            String fault = "Sprint could not innitialize application due to bad MQTT configuration.";
            LOGGER.error(fault);
            throw new RuntimeException(fault);
        }
    }

    /***
     * Returns this Applications broker configuration, as defined in config.properties in resources.
     * @return
     */
    public static BrokerConfiguration getApplicationBrokerConfiguration(){
        return MQTTCONFIGURATION;
    }
}
