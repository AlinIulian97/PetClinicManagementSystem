package com.sda.alinhorsia.petclinic.service;

import java.sql.Date;

public interface PetService {

    void createPet(
            String race,
            Date birthdate,
            boolean isVaccinated,
            String ownerName
    );

}
