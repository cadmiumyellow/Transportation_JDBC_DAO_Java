package dao.implementations;

import dao.interfaces.TransportDaoInterface;
import models.Route;
import models.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportMysqlDaoImpl implements TransportDaoInterface {

    final static String URL = "jdbc:mysql://localhost:3306/transport6";

    public List<Transport> getAllTransport() {
        Transport transport = new Transport();
        List<Transport> transportList = new ArrayList<>();
        String sql = "SELECT * FROM transport";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            st = con.createStatement();
            st.executeQuery(sql);
            rs = st.getResultSet();
            while(rs.next()) {
                transport = new Transport();
                transport.setTransportId(rs.getInt("transportId"));
                transport.setTransportType(rs.getString("transportType"));

                transportList.add(transport);
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
        System.out.println(transportList);
        return transportList;

    }

    @Override
    public Transport add(Transport transport) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO transport (transportType) VALUES (?)";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setString(1, "metro");
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
        System.out.println("Transport added into transport");
        return transport;
    }


    @Override
    public void delete(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "DELETE FROM transport WHERE transportId = ?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setInt(1, 4);
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
        System.out.println("Transport deleted from transport");
    }

    @Override
    public void update(Transport transport, Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "UPDATE IGNORE transport SET transportType=? WHERE transportId =?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "Zest2018");
            System.out.println("Connected to database");

            ps = con.prepareStatement(sql);
            ps.setString(1, "taxi");
            ps.setInt(2, 1);
            ps.executeUpdate();

            //} catch (ClassNotFoundException e) {
            // System.out.println("Can not find Mysql driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not execute SQL update");
        } finally {
            try {
                /*while (rs.next()) {
                    int a = rs.getInt(1);
                    String b = rs.getString(2);
                    System.out.println("TransportId " + a + " now corresponds to transportType " + b);
                }*/
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Transport updated");
    }

    public Transport get(Integer id) {
        Transport transport = new Transport();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM transport WHERE transportId = ?";

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
                    String b = rs.getString(2);
                    System.out.println("TransportId is " + a + ", transportType is " + b);
                }

                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Can not close result set, statement or connection");
            }
        }
        System.out.println("Transport selected");
        return transport;
    }
}

