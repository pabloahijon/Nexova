package es.uclm.rentalplatform.Web;

import es.uclm.rentalplatform.domain.Property;
import es.uclm.rentalplatform.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String createProperty(Property property) {
        propertyService.save(property);
        return "redirect:/properties";
    }
}