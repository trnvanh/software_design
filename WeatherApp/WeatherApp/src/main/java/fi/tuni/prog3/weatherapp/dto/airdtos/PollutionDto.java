package fi.tuni.prog3.weatherapp.dto.airdtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PollutionDto {
    private String mainus;
    @JsonProperty("ts")
    private String ts;
    @JsonProperty("aqius")
    private int aqius;
    private String maincn;
    @JsonProperty("pm25")
    private double pm25;
    @JsonProperty("pm10")
    private double pm10;
    @JsonProperty("co")
    private double co;
    @JsonProperty("no2")
    private double no2;
    @JsonProperty("so2")
    private double so2;
    @JsonProperty("o3")
    private double o3;

    public String getMainus() {
        return mainus;
    }

    public void setMainus(String mainus) {
        this.mainus = mainus;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public int getAqius() {
        return aqius;
    }

    public void setAqius(int aqius) {
        this.aqius = aqius;
    }

    public String getMaincn() {
        return maincn;
    }

    public void setMaincn(String maincn) {
        this.maincn = maincn;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }
}
