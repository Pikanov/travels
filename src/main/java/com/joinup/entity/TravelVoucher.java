package com.joinup.entity;

import java.util.Objects;

public class TravelVoucher {
    private long travelVoucherId;
    private String typeOfTransport;
    private boolean food;
    private int numberOfDays;
    private int price;
    private String typeOfTour;

    private TravelVoucher(Builder builder) {
        this.travelVoucherId = builder.travelVoucherId;
        this.typeOfTransport = builder.typeOfTransport;
        this.food = builder.food;
        this.numberOfDays = builder.numberOfDays;
        this.price = builder.price;
        this.typeOfTour = builder.typeOfTour;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getTravelVoucherId() {
        return travelVoucherId;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public boolean isFood() {
        return food;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getPrice() {
        return price;
    }

    public String getTypeOfTour() {
        return typeOfTour;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TravelVoucher that = (TravelVoucher) o;

        return travelVoucherId == that.travelVoucherId &&
                food == that.food &&
                numberOfDays == that.numberOfDays &&
                price == that.price &&
                Objects.equals(typeOfTransport, that.typeOfTransport) &&
                Objects.equals(typeOfTour, that.typeOfTour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelVoucherId, typeOfTransport, food, numberOfDays, price, typeOfTour);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
              sb.append("ID - ")
                .append(travelVoucherId)
                .append(" | Type - ")
                .append(typeOfTour)
                .append(" | Transport - ")
                .append(typeOfTransport)
                .append(" | Food - ")
                .append(food)
                .append(" | Days - ")
                .append(numberOfDays)
                .append(" | Price - ")
                .append(price)
                .append("$");
              return sb.toString();
    }

    public static class Builder {
        private long travelVoucherId;
        private String typeOfTransport;
        private boolean food;
        private int numberOfDays;
        private int price;
        private String typeOfTour;

        private Builder() {
        }

//        public Builder(long travelVoucherId, String typeOfTransport,
//                       boolean food, int numberOfDays, int price,
//                       String typeOfTour) {
//            this.travelVoucherId = travelVoucherId;
//            this.typeOfTransport = typeOfTransport;
//            this.food = food;
//            this.numberOfDays = numberOfDays;
//            this.price = price;
//            this.typeOfTour = typeOfTour;
//        }

        public TravelVoucher build() {
            return new TravelVoucher(this);
        }

        public Builder withTravelVoucherId(long travelVoucherId) {
            this.travelVoucherId = travelVoucherId;
            return this;
        }

        public Builder withTypeOfTransport(String typeOfTransport) {
            this.typeOfTransport = typeOfTransport;
            return this;
        }

        public Builder withFood(boolean food) {
            this.food = food;
            return this;
        }

        public Builder withNumberOfDays(int numberOfDays) {
            this.numberOfDays = numberOfDays;
            return this;
        }

        public Builder withPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder withTypeOfTour(String typeOfTour) {
            this.typeOfTour = typeOfTour;
            return this;
        }
    }
}
