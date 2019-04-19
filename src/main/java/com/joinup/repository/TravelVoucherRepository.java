package com.joinup.repository;

import com.joinup.entity.TravelVoucher;
import com.joinup.entity.TypeTour;

import java.util.List;

public interface TravelVoucherRepository {

    List<TravelVoucher> defineTour(TypeTour typeOfTour);

    List<TravelVoucher> defineTour(TypeTour typeOfTour, int numberOfDays);

    List<TravelVoucher> defineTour(int typeOfTransport, boolean food, int numberOfDays);
}