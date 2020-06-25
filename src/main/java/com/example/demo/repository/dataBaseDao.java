package com.example.demo.repository;

import com.example.demo.model.Laptop;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public interface dataBaseDao {

    int addLaptop(Laptop laptop);

    Collection<Laptop> getLaptops();

    Laptop getLaptopById(int id);

    void removeLaptopById(int id);
}
