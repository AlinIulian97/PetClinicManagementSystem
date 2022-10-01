package com.sda.alinhorsia.petclinic;

import com.sda.alinhorsia.petclinic.controller.VetController;
import com.sda.alinhorsia.petclinic.repository.VetRepositoryImpl;
import com.sda.alinhorsia.petclinic.service.VetServiceImpl;
import com.sda.alinhorsia.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        VetController vetController = new VetController(new VetServiceImpl(new VetRepositoryImpl()));
        vetController.createVet();
    }
}