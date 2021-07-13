package com.covid.vaccination.service;

import com.covid.vaccination.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

}
