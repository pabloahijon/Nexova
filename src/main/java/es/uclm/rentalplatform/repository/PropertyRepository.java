package es.uclm.rentalplatform.repository;

import es.uclm.rentalplatform.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}