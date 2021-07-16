package com.covid.vaccination.repository;

import com.covid.vaccination.models.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends CrudRepository<Vaccine,Integer> {

}
