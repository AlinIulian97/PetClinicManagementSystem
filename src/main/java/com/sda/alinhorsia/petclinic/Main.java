package com.sda.alinhorsia.petclinic;

import com.sda.alinhorsia.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        SessionManager.shutDown();
    }
}