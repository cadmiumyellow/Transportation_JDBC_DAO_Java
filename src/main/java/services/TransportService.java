package services;

import dao.implementations.TransportMysqlDaoImpl;
import models.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportService {

    public List<Transport> getAllTransport() {
        TransportMysqlDaoImpl impl = new TransportMysqlDaoImpl();
        Transport transport = new Transport();
        List<Transport> transportList = new ArrayList<>();
        transportList = impl.getAllTransport();
        return transportList;
    }

    public Transport add(Transport transport) {
        TransportMysqlDaoImpl impl = new TransportMysqlDaoImpl();
        //Transport transport = new Transport();
        transport = impl.add(new Transport());
        return transport;
    }

    public void delete(Integer id) {
        TransportMysqlDaoImpl impl = new TransportMysqlDaoImpl();
        impl.delete(id);
    }

    public void update(Transport transport, Integer id) {
        TransportMysqlDaoImpl impl = new TransportMysqlDaoImpl();
        impl.update(transport, id);
    }

    public Transport get(Integer id) {
        TransportMysqlDaoImpl impl = new TransportMysqlDaoImpl();
        Transport transport = new Transport();
        impl.get(id);
        return transport;
    }
}
