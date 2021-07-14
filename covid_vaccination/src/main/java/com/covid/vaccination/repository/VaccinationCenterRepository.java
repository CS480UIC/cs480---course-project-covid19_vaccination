package com.covid.vaccination.repository;

import com.covid.vaccination.models.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends CrudRepository<Vaccination,Integer> {

}
