package DBTest;

import com.joinup.util.ConnectorDB;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectorDBTest {

    @Test
    public void testDBConnection() throws SQLException {
        Connection con = ConnectorDB.withConnection();
        Assert.assertEquals(con != null, true);
    }
}