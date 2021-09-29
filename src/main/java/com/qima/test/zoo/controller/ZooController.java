package com.qima.test.zoo.controller;

import com.qima.test.zoo.bean.Animal;
import com.qima.test.zoo.bean.ReportVO;
import com.qima.test.zoo.service.ZooService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zoo")
public class ZooController {

    private ZooService zooService;

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("animals")
    public List<Animal> getAll() {
        return zooService.getAll();
    }

    @GetMapping("report")
    public ReportVO getReport() {
        return zooService.getReport();
    }

    @GetMapping("show")
    public String getShow() {
        return zooService.getShow();
    }

    @PostMapping("/animal")
    public void addAnimal(Animal animal) {
        //TODO
    }
    @DeleteMapping("/animal/{id}")
    public void removeAnimal(@PathVariable String id) {
        //TODO
    }
    @PutMapping("/animal/{id}")
    public void updateAnimal(@PathVariable String id , Animal animal) {
        //TODO
    }
    @GetMapping("/animal")
    public void getAnimal() {
        //TODO
    }
    @GetMapping("/animal/{id}")
    public void getAnimal(@PathVariable String id) {
        //TODO
    }

}
