package com.sda.alinhorsia.petclinic.repository;

import com.sda.alinhorsia.petclinic.model.Vet;

import java.util.List;

public interface VetRepository {
    void createVet(
            String firstName,
            String lastName,
            String address,
            String speciality
    );

   List<Vet> getAllVets();
}
