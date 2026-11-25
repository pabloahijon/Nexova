package es.uclm.rentalplatform.Web;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.uclm.rentalplatform.domain.Role;
import es.uclm.rentalplatform.domain.User;
import es.uclm.rentalplatform.service.UserService;

/** Añade a todas las vistas el usuario conectado, para pintar la barra de navegación. */
@ControllerAdvice
public class GlobalModelAdvice {

    private final UserService userService;

    public GlobalModelAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addCurrentUser(Model model, Principal principal) {
        User current = principal == null ? null : userService.findByEmail(principal.getName()).orElse(null);
        model.addAttribute("currentUser", current);
        model.addAttribute("isOwner", current != null && current.getRole() == Role.OWNER);
        model.addAttribute("isTenant", current != null && current.getRole() == Role.TENANT);
    }
}
