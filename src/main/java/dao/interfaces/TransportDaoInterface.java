package dao.interfaces;

import models.Route;
import models.Transport;

import java.util.List;

public interface TransportDaoInterface extends CrudInterface<Transport, Integer>{
    public List<Transport> getAllTransport();
}

