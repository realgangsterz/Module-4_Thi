package com.example.demo.service;

import com.example.demo.model.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CountryService {
    Iterable<Country> findAll();

    Optional<Country> findById(Long id);

    void save(Country country);

    void delete(Long id);
}
