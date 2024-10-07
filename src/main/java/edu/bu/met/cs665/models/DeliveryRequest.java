/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2024
 * File Name: DeliveryRequest.java
 * Description: This class represents a delivery request containing item and destination information.
 */
package edu.bu.met.cs665.models;

import java.util.Objects;

/**
 * Represents a Delivery Request with a product and location.
 */
public class DeliveryRequest {

    private String item;
    private String destination;

    /**
     * Constructor for DeliveryRequest.
     *
     * @param item the product to be delivered
     * @param destination the location of the delivery
     */
    public DeliveryRequest(String item, String destination) {
        super();
        this.item = item;
        this.destination = destination;
    }

    /**
     * Gets the item of the delivery request.
     *
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * Sets the item of the delivery request.
     *
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Gets the destination of the delivery request.
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the delivery request.
     *
     * @param destination the location to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, item);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeliveryRequest other = (DeliveryRequest) obj;
        return Objects.equals(destination, other.destination) && Objects.equals(item, other.item);
    }

    @Override
    public String toString() {
        return "DeliveryRequest [item=" + item + ", destination=" + destination + "]";
    }

}
