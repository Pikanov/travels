package com.joinup.entity;

public class Transport {

    private int id;
    private String nameTransport;


    private Transport(Builder builder) {
        this.id = builder.id;
        this.nameTransport = builder.nameTransport;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public String getNameTransport() {
        return nameTransport;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(" ID - ")
                .append(id)
                .append(" | Type of transport - ")
                .append(nameTransport);
        return sb.toString();
    }

    public static class Builder {
        private int id;
        private String nameTransport;

        private Builder() {
        }

        public Builder(int id, String nameTransport) {
            this.id = id;
            this.nameTransport = nameTransport;
        }

        public Transport build() {
            return new Transport(this);
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withNameTransport(String nameTransport) {
            this.nameTransport = nameTransport;
            return this;
        }
    }

}
