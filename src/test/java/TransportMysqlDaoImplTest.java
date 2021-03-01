import dao.implementations.RoutesMysqlDaoImpl;
import dao.implementations.TransportMysqlDaoImpl;
import models.Route;
import models.Transport;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class TransportMysqlDaoImplTest {
    final static String URL = "jdbc:mysql://localhost:3306/transport4";

    @Test(priority=0)
    public void getAllTransportTest() {
        TransportMysqlDaoImpl test = new TransportMysqlDaoImpl();
        List<Transport> res = test.getAllTransport();

        Assert.assertEquals(res.size(), 3);
        Assert.assertEquals(res.get(0).getTransportId(), 1);
        Assert.assertEquals(res.get(0).getTransportType(), "bus");
        Assert.assertEquals(res.get(1).getTransportId(), 2);
        Assert.assertEquals(res.get(1).getTransportType(), "tram");
        Assert.assertEquals(res.get(2).getTransportId(), 3);
        Assert.assertEquals(res.get(2).getTransportType(), "trolleybus");
    }


    @Test (priority=1)
    public void addTransportTest() {
        TransportMysqlDaoImpl test = new TransportMysqlDaoImpl();
        Transport transport = new Transport();
        Transport a = test.add(transport);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String URL = "jdbc:mysql://localhost:3306/transport4";
        String sql = "SELECT * FROM transport WHERE transportType = ?";

        try {
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setString(1, "metro");
            rs = ps.executeQuery();

            String res = rs.getString(2);
            Assert.assertEquals("metro", res);

            //} catch (ClassNotFoundException e) {
            //System.out.println("Can not find Mysql driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL select");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Transport added into transport");
        //return transport;
    }

    @Test (priority=2)
    public void TransportDeleteTest() {
        TransportMysqlDaoImpl test = new TransportMysqlDaoImpl();
        Transport transport = new Transport();

        test.delete(4);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String URL = "jdbc:mysql://localhost:3306/transport4";

        String sql = "SELECT * FROM transport WHERE transportId = 4";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.getResultSet();
            String res = rs.getString(2);
            Assert.assertNull(res);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL delete");

        } finally {
            try {

                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("No more transport indeed");
    }

    @Test (priority=3)
    public void TransportUpdateTest() {
        TransportMysqlDaoImpl test = new TransportMysqlDaoImpl();
        Transport transport = new Transport();

        test.update(transport, 2);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String URL = "jdbc:mysql://localhost:3306/transport4";

        String sql = "SELECT * FROM transport WHERE transportId = 1";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int a = rs.getInt(1);
                String b = rs.getString(2);
                Assert.assertEquals(a, 1);
                Assert.assertEquals(b, "taxi");
                System.out.println("TransportId " + a + " now corresponds to transportType " + b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL query");

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Route updated");
    }

    @Test (priority=4)
    public void TransportGetTest() {
        TransportMysqlDaoImpl test = new TransportMysqlDaoImpl();
        Transport transport = new Transport();

        Transport a = test.get(3);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String URL = "jdbc:mysql://localhost:3306/transport4";

        String sql = "SELECT * FROM transport WHERE transportId = 3";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int fst = rs.getInt(1);
                String expected = rs.getString(2);
                Assert.assertEquals(fst, 3);
                Assert.assertEquals(expected, "trolleybus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL query");

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Transport selected");
    }

}
