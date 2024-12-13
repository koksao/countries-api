package com.koksao.countries.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class CountryGetApiResponse {

    private Map<String,Object> name;

    private Map<String, Object> currencies;

    private List<String> capital;

    private String region;

    private String subregion;

    private Map<String,String> languages;

    private Long population;

    private List<String> borders;

    private List<String> timezones;

    public List<String> getCurrencyCode() {
        List<String> list = new ArrayList<>();
        if (currencies != null && !currencies.isEmpty()) {
            list.addAll(currencies.keySet());
        }
        return list;
    }

    public List<String> getLanguageValues() {
        if (languages == null || languages.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(languages.values());
    }

    public String getCommonName(){
        return (String) name.get("common");
    }

    public String getOfficialName(){
        return (String) name.get("official");
    }

}
