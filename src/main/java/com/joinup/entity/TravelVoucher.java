package com.joinup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TravelVoucher {
    private long travelVoucherId;
    private String typeOfTransport;
    private boolean food;
    private int numberOfDays;
    private int price;
    private String typeOfTour;

    public TravelVoucher() {
    }

    @Override
    public String toString() {
        return "TravelVoucher: " +
                "TravelVoucherId - " + travelVoucherId +
                "| TypeOfTour - " + typeOfTour +
                "| TypeOfTransport - " + typeOfTransport +
                "| Food - " + food +
                "| NumberOfDays - " + numberOfDays +
                "| Price - " + price + " $";
    }
}