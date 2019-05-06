package com.joinup.repository.impl;

import com.joinup.entity.TravelVoucher;
import com.joinup.repository.TravelVoucherRepository;
import com.joinup.util.ConnectorDB;
import com.joinup.util.QueryParam;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelVoucherRepositoryImpl implements TravelVoucherRepository {
    private final static Logger LOGGER = Logger.getLogger(TravelVoucherRepositoryImpl.class);

    private static final String SELECT_FROM_TRAVEL_VOUCHERS = "SELECT * FROM travels.travel_vouchers " +
            "JOIN type_transport ON travel_vouchers.type_of_transport=type_transport.id_type_transport " +
            "JOIN type_tour ON travel_vouchers.type_of_tour=type_tour.id_type_tour " +
            "WHERE type_transport.id_type_transport=? AND food=? AND number_of_days=?";

    @Override
    public List<TravelVoucher> defineTour(QueryParam queryParam) {

        List<TravelVoucher> result = new ArrayList<>();

        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(SELECT_FROM_TRAVEL_VOUCHERS)) {
            ps.setInt(1, queryParam.getTypeOfTransport());
            ps.setBoolean(2, queryParam.isFood());
            ps.setInt(3, queryParam.getNumberOfDays());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(builder(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.info("was incorrect SQL query");
            throw new RuntimeException(e); //TODO делать кастомный ексепшин
        }
        return result;
    }

    private TravelVoucher builder(ResultSet resultSet) throws SQLException {

        return TravelVoucher.builder()
                .withTravelVoucherId(resultSet.getLong("id_travel_voucher"))
                .withTypeOfTransport(resultSet.getString("name_transport"))
                .withPrice(resultSet.getInt("price"))
                .withNumberOfDays(resultSet.getInt("number_of_days"))
                .withFood(resultSet.getBoolean("food"))
                .withTypeOfTour(resultSet.getString("name_tour"))
                .build();
    }
}
