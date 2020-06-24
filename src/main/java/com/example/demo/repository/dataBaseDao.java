package com.example.demo.repository;

import com.example.demo.model.Laptop;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface dataBaseDao {

    void addLaptop(Laptop laptop);

    Collection<Laptop> getLaptops();

    Laptop getLaptopByMake(String Make);
}
