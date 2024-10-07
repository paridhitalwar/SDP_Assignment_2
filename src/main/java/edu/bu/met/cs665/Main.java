/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2024
 * File Name: Main.java
 * Description: This is the main entry point of the delivery system application.
 * It initializes the shop, creates vehicles and drivers, and simulates the
 * process of making delivery requests and notifying drivers.
 */

package edu.bu.met.cs665;

//import edu.bu.met.cs665.models.MotorScooter;
import edu.bu.met.cs665.models.car;
import edu.bu.met.cs665.models.scooter;
import edu.bu.met.cs665.models.Vehicles;
import edu.bu.met.cs665.models.Driver;
import edu.bu.met.cs665.models.Shop;

/**
 * This is the Main class.
 */
public class Main {

    /**
     * Main method to run the example.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This is a test message from the Main class (Main.java file)");
        String item = "Electronics";
        String destination = "Cambridge";

        Vehicles car = new car();
        Vehicles scooter = new scooter();

        Driver driverMike = new Driver(car);
        Driver driverSteve = new Driver(scooter);
        Shop electronicStore = new Shop();

        // Testing main methods created for this project.
        electronicStore.createDeliveryRequest(item, destination);
        electronicStore.addObserver(driverMike);
        electronicStore.addObserver(driverSteve);

        electronicStore.alertObservers();


        System.out.println("Driver Mike: ");
        System.out.println(driverMike);
        System.out.println(driverMike.getDeliveryRequest());

        System.out.println("Driver Steve: ");
        System.out.println(driverSteve);
        System.out.println(driverSteve.getDeliveryRequest());
    }

}