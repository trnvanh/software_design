package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;

public interface UserService {
    UserDto logIn(String username, String password);

    void updateUserInfo(Long id, UserDto userDto);
}
