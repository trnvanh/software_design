package fi.tuni.prog3.weatherapp.dto.userdtos;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String address;
    private String age;
    private String city;
    private String country;
    private String fullName;

    public UserDto() {
    }

    public UserDto(Long id, String username, String password, String address, String age, String city, String country, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.age = age;
        this.city = city;
        this.country = country;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
