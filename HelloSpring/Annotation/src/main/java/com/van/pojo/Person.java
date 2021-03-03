package com.van.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
