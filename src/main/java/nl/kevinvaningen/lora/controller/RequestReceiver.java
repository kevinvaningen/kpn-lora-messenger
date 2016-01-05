package nl.kevinvaningen.lora.controller;

import nl.kevinvaningen.lora.LoRaMessengerApplication;
import nl.kevinvaningen.lora.Publishable;
import nl.kevinvaningen.lora.XMLtoJSONConverter;
import nl.kevinvaningen.lora.model.LoRaJSONMapper;
import nl.kevinvaningen.lora.model.LoraDataFrame;
import nl.kevinvaningen.lora.mqtt.MqttBrokerClientConnector;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/loramessage/"})
public class RequestReceiver {

    public static final String LORA__TOPIC = "LORA";

    private Publishable mqttBrokerClientConnector;
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestReceiver.class);


    @RequestMapping(value = {"/post"}, method = {RequestMethod.POST})
    public void post(@RequestBody String rawHTTPPayload) {
        LOGGER.debug("HTTP input: " + rawHTTPPayload.toString());
        this.processRequest(rawHTTPPayload);
    }

    private void processRequest(String rawHTTPPayload) {
        JSONObject json = XMLtoJSONConverter.convertXMLtoJson(rawHTTPPayload);
        LOGGER.debug("HTTP raw xml to json JSON: " + json.toString());
        LoraDataFrame loraDataFrame = LoRaJSONMapper.processJSON(json);
        LOGGER.debug("LoRa object converter: "+loraDataFrame.toString());
        transferToMqtt(loraDataFrame);
    }

    private void transferToMqtt(LoraDataFrame loraDataFrame) {
        LOGGER.debug("Trying to transfer dataframe devue: "+loraDataFrame.getDevEUI() +" time: "+loraDataFrame.getTime());

        if (LoRaMessengerApplication.getApplicationBrokerConfiguration() != null) {
            this.mqttBrokerClientConnector = new MqttBrokerClientConnector(LoRaMessengerApplication.getApplicationBrokerConfiguration());
            mqttBrokerClientConnector.publish(LORA__TOPIC, loraDataFrame.toString());
        } else {
            LOGGER.error("Error occured in MQTT config. Cannot publish.");
            throw new RuntimeException("Error occured in setting MQTT config.");
        }
    }
}
