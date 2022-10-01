package com.sda.alinhorsia.petclinic;

import com.sda.alinhorsia.petclinic.controller.VetController;
import com.sda.alinhorsia.petclinic.repository.VetRepositoryImpl;
import com.sda.alinhorsia.petclinic.service.VetServiceImpl;
import com.sda.alinhorsia.petclinic.utils.SessionManager;
import com.sda.alinhorsia.petclinic.utils.UserOption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        VetController vetController = new VetController(new VetServiceImpl(new VetRepositoryImpl()));

        UserOption userOption;
        Scanner scanner = new Scanner(System.in);
        do{
            UserOption.displayAllOptions();
            System.out.println("Please select an option: ");
            int numericOption = scanner.nextInt();
            userOption = UserOption.findByNumericOption(numericOption);
            switch (userOption){
                case ADD_VET:
                    vetController.createVet();
                    break;
                case VIEW_ALL_VETS:
                    System.out.println("Not implemented!");
                    break;
                case UNKNOWN:
                    System.err.println("!INVALID OPTION SELECTED!");
                    break;
                case EXIT:
                    System.out.println("Bye!");
                    break;
            }
        }while (userOption != UserOption.EXIT);
        SessionManager.shutDown();
    }
}