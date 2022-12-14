package com.sda.alinhorsia.petclinic.repository;

import com.sda.alinhorsia.petclinic.model.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository extends BaseRepository<Vet> {
    void createVet(
            String firstName,
            String lastName,
            String address,
            String speciality
    );
        void updateVetById(int id,
                       String firstName,
                       String lastName,
                       String address,
                       String speciality
    );

}








//    List<Vet> getAllVets();
//
//    Optional<Vet> findById(int id);
//
//    void updateVetById(int id,
//                       String firstName,
//                       String lastName,
//                       String address,
//                       String speciality
//    );
//
//    void deleteVetById(int id);
//}
