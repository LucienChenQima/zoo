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

}
