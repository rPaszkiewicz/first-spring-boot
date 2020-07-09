package com.example.demo.controller;

import com.example.demo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FakeDbService;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/laptops")
public class LaptopController {

    private final FakeDbService fakeDbService;

    @Autowired
    public LaptopController(FakeDbService fakeDbService) {
        this.fakeDbService = fakeDbService;
    }

    @PostMapping
    public String setLap(@RequestBody Laptop laptop) {
        return fakeDbService.addLaptop(laptop) > 0 ?
                "added laptop " + laptop : "given id " + laptop.getId() + " already taken";
    }

    @PostMapping("/{make}/{price}")
    public String setLap(@PathVariable String make, @PathVariable double price) {
        fakeDbService.addLaptop(make, price);
        return "Added " + make + price;
    }

    @GetMapping
    public Collection<Laptop> getLaptops() {
        return fakeDbService.getLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable int id) {
        return fakeDbService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLaptopById(@PathVariable int id) {
        return fakeDbService.removeLaptopById(id) > 0 ?
                "deleted laptop id " + id : "id " + id + " not found";
    }

    @PutMapping("/{id}")
    public String updateLaptop(@PathVariable int id, @RequestBody Laptop laptop) {
        return fakeDbService.updateLaptop(id, laptop) > 0 ?
                "updated " + laptop : "no laptop under id " + id + " found";

    }

}