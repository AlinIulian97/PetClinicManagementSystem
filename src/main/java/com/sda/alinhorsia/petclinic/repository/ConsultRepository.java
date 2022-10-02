package com.sda.alinhorsia.petclinic.repository;

import com.sda.alinhorsia.petclinic.model.Consult;
import com.sda.alinhorsia.petclinic.model.Pet;
import com.sda.alinhorsia.petclinic.model.Vet;

import java.sql.Date;

public interface ConsultRepository extends BaseRepository<Consult> {
    void createConsult(Vet vet, Pet pet , Date date , String description);
}
