/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2024
 * File Name: Shop.java
 * Description: This class represents a shop that acts as the Observable in the delivery system.
 * It manages delivery requests and notifies registered drivers.
 */
package edu.bu.met.cs665.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.bu.met.cs665.models.DeliveryRequest;
import edu.bu.met.cs665.models.Observer;

/**
 * Represents a Shop that manages delivery requests and notifies drivers.
 */
public class Shop implements Observables{

    private List<Observer> drivers;
    private DeliveryRequest deliveryRequest;

    /**
     * Constructor for Shop. Initializes an empty list of drivers.
     */
    public Shop() {
        super();
        this.drivers = new ArrayList<Observer>();
    }

    /**
     * Gets the current delivery request.
     *
     * @return the delivery request
     */
    public DeliveryRequest getDeliveryRequest() {
        return deliveryRequest;
    }

    /**
     * Registers an observer by adding driver to list of observers.
     * @param driver for shop will observe new delivery orders.
     */
    @Override
    public void addObserver(Observer driver) {
        drivers.add(driver);
    }

    /**
     * Unregisters an observer by removing driver from list of observers.
     * @param driver for shop will no longer observe new delivery orders.
     */
    @Override
    public void removeObserver(Observer driver) {
        drivers.remove(driver);
    }

    /**
     * Notifies all drivers by iterating through the list of observers and updating each with a new delivery order.
     */
    @Override
    public void alertObservers() {
        for (Iterator<Observer> observer = drivers.iterator(); observer.hasNext();) {
            Observer driver = observer.next();
            driver.update(this.deliveryRequest);
        }
    }

    /**
     * Creates a new delivery order that is assigned to the shop.
     * @param item for delivery order.
     * @param destination for delivery order.
     */
    public void createDeliveryRequest(String item, String destination) {
        this.deliveryRequest = new DeliveryRequest(item, destination);
    }

}
