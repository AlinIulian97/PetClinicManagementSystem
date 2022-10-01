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
            try {
                UserOption.displayAllOptions();
                System.out.println("Please select an option: ");
                int numericOption = Integer.parseInt(scanner.nextLine().trim());
                userOption = UserOption.findByNumericOption(numericOption);
            }catch(NumberFormatException e){
                userOption = UserOption.UNKNOWN;
            }
            switch (userOption){
                case ADD_VET:
                    vetController.createVet();
                    break;
                case VIEW_ALL_VETS:
                    vetController.showAllVets();
                    break;
                case VIEW_VET_BY_ID:
                    vetController.showVetById();
                    break;
                case UPDATED_VET_BY_ID:
                    vetController.updateVetById();
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