package com.edubridge.App2;

import java.util.List;
import java.util.Scanner;

import com.edubride.App2.model.Smartwatch;
import com.edubride.App2.service.SmartwatchService;



public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        SmartwatchService service = new SmartwatchService();
        String brand, colour, screenSize, weight;
        int price;
        brand = colour = screenSize = weight = null;
        price = 0;

        do {
            System.out.println("Welcome to Smartwatch Application");
            System.out.println("==================================");
            System.out.println("1. Add Smartwatch");
            System.out.println("2. View All Smartwatches");
            System.out.println("3. Search Smartwatch");
            System.out.println("4. Update Smartwatch");
            System.out.println("5. Delete Smartwatch");
            System.out.println("6. Delete All Smartwatches");
            System.out.println("0. Exit");
            System.out.println("Please choose an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New Smartwatch");
                    System.out.println("------------------");
                    System.out.println("Enter Brand: ");
                    brand = in.next();
                    System.out.println("Enter Price: ");
                    price = in.nextInt();
                    System.out.println("Enter Colour: ");
                    colour = in.next();
                    System.out.println("Enter Screen Size: ");
                    screenSize = in.next();
                    System.out.println("Enter Weight: ");
                    weight = in.next();

                    Smartwatch smartwatch = new Smartwatch();
                    smartwatch.setBrand(brand);
                    smartwatch.setPrice(price);
                    smartwatch.setColour(colour);
                    smartwatch.setScreenSize(screenSize);
                    smartwatch.setWeight(weight);

                    service.addSmartwatch(smartwatch);
                    break;

                case 2:
                    System.out.println("View All Smartwatches");
                    System.out.println("---------------------");
                    List<Smartwatch> smartwatches = service.getAllSmartwatches();
                    if (smartwatches.size() != 0) {
                        for (Smartwatch s : smartwatches) {
                            System.out.println(s.getId() + "\t" + s.getBrand() + "\t" + s.getPrice() + "\t" + s.getColour() + "\t" + s.getScreenSize() + "\t" + s.getWeight());
                        }
                    } else {
                        System.out.println("No smartwatches found.");
                    }
                    break;

                case 3:
                    System.out.println("Search Smartwatch");
                    System.out.println("-----------------");
                    System.out.println("Please enter smartwatch id: ");
                    int id = in.nextInt();
                    Smartwatch s = service.getSmartwatchById(id);
                    if (s != null) {
                        System.out.println("Brand: " + s.getBrand());
                        System.out.println("Price: " + s.getPrice());
                        System.out.println("Colour: " + s.getColour());
                        System.out.println("Screen Size: " + s.getScreenSize());
                        System.out.println("Weight: " + s.getWeight());
                    } else {
                        System.out.println("No smartwatch found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update Smartwatch Details");
                    System.out.println("-------------------------");
                    System.out.println("Enter Smartwatch Id: ");
                    int smartwatchId = in.nextInt();
                    System.out.println("Enter Brand: ");
                    brand = in.next();
                    System.out.println("Enter Price: ");
                    price = in.nextInt();
                    System.out.println("Enter Colour: ");
                    colour = in.next();
                    System.out.println("Enter Screen Size: ");
                    screenSize = in.next();
                    System.out.println("Enter Weight: ");
                    weight = in.next();

                    Smartwatch updatedSmartwatch = new Smartwatch();
                    updatedSmartwatch.setId(smartwatchId);
                    updatedSmartwatch.setBrand(brand);
                    updatedSmartwatch.setPrice(price);
                    updatedSmartwatch.setColour(colour);
                    updatedSmartwatch.setScreenSize(screenSize);
                    updatedSmartwatch.setWeight(weight);
                    service.updateSmartwatch(updatedSmartwatch);
                    break;

                case 5:
                    System.out.println("Delete Smartwatch");
                    System.out.println("-----------------");
                    System.out.println("Please enter smartwatch id: ");
                    int sid = in.nextInt();
                    service.deleteSmartwatch(sid);
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all smartwatches? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllSmartwatches();
                    }
                    break;

                case 0:
                    System.out.println("Bye!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a correct option.");
                    break;
            }

        } while (option != 0);
    }
}
