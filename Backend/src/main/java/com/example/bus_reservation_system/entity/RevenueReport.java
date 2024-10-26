package com.example.bus_reservation_system.entity;

import lombok.Data;

@Data
public class RevenueReport {
    private long busId; // Ensure this matches the type of r.bus.id
    private String operator; // Should match the type of b.operator
    private String busNumber; // Should match the type of b.busNumber
    private double totalRevenue; // Should match the type of SUM(b.price)

    // Public constructor
    public RevenueReport(Long busId, String operator, String busNumber, Double totalRevenue) {
        this.busId = busId;
        this.operator = operator;
        this.busNumber = busNumber;
        this.totalRevenue = totalRevenue;
    }

}
