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

    private static final String SELECT_FROM_TYPE_TRANSPORT = "SELECT * FROM type_transport";

    @Override
    public List<Transport> isAll() {
        List<Transport> result = new ArrayList<>();
        try (PreparedStatement ps = ConnectorDB.withConnection().prepareStatement(SELECT_FROM_TYPE_TRANSPORT)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result.add(build(resultSet));
            }
        } catch (Exception e) {
            LOGGER.debug("incorrect sql query");
        }
        return result;
    }

    private Transport build(ResultSet resultSet) throws SQLException {
        return Transport.builder()
                .withId(resultSet.getInt("id_type_transport"))
                .withNameTransport(resultSet.getString("name_transport"))
                .build();
    }
}
