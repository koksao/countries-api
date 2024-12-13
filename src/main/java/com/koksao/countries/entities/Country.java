package com.koksao.countries.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {


    @Id
    private String isoCode;

    private String commonName;

    private String officialName;

    private List<String> currencies;

    private List<String> capital;

    private String region;

    private String subregion;

    private List<String> languages;

    private Long population;

    private List<String> borders;

    private List<String> timezones;

}
