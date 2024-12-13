package com.koksao.countries.services.impl;

import com.koksao.countries.dto.CountryGetApiResponse;
import com.koksao.countries.entities.Country;
import com.koksao.countries.repositories.CountryRepository;
import com.koksao.countries.services.CountryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private RestTemplate restTemplate;
    private CountryRepository countryRepository;

    @Value("${api.url}")
    private String apiUrl;

    public CountryServiceImpl(CountryRepository countryRepository, RestTemplate restTemplate){
        this.countryRepository = countryRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Country> getCountryByIsoCode(String isoCode) {
        Optional<Country> country = countryRepository.findById(isoCode);
        if(country.isEmpty()) {
            country = fetchCountryByIsoCodeFromApi(isoCode);
            country.ifPresent(value -> countryRepository.save(value));
        }
        return country;
    }

    private Optional<Country> fetchCountryByIsoCodeFromApi(String isoCode){
        String url = apiUrl + "/alpha/" + isoCode;

        CountryGetApiResponse[] response = restTemplate.getForObject(url, CountryGetApiResponse[].class);
        if(response != null && response.length > 0){
            CountryGetApiResponse countryGetApiResponse = response[0];
            Country country = Country.builder()
                    .isoCode(isoCode)
                    .commonName(countryGetApiResponse.getCommonName())
                    .officialName(countryGetApiResponse.getOfficialName())
                    .currencies(countryGetApiResponse.getCurrencyCode())
                    .capital(countryGetApiResponse.getCapital())
                    .subregion(countryGetApiResponse.getSubregion())
                    .population(countryGetApiResponse.getPopulation())
                    .languages(countryGetApiResponse.getLanguageValues())
                    .borders(countryGetApiResponse.getBorders())
                    .timezones(countryGetApiResponse.getTimezones())
                    .region(countryGetApiResponse.getRegion())
                    .build();

            return Optional.of(country);
        }
        else{
           return Optional.empty();
        }
    }
}
