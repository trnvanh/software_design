package fi.tuni.prog3.weatherapp.dto.airdtos;

public class ResponseDto {
    private String status;

    private AirDataDto airData;

    public AirDataDto getAirData() {
        return airData;
    }

    public String getStatus() {
        return status;
    }

    public void setAirData(AirDataDto airData) {
        this.airData = airData;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
