package com.joinup.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Transport {

    private int id;
    private String nameTransport;

    public Transport() {

    }


    @Override
    public String toString() {
        return "Transport: " +
                "number - " + id + " " + nameTransport;
    }
}