package info.coliver.auto_analyzer.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import info.coliver.auto_analyzer.model.Manufacturer;
import info.coliver.auto_analyzer.model.ManufacturerRepository;

@Service
public class ManufacturerService {

    ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public Optional<Manufacturer> getManufacturer(int id) {
        return manufacturerRepository.findById(id);
    }

    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    private ManufacturerRepository manufacturerRepository;
}
