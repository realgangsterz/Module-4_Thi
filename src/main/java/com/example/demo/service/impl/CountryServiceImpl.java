package com.example.demo.service.impl;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(findById(id).get());
    }
}
