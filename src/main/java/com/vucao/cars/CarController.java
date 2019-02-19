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

    @PostMapping("/cars/upload")
    public List<Car> newCars(@RequestBody List<Car> newCars)
    {
        CarLog message = new CarLog("Data Loaded");
        rt.convertAndSend(CarsApplication.QUEUE_NAME, message.toString());
        log.info("Message sent");

        return carrepos.saveAll(newCars);
    }

    @GetMapping("/cars/id/{id}")
    public Car findOne(@PathVariable Long id)
    {
        return carrepos.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @GetMapping("/cars/year/{year}")
    public List<Car> findCarsByYear(@PathVariable Long year)
    {
        return carrepos.findByYear(year);
    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> findCarsByBrand(@PathVariable String brand)
    {
        CarLog message = new CarLog("Search for {brand}");
        rt.convertAndSend(CarsApplication.QUEUE_NAME, message.toString());
        log.info("Message sent");
        return carrepos.findByBrandIgnoreCase(brand);
    }

    @DeleteMapping("/cars/delete/{id}")
    public Car deleteCar(@PathVariable Long id)
    {
        carrepos.deleteById(id);
        return null;
    }
}
