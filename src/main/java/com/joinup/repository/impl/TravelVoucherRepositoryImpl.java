package com.joinup.repository.impl;

import com.joinup.entity.TravelVoucher;
import com.joinup.entity.TypeTour;
import com.joinup.repository.TravelVoucherRepository;
import com.joinup.util.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelVoucherRepositoryImpl implements TravelVoucherRepository {
    private final static Logger LOGGER = Logger.getLogger(TravelVoucherRepositoryImpl.class);

    @Override
    public List<TravelVoucher> defineTour(TypeTour typeOfTour) {

        String query = "SELECT * FROM travels.travelvouchers " +
                "JOIN type_transport ON travelvouchers.typeOfTransport=type_transport.id" +
                " JOIN type_tour ON travelvouchers.typeOfTour=type_tour.id " +
                "WHERE type_tour.name_tour=?";

        List<TravelVoucher> result = new ArrayList<>();

        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(query)) {
            ps.setString(1, typeOfTour.getTitle());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(builder(resultSet));
            }
        } catch (Exception e) {
            LOGGER.warn("was incorrect SQL query");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TravelVoucher> defineTour(TypeTour typeOfTour, int numberOfDays) {
        String query = "SELECT * FROM travels.travelvouchers" +
                " JOIN type_transport ON travelvouchers.typeOfTransport=type_transport.id " +
                "JOIN type_tour ON travelvouchers.typeOfTour=type_tour.id " +
                "WHERE type_tour.name_tour=? AND numberOfDays=?";

        List<TravelVoucher> result = new ArrayList<>();

        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(query)) {
            ps.setString(1, typeOfTour.getTitle());
            ps.setInt(2, numberOfDays);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(builder(resultSet));
            }
        } catch (Exception e) {
            LOGGER.warn("was incorrect SQL query");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TravelVoucher> defineTour(int typeOfTransport, boolean food, int numberOfDays) {
        String query = "SELECT * FROM travels.travel_vouchers " +
                "JOIN type_transport ON travel_vouchers.type_of_transport=type_transport.id_type_transport " +
                "JOIN type_tour ON travel_vouchers.type_of_tour=type_tour.id_type_tour " +
                "WHERE type_transport.id_type_transport=? AND food=? AND number_of_days=?";

        List<TravelVoucher> result = new ArrayList<>();

        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(query)) {
            ps.setInt(1, typeOfTransport);
            ps.setBoolean(2, food);
            ps.setInt(3, numberOfDays);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(builder(resultSet));
            }
        } catch (Exception e) {
            LOGGER.warn("was incorrect SQL query");
            e.printStackTrace();
        }
        return result;
    }


    private TravelVoucher builder(ResultSet resultSet) {
        TravelVoucher travelVoucher = new TravelVoucher();
        try {
            travelVoucher.setTravelVoucherId(resultSet.getLong("id_travel_voucher"));
            travelVoucher.setTypeOfTransport(resultSet.getString("name_transport"));
            travelVoucher.setPrice(resultSet.getInt("price"));
            travelVoucher.setNumberOfDays(resultSet.getInt("number_of_days"));
            travelVoucher.setFood(resultSet.getBoolean("food"));
            travelVoucher.setTypeOfTour(resultSet.getString("name_tour"));
        } catch (SQLException e) {
            LOGGER.warn("was incorrect name of columns");
            e.printStackTrace();
        }
        return travelVoucher;
    }
}