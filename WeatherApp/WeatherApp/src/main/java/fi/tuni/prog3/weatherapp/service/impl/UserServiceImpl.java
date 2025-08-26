package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.exception.UserNotFoundException;
import fi.tuni.prog3.weatherapp.repository.UserRepository;
import fi.tuni.prog3.weatherapp.service.UserService;
import fi.tuni.prog3.weatherapp.util.Converter;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto logIn(final String username, final String password) {
        var user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password"));

        return Converter.toModel(user, UserDto.class);
    }

    @Override
    public void updateUserInfo(final Long id, final UserDto userDto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        updateFieldIfNotBlank(userDto.getUsername(), user::setUsername);
        updateFieldIfNotBlank(userDto.getPassword(), user::setPassword);
        updateFieldIfNotBlank(userDto.getAddress(), user::setAddress);
        updateFieldIfNotBlank(userDto.getAge(), user::setAge);
        updateFieldIfNotBlank(userDto.getCity(), user::setCity);
        updateFieldIfNotBlank(userDto.getCountry(), user::setCountry);
        updateFieldIfNotBlank(userDto.getFullName(), user::setFullName);
        userRepository.save(user);
    }

    private void updateFieldIfNotBlank(final String value, final Consumer<String> setter) {
        if (value != null && !value.isBlank()) {
            setter.accept(value);
        }
    }

}
