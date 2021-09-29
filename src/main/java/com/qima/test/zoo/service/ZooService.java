package com.qima.test.zoo.service;

import com.qima.test.zoo.bean.ReportVO;
import com.qima.test.zoo.bean.Animal;
import com.qima.test.zoo.dao.ZooClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    private ZooClient client;

    public ZooService(ZooClient client) {
        this.client = client;
    }

    public List<Animal> getAll() {
        return client.getAll();
    }

    public ReportVO getReport() {
        return client.getReport();
    }

    public String getShow() {
        return client.getShow();
    }
}
