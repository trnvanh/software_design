package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ForeCastInfoDto {

    private List<ForecastDto> list = new ArrayList<>();

    private String cod;

    private int message;

    private int cnt;

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