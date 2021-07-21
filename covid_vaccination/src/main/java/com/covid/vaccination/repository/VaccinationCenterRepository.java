package com.covid.vaccination.repository;

import com.covid.vaccination.models.VaccinationCentre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository {

    String query1="select * from vaccination_center where state=?1";
    @Query(nativeQuery = true,value = query1)
    List<VaccinationCentre> getState(String state);


    String query2="select * from vaccination_center group by state,vaccinated  order by state,sum(vaccinated) limit 1 desc";
    @Query(nativeQuery = true,value=query2)
    List<VaccinationCentre> getState2();
    
}
