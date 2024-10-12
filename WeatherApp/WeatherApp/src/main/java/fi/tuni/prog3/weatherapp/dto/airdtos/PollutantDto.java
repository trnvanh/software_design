package fi.tuni.prog3.weatherapp.dto.airdtos;

public class PollutantDto {
    private double concentration;

    private double aqiUs;

    private double aqiCn;

    public double getAqiUs() {
        return aqiUs;
    }

    public double getAqiCn() {
        return aqiCn;
    }

    public double getConcentration() {
        return concentration;
    }

    public void setAqiUs(double aqiUs) {
        this.aqiUs = aqiUs;
    }

    public void setAqiCn(double aqiCn) {
        this.aqiCn = aqiCn;
    }

    public void setConcentration(double concentration) {
        this.concentration = concentration;
    }
}
