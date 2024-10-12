package fi.tuni.prog3.weatherapp.dto.airdtos;

public class PollutionDto {
    private String ts; // timestamp

    private double aqiUs;

    private String mainUs; // main pollutant us

    private double aqiCn;

    private String mainCn; // main pollutant china

    private PollutantDto pollutant;

    public void setAqiCn(double aqiCn) {
        this.aqiCn = aqiCn;
    }

    public void setAqiUs(double aqiUs) {
        this.aqiUs = aqiUs;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public void setPollutant(PollutantDto pollutant) {
        this.pollutant = pollutant;
    }

    public void setMainCn(String mainCn) {
        this.mainCn = mainCn;
    }

    public void setMainUs(String mainUs) {
        this.mainUs = mainUs;
    }

    public double getAqiCn() {
        return aqiCn;
    }

    public double getAqiUs() {
        return aqiUs;
    }

    public String getTs() {
        return ts;
    }

    public PollutantDto getPollutant() {
        return pollutant;
    }

    public String getMainCn() {
        return mainCn;
    }

    public String getMainUs() {
        return mainUs;
    }
}
