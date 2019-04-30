package com.joinup.util;

public class QueryParam {

    private int typeOfTransport;
    private boolean food;
    private int numberOfDays;

    public int getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(int typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
