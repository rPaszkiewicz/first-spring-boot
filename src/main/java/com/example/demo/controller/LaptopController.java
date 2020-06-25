package com.example.demo.controller;

import com.example.demo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FakeDbService;

import java.util.Collection;


@RestController
@RequestMapping("/laptop")
public class LaptopController {

    private final FakeDbService fakeDbService;

    @Autowired
    public LaptopController(FakeDbService fakeDbService) {
        this.fakeDbService = fakeDbService;
    }

    @PostMapping("/add/{make}/{price}")
    public void setLap(@PathVariable String make, @PathVariable double price) {
        fakeDbService.addLaptops(make,price);
    }

    @GetMapping(path = "/getLaptops",produces = "application/json")
    public Collection<Laptop> getLaptops() {
        return fakeDbService.getLaptops();
    }

    @GetMapping("/getLaptops/{id}")
    public Laptop getLaptopById(@PathVariable int id){
        return fakeDbService.getLaptopByMake(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLaptopById(@PathVariable int id){
        fakeDbService.removeLaptopById(id);
    }
    
}
