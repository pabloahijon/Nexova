package es.uclm.rentalplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.uclm.rentalplatform.domain.User;
import es.uclm.rentalplatform.repository.UserRepository;

@Service
public class UserService {

    private static final String EMAIL_PATTERN = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User register(User user) {
        if (user == null || isBlank(user.getName()) || isBlank(user.getEmail())) {
            throw new IllegalArgumentException("El nombre y el correo electrónico son obligatorios.");
        }

        String email = user.getEmail().trim().toLowerCase();
        if (!email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con ese correo electrónico.");
        }

        user.setName(user.getName().trim());
        user.setEmail(email);
        return userRepository.save(user);
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
