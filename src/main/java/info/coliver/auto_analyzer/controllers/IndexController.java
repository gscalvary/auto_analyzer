package info.coliver.auto_analyzer.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.coliver.auto_analyzer.model.Manufacturer;
import info.coliver.auto_analyzer.model.ManufacturerRepository;

@RestController
public class IndexController {

    IndexController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping("/manufacturer")
    public @ResponseBody Manufacturer getManufacturer(@RequestParam(value = "id") Integer id) {
        Optional<Manufacturer> mOptional = manufacturerRepository.findById(id);

        if (mOptional.isPresent()) {
            return mOptional.get();
        } else {
            return null;
        }
    }
    
    @GetMapping("/manufacturers")
    public @ResponseBody Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    private ManufacturerRepository manufacturerRepository;
}
