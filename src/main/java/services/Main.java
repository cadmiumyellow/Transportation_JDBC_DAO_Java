package services;

import dao.implementations.RoutesMysqlDaoImpl;
import dao.implementations.TransportMysqlDaoImpl;
import models.Route;
import models.Transport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("You can add, delete, update and read from Routes table");
        System.out.println("You can add, delete, update and read from Transport table");
        Scanner sc = new Scanner(System.in);
        System.out.println("Table Routes: to add type 1, to delete type 2, to update type 3, to read type 4");
        System.out.println("Table Transport: to add type 5, to delete type 6, to update type 7, to read type 8");
        int i = sc.nextInt();

        RoutesMysqlDaoImpl test = new RoutesMysqlDaoImpl();
        TransportMysqlDaoImpl test1 = new TransportMysqlDaoImpl();
        switch (i) {

            case 1:
                test.add(new Route());
                break;
            case 2:
                test.delete(5);
                break;
            case 3:
                test.update(new Route(), 5);
                break;
            case 4:
                test.get(3);
                break;
            case 5:
                test1.add(new Transport());
                break;
            case 6:
                test1.delete(1);
                break;
            case 7:
                test1.update(new Transport(), 1);
                break;
            case 8:
                test1.get(3);
                break;
            default:
                System.out.println("You should choose an existing option (1-8). Please try again");

        }
    }
}