package com.qima.test.zoo.bean;

public enum AnimalCategory {

    MOUSE("Mouse", 1),
    OX("Ox", 2),
    TIGER("Tiger", 3),
    RABBIT("Rabbit", 4),
    DRAGON("Dragon", 5),
    SNAKE("Snake", 6),
    HORSE("Horse", 7),
    SHEEP("Sheep", 8),
    MONKEY("Monkey", 9),
    COCK("Cock", 10),
    DOG("Dog", 11),
    PIG("Pig", 12);

    private String text;
    private int index;

    AnimalCategory(String text, int index) {
        this.text = text;
        this.index = index;
    }

    public String getText() {
        return this.text;
    }

    public int getIndex() {
        return this.index;
    }

}
