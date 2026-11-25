package es.uclm.rentalplatform.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.uclm.rentalplatform.domain.User;
import es.uclm.rentalplatform.repository.UserRepository;

/** Carga el usuario por correo electrónico para el login de Spring Security. */
@Service
public class NexovaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public NexovaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email == null ? "" : email.trim().toLowerCase())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        if (user.getPassword() == null || user.getRole() == null) {
            throw new UsernameNotFoundException("Usuario sin credenciales");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
