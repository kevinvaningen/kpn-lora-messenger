package nl.kevinvaningen.lora.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"LrrSNR", "Lrrid", "Lrrs", "SpFact", "SubBand", "CustomerData", "FPort", "Channel", "FCntUp", "Time", "DevEUI", "payload_hex", "CustomerID", "LrrRSSI", "mic_hex", "xmlns", "LrrLON", "LrrLAT", "FCntDn", "Lrcid", "DevLrrCnt"})
public class LoraDataFrame {
    @JsonProperty("LrrSNR")
    private String LrrSNR;
    @JsonProperty("Lrrid")
    private String Lrrid;
    @JsonProperty("Lrrs")
    private LoraDataFrameLrrs Lrrs;
    @JsonProperty("SpFact")
    private int SpFact;
    @JsonProperty("SubBand")
    private String SubBand;
    @JsonProperty("CustomerData")
    private String CustomerData;
    @JsonProperty("FPort")
    private int FPort;
    @JsonProperty("Channel")
    private String Channel;
    @JsonProperty("FCntUp")
    private int FCntUp;
    @JsonProperty("Time")
    private String Time;
    @JsonProperty("DevEUI")
    private String DevEUI;
    @JsonProperty("payload_hex")
    private String payloadHex;
    @JsonProperty("CustomerID")
    private int CustomerID;
    @JsonProperty("LrrRSSI")
    private String LrrRSSI;
    @JsonProperty("mic_hex")
    private String micHex;
    @JsonProperty("xmlns")
    private String xmlns;
    @JsonProperty("LrrLON")
    private double LrrLON;
    @JsonProperty("LrrLAT")
    private double LrrLAT;
    @JsonProperty("FCntDn")
    private int FCntDn;
    @JsonProperty("Lrcid")
    private String Lrcid;
    @JsonProperty("DevLrrCnt")
    private int DevLrrCnt;

    public LoraDataFrame() {
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

    @JsonProperty("Lrrs")
    public LoraDataFrameLrrs getLrrs() {
        return this.Lrrs;
    }

    @JsonProperty("Lrrs")
    public void setLrrs(LoraDataFrameLrrs Lrrs) {
        this.Lrrs = Lrrs;
    }

    @JsonProperty("SpFact")
    public int getSpFact() {
        return this.SpFact;
    }

    @JsonProperty("SpFact")
    public void setSpFact(int SpFact) {
        this.SpFact = SpFact;
    }

    @JsonProperty("SubBand")
    public String getSubBand() {
        return this.SubBand;
    }

    @JsonProperty("SubBand")
    public void setSubBand(String SubBand) {
        this.SubBand = SubBand;
    }

    @JsonProperty("CustomerData")
    public String getCustomerData() {
        return this.CustomerData;
    }

    @JsonProperty("CustomerData")
    public void setCustomerData(String CustomerData) {
        this.CustomerData = CustomerData;
    }

    @JsonProperty("FPort")
    public int getFPort() {
        return this.FPort;
    }

    @JsonProperty("FPort")
    public void setFPort(int FPort) {
        this.FPort = FPort;
    }

    @JsonProperty("Channel")
    public String getChannel() {
        return this.Channel;
    }

    @JsonProperty("Channel")
    public void setChannel(String Channel) {
        this.Channel = Channel;
    }

    @JsonProperty("FCntUp")
    public int getFCntUp() {
        return this.FCntUp;
    }

    @JsonProperty("FCntUp")
    public void setFCntUp(int FCntUp) {
        this.FCntUp = FCntUp;
    }

    @JsonProperty("Time")
    public String getTime() {
        return this.Time;
    }

    @JsonProperty("Time")
    public void setTime(String Time) {
        this.Time = Time;
    }

    @JsonProperty("DevEUI")
    public String getDevEUI() {
        return this.DevEUI;
    }

    @JsonProperty("DevEUI")
    public void setDevEUI(String DevEUI) {
        this.DevEUI = DevEUI;
    }

    @JsonProperty("payload_hex")
    public String getPayloadHex() {
        return this.payloadHex;
    }

    @JsonProperty("payload_hex")
    public void setPayloadHex(String payloadHex) {
        this.payloadHex = payloadHex;
    }

    @JsonProperty("CustomerID")
    public int getCustomerID() {
        return this.CustomerID;
    }

    @JsonProperty("CustomerID")
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    @JsonProperty("LrrRSSI")
    public String getLrrRSSI() {
        return this.LrrRSSI;
    }

    @JsonProperty("LrrRSSI")
    public void setLrrRSSI(String LrrRSSI) {
        this.LrrRSSI = LrrRSSI;
    }

    @JsonProperty("mic_hex")
    public String getMicHex() {
        return this.micHex;
    }

    @JsonProperty("mic_hex")
    public void setMicHex(String micHex) {
        this.micHex = micHex;
    }

    @JsonProperty("xmlns")
    public String getXmlns() {
        return this.xmlns;
    }

    @JsonProperty("xmlns")
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @JsonProperty("LrrLON")
    public double getLrrLON() {
        return this.LrrLON;
    }

    @JsonProperty("LrrLON")
    public void setLrrLON(double LrrLON) {
        this.LrrLON = LrrLON;
    }

    @JsonProperty("LrrLAT")
    public double getLrrLAT() {
        return this.LrrLAT;
    }

    @JsonProperty("LrrLAT")
    public void setLrrLAT(double LrrLAT) {
        this.LrrLAT = LrrLAT;
    }

    @JsonProperty("FCntDn")
    public int getFCntDn() {
        return this.FCntDn;
    }

    @JsonProperty("FCntDn")
    public void setFCntDn(int FCntDn) {
        this.FCntDn = FCntDn;
    }

    @JsonProperty("Lrcid")
    public String getLrcid() {
        return this.Lrcid;
    }

    @JsonProperty("Lrcid")
    public void setLrcid(String Lrcid) {
        this.Lrcid = Lrcid;
    }

    @JsonProperty("DevLrrCnt")
    public int getDevLrrCnt() {
        return this.DevLrrCnt;
    }

    @JsonProperty("DevLrrCnt")
    public void setDevLrrCnt(int DevLrrCnt) {
        this.DevLrrCnt = DevLrrCnt;
    }

    public String toString() {
        return LoraDataFrame.class.getSimpleName() + " {" + "LrrSNR=\'" + this.LrrSNR + '\'' + ", Lrrid=\'" + this.Lrrid + '\'' + ", Lrrs=" + this.Lrrs.toString() + ", SpFact=" + this.SpFact + ", SubBand=\'" + this.SubBand + '\'' + ", CustomerData=\'" + this.CustomerData + '\'' + ", FPort=" + this.FPort + ", Channel=\'" + this.Channel + '\'' + ", FCntUp=" + this.FCntUp + ", Time=\'" + this.Time + '\'' + ", DevEUI=\'" + this.DevEUI + '\'' + ", payloadHex=\'" + this.payloadHex + '\'' + ", CustomerID=" + this.CustomerID + ", LrrRSSI=\'" + this.LrrRSSI + '\'' + ", micHex=\'" + this.micHex + '\'' + ", xmlns=\'" + this.xmlns + '\'' + ", LrrLON=" + this.LrrLON + ", LrrLAT=" + this.LrrLAT + ", FCntDn=" + this.FCntDn + ", Lrcid=\'" + this.Lrcid + '\'' + ", DevLrrCnt=" + this.DevLrrCnt + '}';
    }
}
