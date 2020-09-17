package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.CityService;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public ModelAndView showList(){
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @PostMapping("/create")
    public ModelAndView saveCity(@Validated @ModelAttribute City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "A new city was created !");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showCityDetail(@PathVariable Long id){
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("city-detail");
        modelAndView.addObject("city",city);
        return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCity(@Validated @ModelAttribute City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city",city);
        modelAndView.addObject("message","this city is updated !");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute City city){
        cityService.delete(city.getId());
        return "redirect:/";
    }



}
