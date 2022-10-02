package com.sda.alinhorsia.petclinic.service;

import com.sda.alinhorsia.petclinic.model.Vet;
import com.sda.alinhorsia.petclinic.repository.VetRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;


    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public void createVet(String firstName, String lastName, String address, String speciality) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First Name is INVALID");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last Name is INVALID");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is INVALID");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new IllegalArgumentException("Speciality is INVALID");
        }
        vetRepository.createVet(firstName, lastName, address, speciality);

    }

    @Override
    public List<Vet> getAllVets() {
        return vetRepository.getAll();
    }

    @Override
    public Optional<Vet> findById(int id) {
        return vetRepository.findById(id);
    }

    @Override
    public void updateVetById(int id, String firstName, String lastName, String address, String speciality) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is INVALID");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First Name is INVALID");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last Name is INVALID");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is INVALID");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new IllegalArgumentException("Speciality is INVALID");
        }
        vetRepository.updateVetById(id, firstName, lastName, address, speciality);
    }

    @Override
    public void deleteVetById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is INVALID");
        }
        vetRepository.deleteById(id);
    }

    @Override
    public void importVets() throws IOException {
        Path filePath = Paths.get("C:\\Users\\Alin\\Documents\\GitHub\\PetClinicManagementSystem\\src\\main\\resources\\data\\Vets.txt");
        Files.lines(filePath)
                .skip(1)
                .map(line -> line.split("\\|"))
                .forEach(lineElements ->{
                    if(lineElements.length == 4){
                        String firstName = lineElements[0];
                        String lastName = lineElements[1];
                        String address = lineElements[2];
                        String speciality= lineElements[3];
                        createVet(firstName, lastName, address ,speciality);
                    }
                });

    }


}
