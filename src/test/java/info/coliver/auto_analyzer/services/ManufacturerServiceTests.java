package info.coliver.auto_analyzer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import info.coliver.auto_analyzer.model.Manufacturer;
import info.coliver.auto_analyzer.model.ManufacturerRepository;

public class ManufacturerServiceTests {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.manufacturerService = new ManufacturerService(manufacturerRepository);
    }

    @Test
    public void getManufacturer() {
        // Prepare.
        when(manufacturerRepository.findById(anyInt())).thenReturn(Optional.of(manufacturer));
        
        // Execute.
        Optional<Manufacturer> result = manufacturerService.getManufacturer(0);

        // Verify.
        assertEquals(manufacturer, result.get());
        verify(manufacturerRepository, times(1)).findById(0);
    }

    @Test
    public void getManufacturers() {
        // Prepare.
        when(manufacturerRepository.findAll()).thenReturn(manufacturers);

        // Execute.
        Iterable<Manufacturer> result = manufacturerService.getManufacturers();

        // Verify.
        assertEquals(manufacturers, result);
        verify(manufacturerRepository, times(1)).findAll();
    }

    ManufacturerService manufacturerService;
    @Mock
    Iterable<Manufacturer> manufacturers;
    @Mock
    Manufacturer manufacturer;
    @Mock
    ManufacturerRepository manufacturerRepository;
}
