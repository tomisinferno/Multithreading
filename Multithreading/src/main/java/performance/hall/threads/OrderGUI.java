/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.hall.threads;

import java.util.Scanner;
import javax.swing.JOptionPane;
import performance.hall.entity.Order;

/**
 *
 * @author tomia
 * @since 12/2/2021
 * Thread for running GUI application
 */
public class OrderGUI extends Thread {

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
            option = JOptionPane.showInputDialog(MENU);
            switch (option) {
                case "1":
                    order.getInformation(false);
                    order.calculateCost();
                    order.display(false);
                    break;
                case "2":
                    order.showSummary(false);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option");
                    break;
            }
        }

    }

}
