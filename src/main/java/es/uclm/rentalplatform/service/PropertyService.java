package es.uclm.rentalplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.uclm.rentalplatform.domain.Property;
import es.uclm.rentalplatform.repository.PropertyRepository;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public Property save(Property property) {
        if (property.getTitle() == null || property.getTitle().isBlank()
                || property.getCity() == null || property.getCity().isBlank()) {
            throw new IllegalArgumentException("El título y la ciudad son obligatorios.");
        }
        return propertyRepository.save(property);
    }
}
