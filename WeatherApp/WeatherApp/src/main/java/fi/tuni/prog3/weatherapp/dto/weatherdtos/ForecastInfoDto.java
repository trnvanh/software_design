package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import java.util.ArrayList;
import java.util.List;

public class ForecastInfoDto {

    private List<ForecastDto> list = new ArrayList<>(); // List of forecast data

    private String cod; // Internal parameter

    private int message; // Internal parameter

    private int cnt; // Number of forecasts returned

    public List<ForecastDto> getList() {
        return list;
    }

    public void setList(List<ForecastDto> list) {
        this.list = list;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}