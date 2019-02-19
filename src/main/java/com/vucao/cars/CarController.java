package com.vucao.cars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CarController
{
    private final CarRepository carrepos;
    private final RabbitTemplate rt;

    public CarController(CarRepository carrepos, RabbitTemplate rt)
    {
        this.carrepos = carrepos;
        this.rt = rt;
    }

    @GetMapping("/cars")
    public List<Car> all()
    {
        return carrepos.findAll();
    }


}
