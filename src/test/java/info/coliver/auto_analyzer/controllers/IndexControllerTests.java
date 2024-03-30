package info.coliver.auto_analyzer.controllers;

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
import info.coliver.auto_analyzer.services.ManufacturerService;

public class IndexControllerTests {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.indexController = new IndexController(manufacturerService);
    }

    @Test
    public void getManufacturer() {
        // Prepare.
        when(manufacturerService.getManufacturer(anyInt())).thenReturn(Optional.of(manufacturer));

        // Execute.
        Manufacturer result = indexController.getManufacturer(0);

        // Verify.
        assertEquals(manufacturer, result);
        verify(manufacturerService, times(1)).getManufacturer(0);
    }

    @Test
    public void getManufacturerBadId() {
        // Prepare.
        when(manufacturerService.getManufacturer(anyInt())).thenReturn(Optional.empty());

        // Execute.
        Manufacturer result = indexController.getManufacturer(0);

        // Verify.
        assertEquals(null, result);
        verify(manufacturerService, times(1)).getManufacturer(0);
    }

    @Test
    public void getManufacturers() {
        // Prepare.
        when(manufacturerService.getManufacturers()).thenReturn(manufacturers);

        // Execute.
        Iterable<Manufacturer> result = indexController.getManufacturers();

        // Verify.
        assertEquals(manufacturers, result);
        verify(manufacturerService, times(1)).getManufacturers();
    }

    IndexController indexController;
    @Mock
    Iterable<Manufacturer> manufacturers;
    @Mock
    Manufacturer manufacturer;
    @Mock
    ManufacturerService manufacturerService;
}
