package com.sda.alinhorsia.petclinic.service;

public interface VetService {

    void createVet(
            String firstName,
            String lastName,
            String address,
            String speciality
    );
}
