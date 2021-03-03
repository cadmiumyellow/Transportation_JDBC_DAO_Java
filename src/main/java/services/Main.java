package services;

import models.Route;
import models.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("You can add, delete, update and read from Routes table");
        System.out.println("You can add, delete, update and read from Transport table");
        Scanner sc = new Scanner(System.in);
        System.out.println("Table Routes: to see all routes type 1, to add type 2, to delete type 3, to update type 4, to read type 5");
        System.out.println("Table Transport: to see all transport type 6, to add type 7, to delete type 8, to update type 9, to read type 10");
        int choice = sc.nextInt();

        RouteService rService = new RouteService();
        TransportService tService = new TransportService();

        switch (choice) {
            case 1:
                List<Route> routeList = new ArrayList<>();
                routeList = rService.getAllRoutes();

                for (int k = 0; k < routeList.size(); k++) {
                    System.out.println(routeList.get(k).getRouteNumber());
                }
                break;
            case 2:
                rService.add(new Route());
                break;
            case 3:
                rService.delete(5);
                break;
            case 4:
                rService.update(new Route(), 2);
                break;
            case 5:
                rService.get(3);
                break;
            case 6:
                List<Transport> transportList = new ArrayList<>();
                transportList = tService.getAllTransport();
                for (int j = 0; j < transportList.size(); j++) {
                    System.out.println(transportList.get(j).getTransportType());
                }
                break;
            case 7:
                tService.add(new Transport());
                break;
            case 8:
                tService.delete(4);
                break;
            case 9:
                tService.update(new Transport(), 1);
                break;
            case 10:
                tService.get(3);
                break;
            default:
                System.out.println("You should choose an existing option (1-10). Please try again");

        }
        sc.close();
    }
}