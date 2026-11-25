package es.uclm.rentalplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.uclm.rentalplatform.domain.User;
import es.uclm.rentalplatform.repository.UserRepository;

@Service
public class UserService {

    private static final String EMAIL_PATTERN = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    private static final int MIN_PASSWORD_LENGTH = 8;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return userRepository.findByEmail(email.trim().toLowerCase());
    }

    public User register(User user) {
        if (user == null || isBlank(user.getName()) || isBlank(user.getEmail())) {
            throw new IllegalArgumentException("El nombre y el correo electrónico son obligatorios.");
        }

        String email = user.getEmail().trim().toLowerCase();
        if (!email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
        if (isBlank(user.getPassword()) || user.getPassword().length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException(
                    "La contraseña es obligatoria y debe tener al menos " + MIN_PASSWORD_LENGTH + " caracteres.");
        }
        if (user.getRole() == null) {
            throw new IllegalArgumentException("Debes indicar si te registras como inquilino o como propietario.");
        }
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con ese correo electrónico.");
        }

        user.setName(user.getName().trim());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
