package es.uclm.rentalplatform;

import es.uclm.rentalplatform.domain.Property;
import es.uclm.rentalplatform.repository.PropertyRepository;
import es.uclm.rentalplatform.service.PropertyService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:publicationtests;DB_CLOSE_DELAY=-1")
@Transactional
class PropertyPublicationTests {

    @Autowired PropertyService service;
    @Autowired PropertyRepository repository;
    @Autowired EntityManager entityManager;
    @Autowired WebApplicationContext context;
    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void savesAndRetrievesValuesWithDistinctGeneratedIdentifiers() {
        Property first = service.save(new Property("Piso luminoso","Madrid", "PISO", "Piso bien iluminado en Madrid"));
        Property second = service.save(new Property("Casa tranquila", "Toledo", null, "Casa tranquila en medio de Toledo"));
        assertNotNull(first.getId());
        assertNotNull(second.getId());
        assertNotEquals(first.getId(), second.getId());
        repository.flush();
        entityManager.clear();

        Property stored = repository.findById(first.getId()).orElseThrow();
        assertEquals("Piso luminoso", stored.getTitle());
        assertEquals("Madrid", stored.getCity());
        assertEquals("PISO", stored.getType());
        assertNull(repository.findById(second.getId()).orElseThrow().getType());
    }

    @Test
    void rejectsMissingEmptyAndWhitespaceOnlyRequiredFieldsWithoutSaving() {
        long count = repository.count();
        for (String invalid : new String[] {null, "", "   "}) {
            assertThrows(IllegalArgumentException.class,
                    () -> service.save(new Property(invalid, "Madrid", null, null)));
            assertThrows(IllegalArgumentException.class,
                    () -> service.save(new Property("Piso", invalid, null, null)));
        }
        assertEquals(count, repository.count());
    }

    @Test
    void publishesFromFormWithoutTypeAndDisplaysStoredProperty() throws Exception {
        long count = repository.count();
        mvc.perform(post("/properties").param("title", "Anuncio de prueba")
                        .param("city", "Cuenca"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/properties"));
        repository.flush();
        entityManager.clear();
        assertEquals(count + 1, repository.count());
        mvc.perform(get("/properties"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Anuncio de prueba")))
                .andExpect(content().string(containsString("Cuenca")));
    }

    @Test
    void invalidFormShowsErrorAndPreservesInputWithoutSaving() throws Exception {
        long count = repository.count();
        mvc.perform(post("/properties").param("title", "Piso de prueba")
                        .param("city", "   "))
                .andExpect(status().isOk())
                .andExpect(view().name("properties"))
                .andExpect(model().attributeExists("publicationError", "properties"))
                .andExpect(content().string(containsString("El título y la ciudad son obligatorios.")))
                .andExpect(content().string(containsString("Piso de prueba")))
                .andExpect(content().string(containsString(
                        "id=\"publication-error\" class=\"publication-error\" role=\"alert\" tabindex=\"-1\"")))
                .andExpect(result -> {
                    Property form = (Property) result.getModelAndView().getModel().get("property");
                    assertEquals("   ", form.getCity());
                    assertNull(form.getType());
                });
        assertEquals(count, repository.count());
    }
}
