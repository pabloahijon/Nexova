package es.uclm.rentalplatform.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uclm.rentalplatform.domain.Role;
import es.uclm.rentalplatform.domain.User;
import es.uclm.rentalplatform.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "user-register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.register(user);
        } catch (IllegalArgumentException exception) {
            model.addAttribute("registrationError", exception.getMessage());
            model.addAttribute("roles", Role.values());
            return "user-register";
        }
        return "redirect:/login?registered";
    }
}
