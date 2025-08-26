package fi.tuni.prog3.weatherapp.dto.airdtos;

public class PollutantDto {
    private double conc;

    private double aqius;

    private double aqicn;

    public double getConc() {
        return conc;
    }

    public void setConc(double conc) {
        this.conc = conc;
    }

    public double getAqius() {
        return aqius;
    }

    public void setAqius(double aqius) {
        this.aqius = aqius;
    }

    public double getAqicn() {
        return aqicn;
    }

    public void setAqicn(double aqicn) {
        this.aqicn = aqicn;
    }
}
