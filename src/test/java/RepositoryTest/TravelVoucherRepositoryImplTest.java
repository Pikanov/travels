package RepositoryTest;

import com.joinup.util.ConnectorDB;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TravelVoucherRepositoryImplTest {

    @Test
    public void shouldDefineTour() throws SQLException {
        boolean pass = false;
        Connection connection = ConnectorDB.withConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*) FROM travels.travel_vouchers");
        if (resultSet == null) {
            pass = true;
            assertEquals(pass, true);
        }
    }

    @Test(expected = SQLException.class)
    public void shouldDefineTourFail() throws SQLException {
        boolean pass = false;

        Connection connection = ConnectorDB.withConnection();

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT taravelVaucherI FROM travels.travel_vouchers");
        if (resultSet == null) {
            pass = true;
            assertEquals(pass, true);

        }
    }
}