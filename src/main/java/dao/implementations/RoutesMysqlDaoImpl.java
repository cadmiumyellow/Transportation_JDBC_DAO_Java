package dao.implementations;

import dao.interfaces.CrudInterface;
import dao.interfaces.RoutesDaoInterface;
import models.Route;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.*;

public class RoutesMysqlDaoImpl implements RoutesDaoInterface {

    final static String URL = "jdbc:mysql://localhost:3306/transport6";

    public List<Route> getAllRoutes() {
        Route route = new Route();
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT * FROM routes";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            //ps = con.prepareStatement(sql);
            st = con.createStatement();
            st.executeQuery(sql);
            rs = st.getResultSet();
            while(rs.next()) {
                route = new Route();
                route.setRouteId(rs.getInt("routeId"));
                route.setRouteNumber(rs.getInt("routeNumber"));

                routeList.add(route);
            }
        } catch (SQLException ex) {

        } finally {
            try {
                if (con != null) con.close();
                if (st != null) st.close();
                if (rs != null) rs.close();

            } catch (SQLException ex) {

            }
        }
        System.out.println(routeList);
        return routeList;

    }

    @Override
    public Route add(Route route) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO routes (routeNumber) VALUES (?)";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 115);
            ps.executeUpdate();

        //} catch (ClassNotFoundException e) {
            //System.out.println("Can not find Mysql driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL insert");
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
        System.out.println("Route added into routes");
        return route;
    }


    @Override
    public void delete(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "DELETE FROM routes WHERE routeId = ?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.executeUpdate();

        //} catch (ClassNotFoundException e) {
           // System.out.println("Can not find Mysql driver");
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
        System.out.println("Route deleted from routes");
    }

    @Override
    public void update(Route route, Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "UPDATE routes SET routeNumber=? WHERE routeId =?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 7);
            ps.setInt(2, 2);
            //rs = ps.executeQuery();
            ps.executeUpdate();

        //} catch (ClassNotFoundException e) {
           // System.out.println("Can not find Mysql driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL update");
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

    public Route get(Integer id) {
        Route route = new Route();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM routes WHERE routeId = ?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 3);
            rs = ps.executeQuery();

       // } catch (ClassNotFoundException e) {
          //  System.out.println("Can not find Mysql driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL select");
        } finally {
            try {
                while (rs.next()) {
                    int a = rs.getInt(1);
                    int b = rs.getInt(2);
                    System.out.println("RouteId is " + a + ", routeNumber is " + b);
                }

                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Route selected");
        return route;
    }
}

