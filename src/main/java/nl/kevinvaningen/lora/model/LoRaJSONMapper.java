package nl.kevinvaningen.lora.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by cmi on 17/12/15.
 */
public class LoRaJSONMapper {

    public static LoraDataFrame processJSON(JSONObject json) throws IllegalArgumentException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            LoraDataFrame loraDataFrame = (LoraDataFrame) mapper.readValue(json.toString(), LoraDataFrame.class);
            loraDataFrame.setPayloadHex(LoRaJSONMapper.hexToString(loraDataFrame.getPayloadHex()));

            return loraDataFrame;
        } catch (IOException var5) {
            var5.printStackTrace();
            throw new IllegalArgumentException("JSON to object conversion failed");
        }
    }
    private static void manipulateOrAugmentLoraDataFrame(LoraDataFrame loraDataFrame) {
        loraDataFrame.setPayloadHex(LoRaJSONMapper.hexToString(loraDataFrame.getPayloadHex()));
    }

    private static String hexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {
            String output = hex.substring(i, i + 2);
            int decimal = Integer.parseInt(output, 16);
            sb.append((char) decimal);
            temp.append(decimal);
        }

        return sb.toString();
    }
}
