package com.koksao.countries.services;

import com.koksao.countries.entities.Country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> getCountryByIsoCode(String isoCode);
}
