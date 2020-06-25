package com.example.demo.service;

import com.example.demo.model.Laptop;
import com.example.demo.repository.dataBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FakeDbService {

    private final dataBaseDao fakeDb;

    @Autowired
    public FakeDbService(@Qualifier("fakeDao") dataBaseDao fakeDb) {
        this.fakeDb = fakeDb;
    }

    public void addLaptops(String make, double price) {
        fakeDb.addLaptop(new Laptop(make,price));
    }

    public Collection<Laptop> getLaptops(){
        return fakeDb.getLaptops();
    }

    public Laptop getLaptopByMake(int id){
       return fakeDb.getLaptopById(id);
    }

    public void removeLaptopById(int id){
        fakeDb.removeLaptopById(id);
    }
}
