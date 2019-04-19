package com.joinup.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    private final static Logger LOGGER = Logger.getLogger(ConnectorDB.class);
    private static Connection connection;
    private static ConnectorDB connectorDB;

    private ConnectorDB() {
        LOGGER.info("Method ConnectorDB was started");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/travels?characterEncoding=UTF-8&"
                    + "user=root&password=greentea012591");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            LOGGER.fatal("Method ConnectorDB was failed");
        }
    }

    public static Connection withConnection() {
        if (null == connectorDB) {
            connectorDB = new ConnectorDB();
        }
        return connection;
    }
}