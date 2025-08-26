package fi.tuni.prog3.weatherapp.dto.airdtos;

public class AirForecastDto {
    private String ts;

    private double aqius;

    private double aqicn;

    private double tp;

    private double tpMin;

    private double pr;

    private double hu;

    private double ws;

    private double wd;

    private String ic;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
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

    public double getTp() {
        return tp;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    public double getTpMin() {
        return tpMin;
    }

    public void setTpMin(double tpMin) {
        this.tpMin = tpMin;
    }

    public double getPr() {
        return pr;
    }

    public void setPr(double pr) {
        this.pr = pr;
    }

    public double getHu() {
        return hu;
    }

    public void setHu(double hu) {
        this.hu = hu;
    }

    public double getWs() {
        return ws;
    }

    public void setWs(double ws) {
        this.ws = ws;
    }

    public double getWd() {
        return wd;
    }

    public void setWd(double wd) {
        this.wd = wd;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }
}
