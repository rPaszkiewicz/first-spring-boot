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
import java.util.stream.Stream;

@Service
public class FakeDbService {

    private final dataBaseDao fakeDb;

    @Autowired
    public FakeDbService(@Qualifier("fakeDao") dataBaseDao fakeDb) {
        this.fakeDb = fakeDb;
    }

    private int createId() {
        return new Random().nextInt(100);
    }

    public int addLaptop(Laptop laptop) {
        if (fakeDb.getLaptopById(laptop.getId()) == null) {
            laptop.setId(createId());
            fakeDb.addLaptop(laptop);
            return 1;
        }
        return 0;
    }

    public void addLaptop(String make, double price) {
        Laptop laptop = new Laptop();
        laptop.setMake(make);
        laptop.setPrice(price);
        laptop.setId(createId());
        fakeDb.addLaptop(laptop);
    }

    public Collection<Laptop> getLaptops() {
        return fakeDb.getLaptops();
    }

    public Laptop getLaptopById(int id) {
        return Optional.ofNullable(fakeDb.getLaptopById(id)).orElse(new Laptop());

    }

    public int removeLaptopById(int id) {
        if (Optional.ofNullable(fakeDb.getLaptopById(id)).isPresent()) {
            fakeDb.removeLaptopById(id);
            return 1;
        }
        return 0;
    }

    public int updateLaptop(int id, Laptop laptop) {
        if (Optional.ofNullable(fakeDb.getLaptopById(id)).isPresent()) {
            Laptop laptop1 = fakeDb.getLaptopById(id);
            laptop1.setMake(laptop.getMake());
            laptop1.setPrice(laptop.getPrice());
            fakeDb.updateLaptop(id, laptop1);
            return 1;
        }
        return 0;
    }
}
