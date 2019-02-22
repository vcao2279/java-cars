package com.vucao.cars;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car
{
    private @Id
    @GeneratedValue
    Long id;
    private String brand;
    private Long year;
    private String model;

    public Car()
    {
        //default constructor
    }

    public Car(String brand, Long year, String model)
    {
        this.brand = brand;
        this.year = year;
        this.model = model;
    }
}
