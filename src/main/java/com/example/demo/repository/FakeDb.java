package com.example.demo.repository;

import com.example.demo.model.Laptop;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("fakeDao")
public class FakeDb implements dataBaseDao{

    private static Map<Integer, Laptop> DB = new HashMap<>();

    @Override
    public void addLaptop(int id,Laptop laptop){
        DB.put(id, laptop);
    }

    @Override
    public Collection<Laptop> getLaptops(){
        return DB.values();
    }

    @Override
    public Laptop getLaptopById(int id){
       return DB.get(id);
    }

    @Override
    public void removeLaptopById(int id) {
        DB.remove(id);
    }
}
