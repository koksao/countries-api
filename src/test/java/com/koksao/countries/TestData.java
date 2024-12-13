package com.koksao.countries;

import com.koksao.countries.entities.Country;

import java.util.*;

public class TestData {

    public static Country createCountry() {
        return Country.builder()
                .isoCode("POL")
                .commonName("Poland")
                .officialName("Republic of Poland")
                .currencies(List.of("PLN"))
                .capital(List.of("Warsaw"))
                .region("Europe")
                .subregion("Central Europe")
                .languages(List.of("Polish"))
                .population(37950802L)
                .borders(List.of("BLR", "CZE", "DEU", "LTU", "RUS", "SVK", "UKR"))
                .timezones(List.of("UTC+01:00"))
                .build();
    }

}
