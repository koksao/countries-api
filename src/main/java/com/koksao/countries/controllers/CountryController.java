package com.koksao.countries.controllers;

import com.koksao.countries.entities.Country;
import com.koksao.countries.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @GetMapping("{isoCode}")
    public ResponseEntity<Country> getCountry(@PathVariable String isoCode) {
       Optional<Country> country = countryService.getCountryByIsoCode(isoCode);
        if (country.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(country.get());
        }
    }
}
