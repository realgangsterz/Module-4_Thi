package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @NotBlank
    @NotEmpty
    private float area;

    @NotBlank
    @NotEmpty
    private long population;

    @NotBlank
    @NotEmpty
    private float GDP;

    @NotBlank
    @NotEmpty
    private String description;


    public Long getId() {
        return id;
    }
}
