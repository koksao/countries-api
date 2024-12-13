package com.koksao.countries.repositories;

import com.koksao.countries.TestData;
import com.koksao.countries.entities.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository underTest;

    private Country country;


    @BeforeEach
    public void setUp() {
        country = TestData.createCountry();
    }

    @Test
    public void testSaveCountry() {
        Country savedCountry = underTest.save(country);
        assertNotNull(savedCountry.getIsoCode());
        assertEquals("Poland", savedCountry.getCommonName());
    }

    @Test
    public void testFindCountryByIsoCode() {
        underTest.save(country);
        Optional<Country> foundCountry = underTest.findById("POL");
        assertTrue(foundCountry.isPresent());
        assertEquals("Poland", foundCountry.get().getCommonName());
    }

}
