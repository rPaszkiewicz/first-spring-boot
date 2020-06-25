package com.example.demo.repository;

import com.example.demo.model.Laptop;
import java.util.Collection;
import java.util.Random;

public interface dataBaseDao {

    void addLaptop(int id, Laptop laptop);

    default void addLaptop(Laptop laptop){
        Random random = new Random();
        int rand = random.nextInt(100);
        addLaptop(rand,laptop);
    }

    Collection<Laptop> getLaptops();

    Laptop getLaptopById(int id);

    void removeLaptopById(int id);
}
