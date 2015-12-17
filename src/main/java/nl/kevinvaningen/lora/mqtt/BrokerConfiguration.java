package nl.kevinvaningen.lora.mqtt;

import java.util.Optional;
import java.util.Properties;

/***
 * The BrokerConfiguration reader
 */
public class BrokerConfiguration {
    private Properties props;

    public BrokerConfiguration(Properties p){
        this.props = p;
    }

    public String getBrokerUrl(){
        return (String) props.get("MQTT_BROKER_URL");
    }
    public String getBrokerUsername(){
        return (String)props.get("MQTT_BROKER_USERNAME");
    }

    public Optional<String> getBrokerPassword() {
        return Optional.ofNullable((String) (props.get("MQTT_BROKER_PASSWORKD")));
    }
    public int getBrokerQos(){
        return Integer.parseInt((String)props.get("MQTT_QOS"));
    }
    public String getClientId(){
        return (String) props.get("MQTT_CLIENT_ID");
    }
    public boolean usesCredentials(){
        return getBrokerPassword().map(s -> !s.equals("")).orElse(false);
    }
}