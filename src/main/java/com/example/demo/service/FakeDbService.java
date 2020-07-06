package com.example.demo.service;

import com.example.demo.model.Laptop;
import com.example.demo.repository.FakeDb;
import com.example.demo.repository.dataBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

@Service
public class FakeDbService {

    private final dataBaseDao fakeDb;

    @Autowired
    public FakeDbService(@Qualifier("fakeDao") dataBaseDao fakeDb) {
        this.fakeDb = fakeDb;
    }

    private int createId(){
        Random random = new Random();
        return random.nextInt(100);
    }
    public void addLaptop(Laptop laptop){
        laptop.setId(createId());
        fakeDb.addLaptop(laptop);
    }

    public void addLaptop(String make, double price) {
        Laptop laptop = new Laptop();
        laptop.setMake(make);
        laptop.setPrice(price);
        laptop.setId(createId());
        fakeDb.addLaptop(laptop);
    }

    public Collection<Laptop> getLaptops(){
        return fakeDb.getLaptops();
    }

    public Laptop getLaptopById(int id){
       return fakeDb.getLaptopById(id);
    }

    public void removeLaptopById(int id) {
        fakeDb.removeLaptopById(id);
    }

    public void updateLaptop(int id, Laptop laptop){
        fakeDb.updateLaptop(id,laptop);
    }
}
