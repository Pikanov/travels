package com.joinup.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDB {
    private final static Logger LOGGER = Logger.getLogger(ConnectorDB.class);

    private static Connection connection;
    private static ConnectorDB connectorDB;

    private ConnectorDB() {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            Class.forName(property.getProperty("jdbc.driver"));
            String url = property.getProperty("jdbc.url");
            String username = property.getProperty("jdbc.username");
            String password = property.getProperty("jdbc.password");

            connection = DriverManager.getConnection(url, username, password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            LOGGER.warn("ConnectorDB was failed");
        }
    }

    public static Connection withConnection() {
        if (null == connectorDB) {
            connectorDB = new ConnectorDB();
        }
        return connection;
    }
}
