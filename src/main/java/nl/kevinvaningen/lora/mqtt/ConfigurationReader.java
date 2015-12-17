package nl.kevinvaningen.lora.mqtt;

import java.io.IOException;
import java.util.Properties;
import nl.kevinvaningen.lora.mqtt.BrokerConfiguration;
import nl.kevinvaningen.lora.mqtt.ConfigurationPropertyValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationReader {
    private static final ConfigurationPropertyValues properties = new ConfigurationPropertyValues();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationReader.class);

    public ConfigurationReader() {
    }

    public BrokerConfiguration getBrokerConfiguration() {
        LOGGER.debug("Returning system configuration for broker.");

        try {
            return new BrokerConfiguration(this.tryReadingSystemProperties());
        } catch (IOException var2) {
            var2.printStackTrace();
            LOGGER.error("Error reading property file. Exiting software " + var2.toString());
            throw new RuntimeException(var2);
        }
    }

    public BrokerConfiguration getCommandlineBrokerConfiguration(String host, String user, String pass, String clientId, String qos) {
        LOGGER.debug("Returning argument based configuration for broker.");
        return new BrokerConfiguration(ConfigurationPropertyValues.createProperties(host, user, pass, clientId, qos));
    }

    private Properties tryReadingSystemProperties() throws IOException {
        return properties.getDefaultPropertyFileValues();
    }
}
