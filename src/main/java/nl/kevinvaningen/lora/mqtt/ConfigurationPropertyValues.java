package nl.kevinvaningen.lora.mqtt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ConfigurationPropertyValues {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationPropertyValues.class);
    private InputStream inputStream;
    private static final String PROPERTY_FILE_FILE_NAME = "config.properties";

    ConfigurationPropertyValues() {
    }

    public Properties getDefaultPropertyFileValues() throws IOException {
        Properties prop = new Properties();

        try {
            this.inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            if(this.inputStream == null) {
                throw new FileNotFoundException("property file \'config.properties\' not found in the classpath");
            }

            prop.load(this.inputStream);
        } catch (Exception var6) {
            LOGGER.error("Exception in loading config.properties.: " + var6);
        } finally {
            this.inputStream.close();
        }

        return prop;
    }

    public static Properties getDefaultProperties() {
        Properties prop = new Properties();
        prop.setProperty("MQTT_BROKER_URL", "tcp://localhost:1883");
        prop.setProperty("MQTT_CLIENT_ID", "CityGis csv pusher");
        prop.setProperty("MQTT_QOS", "0");
        LOGGER.info("Defaulting to localhost configuration. Configuration:" + prop.toString());
        return prop;
    }

    public static Properties createProperties(String hostName, String userName, String password, String clientId, String qos) {
        Properties prop = new Properties();
        prop.setProperty("MQTT_BROKER_URL", hostName);
        prop.setProperty("MQTT_CLIENT_ID", clientId);
        prop.setProperty("MQTT_QOS", qos);
        if(userName != null) {
            prop.setProperty("MQTT_BROKER_USERNAME", userName);
            prop.setProperty("MQTT_BROKER_PASSWORKD", password);
        }

        return prop;
    }
}
