package com.covid.vaccination.service;

import com.covid.vaccination.repository.VaccinationCenterRepository;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
    private final VaccinationCenterRepository vaccinationCenterRepository;

    public CenterService(VaccinationCenterRepository vaccinationCenterRepository) {
        this.vaccinationCenterRepository = vaccinationCenterRepository;
    }
}
