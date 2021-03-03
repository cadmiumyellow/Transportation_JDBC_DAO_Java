package services;

import dao.implementations.RoutesMysqlDaoImpl;
import models.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService {

    public List<Route> getAllRoutes() {
        RoutesMysqlDaoImpl impl = new RoutesMysqlDaoImpl();
        Route route = new Route();
        List<Route> routeList = new ArrayList<>();
        routeList = impl.getAllRoutes();
        return routeList;
    }

    public Route add(Route route) {
        RoutesMysqlDaoImpl impl = new RoutesMysqlDaoImpl();
        impl.add(route);
        return route;
    }

    public void delete(Integer id) {
        RoutesMysqlDaoImpl impl = new RoutesMysqlDaoImpl();
        impl.delete(id);
    }

    public void update(Route route, Integer id) {
        RoutesMysqlDaoImpl impl = new RoutesMysqlDaoImpl();
        impl.update(route, id);
    }

    public Route get(Integer id) {
        Route route = new Route();
        RoutesMysqlDaoImpl impl = new RoutesMysqlDaoImpl();
        impl.get(id);
        return route;
    }
}
