package nl.kevinvaningen.lora;

import org.json.JSONObject;
import org.json.XML;

/**
 * Created by cmi on 17/12/15.
 */
public class XMLtoJSONConverter {
        public static JSONObject convertXMLtoJson(String payload) {
            return XML.toJSONObject(payload).getJSONObject("DevEUI_uplink");
        }

}
