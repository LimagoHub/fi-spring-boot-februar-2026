package de.fi.webapp.service.internal;

import de.fi.webapp.persistence.entity.PersonenRepository;
import de.fi.webapp.service.PersonenServiceException;
import de.fi.webapp.service.mapper.PersonMapper;
import de.fi.webapp.service.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository personRepositoryMock;

    @Mock
    private PersonMapper mapperMock;

    @Mock
    private List<String> blacklistMock;



    @Test
    @DisplayName("speichern mit leerem Parameter erwartet eine PersonenServiceException")
    void speichernParameterNull() throws Exception {
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(null));
        assertEquals("Parameter darf nicht null sein", ex.getMessage());
    }

    @Test
    void speichern__unerwuenschte_person__throws_PersonenServiceException() throws Exception {
        final Person attila = new Person(null,"Attila","Doe");

        // Recordmode
        Mockito.when(blacklistMock.contains(Mockito.any())).thenReturn(true);
        // Replaymode

        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(attila));
        assertEquals("Antipath!", ex.getMessage());
    }
}