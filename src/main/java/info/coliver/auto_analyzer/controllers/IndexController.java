package info.coliver.auto_analyzer.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.coliver.auto_analyzer.model.Manufacturer;
import info.coliver.auto_analyzer.services.ManufacturerService;

@RestController
public class IndexController {

    IndexController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturer")
    public @ResponseBody Manufacturer getManufacturer(@RequestParam(value = "id") Integer id) {
        if (id == null) {
            return null;
        }

        Optional<Manufacturer> mOptional = manufacturerService.getManufacturer(id);

        if (mOptional.isPresent()) {
            return mOptional.get();
        } else {
            return null;
        }
    }
    
    @GetMapping("/manufacturers")
    public @ResponseBody Iterable<Manufacturer> getManufacturers() {
        return manufacturerService.getManufacturers();
    }

    private ManufacturerService manufacturerService;
}
