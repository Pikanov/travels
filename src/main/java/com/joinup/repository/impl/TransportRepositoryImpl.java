package com.joinup.repository.impl;

import com.joinup.entity.Transport;
import com.joinup.repository.TransportRepository;
import com.joinup.util.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportRepositoryImpl implements TransportRepository {
    private final static Logger LOGGER = Logger.getLogger(TransportRepositoryImpl.class);

    @Override
    public List<Transport> isAll() {
        String query = "SELECT * FROM type_transport";
        List<Transport> result = new ArrayList<>();
        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(build(resultSet));
            }
        } catch (Exception e) {
            LOGGER.debug("incorrect sql query");
            e.printStackTrace();
        }
        return result;
    }

    private Transport build(ResultSet resultSet) {
        Transport tarnsport = new Transport();
        try {
            tarnsport.setId(resultSet.getInt("id_type_transport"));
            tarnsport.setNameTransport(resultSet.getString("name_transport"));
        } catch (SQLException e) {
            LOGGER.debug("incorrect sql query");
            e.printStackTrace();
        }
        return tarnsport;
    }
}