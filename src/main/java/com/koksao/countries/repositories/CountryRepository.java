package com.koksao.countries.repositories;

import com.koksao.countries.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,String> {
}
