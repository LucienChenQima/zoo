package com.qima.test.zoo.dao;

import com.qima.test.zoo.bean.Status;
import com.qima.test.zoo.bean.Animal;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@ConfigurationProperties(prefix = "data")
public class ZooClient {

    private List<Animal> animals;

    public List<Animal> getAll() {
        return this.animals;
    }

    public List<Animal> getAll(Status status) {
        return this.animals.stream().filter(a -> status == a.getStatue()).collect(Collectors.toList());
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
