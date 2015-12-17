package nl.kevinvaningen.lora.mqtt;

import java.io.UnsupportedEncodingException;

import nl.kevinvaningen.lora.Publishable;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttBrokerClientConnector implements Publishable {
    private MqttClient mqttConnectedClient;
    private MqttConnectOptions connectionOptions = new MqttConnectOptions();
    private int qos;
    private String broker;
    private String clientId;
    private static final Logger LOGGER = LoggerFactory.getLogger(MqttBrokerClientConnector.class);

    public MqttBrokerClientConnector() {
        LOGGER.debug("Setting up " + MqttBrokerClientConnector.class.getSimpleName() + "without arguments, defaulting to config.properties file-based configuration.");
        ConfigurationReader configurationReader = new ConfigurationReader();
        this.setConnectionProperties(configurationReader.getBrokerConfiguration());
    }

    public MqttBrokerClientConnector(BrokerConfiguration brokerConfiguration) {
        LOGGER.debug("Setting up " + MqttBrokerClientConnector.class.getSimpleName() + " using broker argument configuration.");
        this.setConnectionProperties(brokerConfiguration);
    }

    public void connect() {
        try {
            this.mqttConnectedClient = new MqttClient(this.broker, this.clientId, new MemoryPersistence());
            this.mqttConnectedClient.connect(this.connectionOptions);
            LOGGER.info("Connected to broker at:" + this.mqttConnectedClient.getServerURI());
        } catch (MqttException var2) {
            LOGGER.error("Failed to connect to broker" + this.broker + " at " + this.mqttConnectedClient.getServerURI());
            var2.printStackTrace();
        }

    }

    public boolean isConnectedToServer() {
        return this.mqttConnectedClient == null?false:this.mqttConnectedClient.isConnected();
    }

    public void disconnectFromBroker() {
        try {
            this.mqttConnectedClient.disconnect();
            LOGGER.debug("Broker disconnected from:");
        } catch (NullPointerException var2) {
            LOGGER.debug("Broker didnt existed.");
        } catch (MqttException var3) {
            this.logMqttException(var3);
            var3.printStackTrace();
        }

    }

    public boolean publish(String topic, String message) {
        if(this.isConnectedToServer()) {
            try {
                LOGGER.debug("Publishing message: " + message);
                MqttMessage e = new MqttMessage(message.getBytes("UTF8"));
                e.setQos(this.qos);
                this.mqttConnectedClient.publish(topic, e);
                return true;
            } catch (MqttException var4) {
                this.logMqttException(var4);
                return false;
            } catch (UnsupportedEncodingException var5) {
                LOGGER.error("Unsupported UTF8 encoding exception.");
                return false;
            }
        } else {
            this.connect();
            this.publish(topic, message);
            return false;
        }
    }

    private void setConnectionProperties(BrokerConfiguration brokerConfiguration) {
        this.qos = brokerConfiguration.getBrokerQos();
        this.broker = brokerConfiguration.getBrokerUrl();
        this.clientId = brokerConfiguration.getClientId();
        this.connectionOptions.setCleanSession(true);
        if(brokerConfiguration.usesCredentials()) {
            this.connectionOptions.setUserName(brokerConfiguration.getBrokerUsername());
            this.connectionOptions.setPassword(((String)brokerConfiguration.getBrokerPassword().get()).toCharArray());
        }

    }

    private void logMqttException(MqttException me) {
        LOGGER.error("reason " + me.getReasonCode() + " msg " + me.getMessage() + " loc " + me.getLocalizedMessage() + " cause " + me.getCause() + " excep " + me.toString());
    }
}
