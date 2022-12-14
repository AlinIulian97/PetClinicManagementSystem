package com.sda.alinhorsia.petclinic.service;

import com.sda.alinhorsia.petclinic.model.Pet;
import com.sda.alinhorsia.petclinic.model.Vet;
import com.sda.alinhorsia.petclinic.repository.ConsultRepository;
import com.sda.alinhorsia.petclinic.repository.PetRepository;
import com.sda.alinhorsia.petclinic.repository.VetRepository;

import java.sql.Date;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {
    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final ConsultRepository consultRepository;

    public ConsultServiceImpl(VetRepository vetRepository, PetRepository petRepository, ConsultRepository consultRepository) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.consultRepository = consultRepository;
    }

    @Override
    public void createConsult(int vetId, int petId, Date date, String description) {
        Optional<Vet> vetOptional = vetRepository.findById(vetId);
        if (vetOptional.isPresent()) {
            Optional<Pet> petOptional = petRepository.findById(petId);
            if (petOptional.isPresent()) {
                consultRepository.createConsult(vetOptional.get(), petOptional.get(), date, description);

            } else {
                throw new IllegalArgumentException("Invalid Pet id");
            }

        } else {
            throw new IllegalArgumentException("Invalid Vet Id");
        }

    }
}
