package nl.kevinvaningen.lora;

import org.json.JSONObject;
import org.json.XML;

/**
 * Created by cmi on 17/12/15.
 */
public class XMLtoJSONConverter {

    private static final String MESSAGE_ROOT_ELEMENT_DEV_EUI_UPLINK = "DevEUI_uplink";

    public static JSONObject convertXMLtoJson(String payload) {
        return XML.toJSONObject(payload).getJSONObject(MESSAGE_ROOT_ELEMENT_DEV_EUI_UPLINK);
        }

}
