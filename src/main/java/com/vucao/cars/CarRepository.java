package com.vucao.cars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>
{
    List<Car> findByYear(Long year);
    List<Car> findByBrandIgnoreCase(String brand);
}

