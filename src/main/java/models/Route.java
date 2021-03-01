package models;

public class Route {
    private int routeId;
    private int routeNumber;

    public Route() {

    }

    public Route(int routeId, int routeNumber) {
        this.routeId = routeId;
        this.routeNumber = routeNumber;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }
}
