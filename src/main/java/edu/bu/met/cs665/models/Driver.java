/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2024
 * File Name: Driver.java
 * Description: This class represents a driver in the delivery system.
 * It implements the Observer interface to receive delivery requests.
 */
package edu.bu.met.cs665.models;

import java.util.Objects;

/**
 * Represents a Driver who observes delivery requests.
 */
public class Driver implements Observer {

    private Vehicles vehicles;
    private DeliveryRequest deliveryRequest;

    public Driver(Vehicles vehicles) {
        this.setVehicles(vehicles);
    }

    /**
     * Updates driver with delivery order.
     * @param deliveryRequest sets delivery order to driver.
     */
    @Override
    public void update(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    /**
     * Gets the delivery request as a string.
     *
     * @return the delivery request
     */
    public String getDeliveryRequest() {
        return deliveryRequest.toString();
    }

    /**
     * Gets the vehicle of the driver.
     *
     * @return the vehicle
     */
    public Vehicles getVehicles() {
        return vehicles;
    }

    /**
     * Sets the vehicle of the driver.
     *
     * @param vehicles the vehicle to set
     */
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicles);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Driver other = (Driver) obj;
        return Objects.equals(vehicles, other.vehicles);
    }

    @Override
    public String toString() {
        return "Driver [vehicles=" + vehicles + "]";
    }

}
