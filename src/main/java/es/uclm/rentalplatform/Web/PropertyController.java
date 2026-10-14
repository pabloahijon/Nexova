package es.uclm.rentalplatform.Web;

import es.uclm.rentalplatform.domain.Property;
import es.uclm.rentalplatform.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public String listProperties(Model model) {
        model.addAttribute("properties", propertyService.findAll());
        model.addAttribute("property", new Property());
        return "properties";
    }

    @PostMapping
    public String createProperty(@ModelAttribute("property") Property property, Model model) {
        try {
            propertyService.save(property);
        } catch (IllegalArgumentException exception) {
            model.addAttribute("publicationError", exception.getMessage());
            model.addAttribute("properties", propertyService.findAll());
            return "properties";
        }
        return "redirect:/properties";
    }
}
