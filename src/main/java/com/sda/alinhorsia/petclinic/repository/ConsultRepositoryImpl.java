package com.sda.alinhorsia.petclinic.repository;

import com.sda.alinhorsia.petclinic.model.Consult;
import com.sda.alinhorsia.petclinic.model.Pet;
import com.sda.alinhorsia.petclinic.model.Vet;

import java.sql.Date;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult> implements ConsultRepository {

    public ConsultRepositoryImpl() {
        super(Consult.class);
    }

    @Override
    public void createConsult(Vet vet, Pet pet, Date date, String description) {
        Consult consult = new Consult();
        consult.setPet(pet);
        consult.setVet(vet);
        consult.setDate(date);
        consult.setDescription(description);
        create(consult);
    }
}
