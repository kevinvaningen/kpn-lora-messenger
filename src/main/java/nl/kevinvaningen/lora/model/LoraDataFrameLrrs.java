package nl.kevinvaningen.lora.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"Lrr"})
public class LoraDataFrameLrrs {
    @JsonProperty("Lrr")
    private LoraDataFrameLrr Lrr;

    public LoraDataFrameLrrs() {
    }

    @JsonProperty("Lrr")
    public LoraDataFrameLrr getLrr() {
        return this.Lrr;
    }

    @JsonProperty("Lrr")
    public void setLrr(LoraDataFrameLrr Lrr) {
        this.Lrr = Lrr;
    }

    public String toString() {
        return LoraDataFrameLrrs.class.getSimpleName() + " {" + "Lrr=" + this.Lrr.toString() + '}';
    }
}