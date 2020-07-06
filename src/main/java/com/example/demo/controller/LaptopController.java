package com.example.demo.controller;

import com.example.demo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FakeDbService;

import java.util.Collection;


@RestController
@RequestMapping("/laptops")
public class LaptopController {

    private final FakeDbService fakeDbService;

    @Autowired
    public LaptopController(FakeDbService fakeDbService) {
        this.fakeDbService = fakeDbService;
    }

    @PostMapping
<<<<<<< HEAD
    public void setLap(@RequestBody Laptop laptop) {
=======
    public void setLaptop(@RequestBody Laptop laptop){
>>>>>>> putMapping
        fakeDbService.addLaptop(laptop);
    }

    @PostMapping("/{make}/{price}")
    public void setLap(@PathVariable String make, @PathVariable double price) {
        fakeDbService.addLaptop(make, price);
    }

    @GetMapping
    public Collection<Laptop> getLaptops() {
        return fakeDbService.getLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopByMake(@PathVariable int id){
        return fakeDbService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptopById(@PathVariable int id){
        fakeDbService.removeLaptopById(id);
    }

    @PutMapping("/update/{id}")
    public void updateLaptop(@PathVariable int id, @RequestBody Laptop laptop ){
        fakeDbService.updateLaptop(id,laptop);
    }
    
}
