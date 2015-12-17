package nl.kevinvaningen.lora.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"LrrSNR", "Lrrid", "LrrRSSI"})
public class LoraDataFrameLrr {
    @JsonProperty("LrrSNR")
    private String LrrSNR;
    @JsonProperty("Lrrid")
    private String Lrrid;
    @JsonProperty("LrrRSSI")
    private String LrrRSSI;

    public LoraDataFrameLrr() {
    }

    @JsonProperty("LrrSNR")
    public String getLrrSNR() {
        return this.LrrSNR;
    }

    @JsonProperty("LrrSNR")
    public void setLrrSNR(String LrrSNR) {
        this.LrrSNR = LrrSNR;
    }

    @JsonProperty("Lrrid")
    public String getLrrid() {
        return this.Lrrid;
    }

    @JsonProperty("Lrrid")
    public void setLrrid(String Lrrid) {
        this.Lrrid = Lrrid;
    }

    @JsonProperty("LrrRSSI")
    public String getLrrRSSI() {
        return this.LrrRSSI;
    }

    @JsonProperty("LrrRSSI")
    public void setLrrRSSI(String LrrRSSI) {
        this.LrrRSSI = LrrRSSI;
    }

    public String toString() {
        return LoraDataFrameLrr.class.getSimpleName() + " {" + "LrrSNR=\'" + this.LrrSNR + '\'' + ", Lrrid=\'" + this.Lrrid + '\'' + ", LrrRSSI=\'" + this.LrrRSSI + '\'' + '}';
    }
}
