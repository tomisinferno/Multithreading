/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.hall.threads;

import info.hccis.util.CisUtility;
import java.util.Scanner;
import performance.hall.entity.Order;

/**
 *
 * @author tomia
 * @since 12/2/2021
 * Thread for running console application
 */
public class OrderConsole extends Thread {

    @Override
    public void run() {

        Scanner input = new Scanner(System.in);

        final String MENU = "Florence Simmons Hall Ticket Office Application" + System.lineSeparator()
                + "1) Make an order for tickets" + System.lineSeparator()
                + "2) Show summary" + System.lineSeparator()
                + "0) Exit;" + System.lineSeparator();

        String option = "";
        Order order = new Order();
        while (!option.equalsIgnoreCase("0")) {
            System.out.println(MENU);
            option = input.nextLine();
            switch (option) {
                case "1":
                    order.getInformation(true);
                    order.calculateCost();
                    order.display(true);
                    break;
                case "2":
                    order.showSummary(true);
                    break;
                case "0":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid Option\n");
                    break;
            }
        }
    }

}
