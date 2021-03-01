import dao.implementations.RoutesMysqlDaoImpl;
import models.Route;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutesMysqlDaoImplTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {

    }

    @Test(priority=0)
    public void getAllRoutesTest() {
        final String URL = "jdbc:mysql://localhost:3306/transport4";

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        List<Route> res = test.getAllRoutes();

        Assert.assertEquals(res.size(), 5);
        Assert.assertEquals(res.get(0).getRouteId(), 1);
        Assert.assertEquals(res.get(0).getRouteNumber(), 1);
        Assert.assertEquals(res.get(1).getRouteId(), 2);
        Assert.assertEquals(res.get(1).getRouteNumber(), 2);
        Assert.assertEquals(res.get(2).getRouteId(), 3);
        Assert.assertEquals(res.get(2).getRouteNumber(), 3);
        Assert.assertEquals(res.get(3).getRouteId(), 4);
        Assert.assertEquals(res.get(3).getRouteNumber(), 4);
        Assert.assertEquals(res.get(4).getRouteId(), 5);
        Assert.assertEquals(res.get(4).getRouteNumber(), 5);
    }

    @Test (priority=1)
    public void RouteAddTest() {
        final String URL = "jdbc:mysql://localhost:3306/transport4";

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        Route route = new Route();

        Route result = test.add(route);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM routes WHERE routeNumber = ?";

        try {
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 115);
            rs = ps.executeQuery();

            int res = rs.getInt(2);
            Assert.assertEquals(115, res);

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
    }


    @Test (priority=2)
    public void RouteDeleteTest() {
        final String URL = "jdbc:mysql://localhost:3306/transport4";

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        Route route = new Route();

        test.delete(5);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM routes WHERE routeId = 5";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int res = rs.getInt(1);
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
        System.out.println("No more route indeed");
    }

    @Test (priority=3)
    public void RouteUpdateTest() {
        final String URL = "jdbc:mysql://localhost:3306/transport4";

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        Route route = new Route();

        test.update(route, 2);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM routes WHERE routeId = 2";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int a = rs.getInt(1);
                int b = rs.getInt(2);
                Assert.assertEquals(a, 2);
                Assert.assertEquals(b, 7);
                System.out.println("RouteId " + a + " now corresponds to routeNumber " + b);
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
    public void RouteGetTest() {
        final String URL = "jdbc:mysql://localhost:3306/transport4";

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        Route route = new Route();

        Route a = test.get(3);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM routes WHERE routeId = 3";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //int fst = rs.getInt(1);
                int expected = rs.getInt(2);
                Assert.assertEquals(expected, 3);
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
        System.out.println("Route selected");
    }
}



