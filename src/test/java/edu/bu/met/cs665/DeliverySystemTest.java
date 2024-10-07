/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2024
 * File Name: DeliverySystemTest.java
 * Description: This is a test class for the Shop class.
 * This class is responsible for:
 * - testing adding and removing observers
 * - testing creating a delivery request from Observable
 * - testing ability to alert all observers at once
 */

package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.models.*;
import org.junit.Before;
import org.junit.Test;

import edu.bu.met.cs665.models.car;
import edu.bu.met.cs665.models.scooter;
public class DeliverySystemTest {

    private Shop shop;

    private Driver driver1;
    private Driver driver2;
    private Driver driver3;
    private Driver driver4;
    private Driver driver5;

    private Vehicles scooter;
    private Vehicles car;
    private Vehicles taxi;

    @Before
    public void setUp() throws Exception {
        shop = new Shop();

        scooter = new scooter();
        car = new car();


        driver1 = new Driver(scooter);
        driver2 = new Driver(car);
        driver3 = new Driver(car);
        driver4 = new Driver(scooter);
        driver5 = new Driver(car);
    }

    /**
     * Tests all methods from Observable at once.
     */
    @Test
    public void testAllMethods_Success() {
        // Test delivery request.
        DeliveryRequest expectedDeliveryRequest = new DeliveryRequest("Bicycle", "New Jersey");

        // Register 5 Driver objects to Observable .
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);
        shop.addObserver(driver4);
        shop.addObserver(driver5);

        // Create a new delivery request and notify all drivers.
        shop.createDeliveryRequest("Bicycle", "New Jersey");
        shop.alertObservers();

        // Unregister 3 Driver objects.
        shop.removeObserver(driver1);
        shop.removeObserver(driver2);
        shop.removeObserver(driver5);

        // Create a new delivery request and notify remaining registered drivers.
        shop.createDeliveryRequest("Unicycle", "New York");
        shop.alertObservers();

        // Drivers 1, 2, and 3 became unregistered from the Observable after
        // first delivery request so they were not notified of most recent delivery request.
        assertEquals(expectedDeliveryRequest.toString(), driver1.getDeliveryRequest());
        assertEquals(expectedDeliveryRequest.toString(), driver2.getDeliveryRequest());
        // Drivers 4, 5 remained registered, newest request does not match the expected request.
        assertNotEquals(expectedDeliveryRequest.toString(), driver4.getDeliveryRequest());
    }

}
