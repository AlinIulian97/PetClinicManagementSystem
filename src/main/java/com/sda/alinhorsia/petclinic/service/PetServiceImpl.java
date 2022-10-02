package com.sda.alinhorsia.petclinic.service;

import com.sda.alinhorsia.petclinic.repository.PetRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetServiceImpl implements PetService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void createPet(String race, Date birthdate, boolean isVaccinated, String ownerName) {
        if (race == null || race.isBlank()) {
            throw new IllegalArgumentException("Race is INVALID");
        }
        if (birthdate == null) {
            throw new IllegalArgumentException("Date is INVALID");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name is INVALID");
        }

        petRepository.createPet(race, birthdate, isVaccinated, ownerName);
    }

    @Override
    public void importPets() throws IOException {
        Path fileParh = Paths.get("C:\\Users\\Alin\\Documents\\GitHub\\PetClinicManagementSystem\\src\\main\\resources\\data\\Pets.txt");
        Files.lines(fileParh)
                .skip(1)
                .map(lines -> lines.split("\\|"))
                .forEach(lineElement -> {
                    if (lineElement.length == 4) {
                        String race = lineElement[0];
                        Date date = Date.valueOf(LocalDate.parse(lineElement[1], FORMATTER));
                        boolean isVaccinated = Boolean.parseBoolean(lineElement[2]);
                        String ownerName = lineElement[3];
                        createPet(race, date, isVaccinated, ownerName);
                    }
                });
    }
}

