package fi.tuni.prog3.weatherapp.datainitializer;

import fi.tuni.prog3.weatherapp.entity.UserEntity;
import fi.tuni.prog3.weatherapp.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class UserDataInitializer {

    private final UserRepository userRepository;

    public UserDataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initUserData() {
        var users = Arrays.asList(
                new UserEntity("user1", "123456", "Street 1", "25", "Stockholm", "Sweden", "John Doe"),
                new UserEntity("user2", "database", "Street 2", "30", "Gothenburg", "Sweden", "Jane Smith"),
                new UserEntity("user3", "design", "Street 3", "28", "Malmö", "Sweden", "Alice Brown")
        );

        users.forEach(user -> {
            if (userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isEmpty()) {
                userRepository.save(user);
            }
        });
    }
}
