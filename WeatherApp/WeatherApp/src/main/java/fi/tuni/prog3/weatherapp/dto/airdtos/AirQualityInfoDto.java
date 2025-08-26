package fi.tuni.prog3.weatherapp.dto.airdtos;


public class AirQualityInfoDto {
    private String status;

    private AirDataDto data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AirDataDto getData() {
        return data;
    }

    public void setData(AirDataDto data) {
        this.data = data;
    }
}
