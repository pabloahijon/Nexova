package es.uclm.rentalplatform.repository;

import es.uclm.rentalplatform.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PropertyRepository extends JpaRepository<Property, Long> {
}