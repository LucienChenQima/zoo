package com.qima.test.zoo.bean;

import lombok.Data;

@Data
public class Animal {

    protected String id;
    protected String name;
    protected AnimalCategory category;
    protected Double height;
    protected Double weight;
    protected String sourceCountry;
    protected Long birthTime;
    protected Status statue;
}
