package performance.hall.entity;

import info.hccis.util.CisUtility;
import javax.swing.JOptionPane;

public class Order {

    //Changed Varaiable accesses Modifiers
    private static int numberOfTickets;
    private static boolean hasHollpass;
    private static double discount;
    private static double cost;
    private static double runningCost;
    private static int runningTickets;

    public Order() {

    }

    public Order(int numberOfTickets, boolean hasHollpass) {
        this.numberOfTickets = numberOfTickets;
        this.hasHollpass = hasHollpass;
    }

    public double calculateCost() {
        int ticketPrice = 10;
        int baseCost = numberOfTickets * ticketPrice;
        double sale = 0;
        if (hasHollpass) {
            sale += getDiscount();
        }
        if (numberOfTickets < 10) {
            cost = baseCost - (baseCost * sale);
        } else if (numberOfTickets < 20) {
            sale += .1;
            cost = baseCost - (baseCost * sale);
        } else {
            sale += .15;
            cost = baseCost - (baseCost * sale);
        }
        runningTickets = runningTickets + numberOfTickets;
        runningCost = runningCost + cost;
        return cost;
    }

    public static boolean validate(int hollPassNumber) {
        if (hollPassNumber % 13 == 7) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public boolean isHasHollpass() {
        return hasHollpass;
    }

    public void setHasHollpass(boolean hasHollpass) {
        this.hasHollpass = hasHollpass;
    }

    public double getDiscount() {
        discount = .1;
        return discount;
    }

    public double getCost() {
        return calculateCost();
    }

    public void getInformation(boolean useConsole) {
        numberOfTickets = CisUtility.getInputInt("Enter number of tickets:", useConsole);
        String hollpassYN = CisUtility.getInputString("Do you have a Hollpass? (y/n)", useConsole);

        hasHollpass = hollpassYN.equalsIgnoreCase("Y") ? true : false;
        //OR could do it this way
        if (hollpassYN.equalsIgnoreCase("Y")) {
            hasHollpass = true;
        } else {
            hasHollpass = false;
        }
    }

    public void showSummary(boolean useConsole) {

        String summary = "Summary\nTotal sales: $"+ runningCost  + "\nTicket Sold: " + runningTickets + "\nAverage Cost: $" + runningCost / runningTickets + " per ticket\n";
        if (useConsole) {
            System.out.println(summary);
        } else {
            JOptionPane.showMessageDialog(null, summary);
        }

    }

    public void display(boolean useConsole) {
        if (useConsole) {
            System.out.println(toString());
        } else {
            JOptionPane.showMessageDialog(null, toString());
        }

    }

    @Override
    public String toString() {
        return "Thank you for your order!\nNumber of tickets: " + numberOfTickets
                + "\nDiscount: " + discount + "\nCost: $" + cost + "\n\n";
    }

}
