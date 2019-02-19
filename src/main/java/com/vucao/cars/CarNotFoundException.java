package com.vucao.cars;

public class CarNotFoundException extends RuntimeException
{
    public CarNotFoundException(Long id)
    {
        super("Could not find car {id}");
    }
}

