package models;

public class TransportRoutes {
    private int transportRoutesId;
    private int transportId;
    private int routeId;

    public TransportRoutes() {

    }

    public int getTransportRoutesId() {
        return transportRoutesId;
    }

    public void setTransportRoutesId(int transportRoutesId) {
        this.transportRoutesId = transportRoutesId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
