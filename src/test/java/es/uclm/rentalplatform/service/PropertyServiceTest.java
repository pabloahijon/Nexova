package es.uclm.rentalplatform.service;


import es.uclm.rentalplatform.domain.Property;
import es.uclm.rentalplatform.repository.PropertyRepository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PropertyServiceTest {

    @Test
    void guardarInmuebleValido() {
        // ARRANGE: preparar los datos
        PropertyRepository repository = mock(PropertyRepository.class);
        PropertyService service = new PropertyService(repository);

        Property inmueble = new Property(
                "Piso en Madrid",
                "Madrid",
                "PISO",
                "Piso luminoso"
        );

        when(repository.save(inmueble)).thenReturn(inmueble);

        // ACT: ejecutar el método
        Property resultado = service.save(inmueble);

        // ASSERT: comprobar el resultado
        assertSame(inmueble, resultado);
        verify(repository).save(inmueble);
    }
    @Test
void rechazarTituloNulo() {
    // ARRANGE
    PropertyRepository repository = mock(PropertyRepository.class);
    PropertyService service = new PropertyService(repository);

    Property inmueble = new Property(
            null,
            "Madrid",
            "PISO",
            "Piso luminoso"
    );

    // ACT + ASSERT
    assertThrows(
            IllegalArgumentException.class,
            () -> service.save(inmueble)
    );

    verify(repository, never()).save(any(Property.class));
}
}