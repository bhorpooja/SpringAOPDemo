package com.codekul.SpringAspectDemo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by pooja on 12/12/17.
 */
public class Student {

    @Id
    String id;
    String name;
    String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
