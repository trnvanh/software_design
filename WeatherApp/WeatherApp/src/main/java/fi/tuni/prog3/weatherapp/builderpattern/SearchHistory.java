package fi.tuni.prog3.weatherapp.builderpattern;

import java.time.LocalDate;


public class SearchHistory {
    private final Long userId;
    private final LocalDate fromDate;
    private final LocalDate toDate;
    private final String cityName;

    public Long getUserId() {
        return userId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public String getCityName() {
        return cityName;
    }

    private SearchHistory(SearchBuilder builder) {
        this.userId = builder.userId;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
        this.cityName = builder.cityName;
    }

    public static class SearchBuilder {
        private Long userId;
        private LocalDate fromDate;
        private LocalDate toDate;
        private String cityName;

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public void setFromDate(LocalDate fromDate) {
            this.fromDate = fromDate;
        }

        public void setToDate(LocalDate toDate) {
            this.toDate = toDate;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public SearchBuilder(Long userId) {
            this.userId = userId;
        }

        public SearchBuilder withFromDate(LocalDate fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public SearchBuilder withToDate(LocalDate toDate) {
            this.toDate = toDate;
            return this;
        }

        public SearchBuilder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public SearchHistory build() {
            return new SearchHistory(this);
        }
    }
}
