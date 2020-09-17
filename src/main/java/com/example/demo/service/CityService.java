package com.example.demo.service;

import com.example.demo.model.City;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CityService {
    Iterable<City> findAll();

    Optional<City> findById(Long id);

    void save(City city);

    void delete(Long id);
}
