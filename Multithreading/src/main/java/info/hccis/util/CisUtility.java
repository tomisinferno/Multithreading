package info.hccis.util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Has some useful methods to be used in our programs.
 *
 * @author bjmaclean
 * @since Oct 19, 2021
 */
public class CisUtility {

    private static Scanner input = new Scanner(System.in);

    /**
     * Return the default currency String value of the double passed in as a
     * parameter.
     *
     * @param inputDouble double to be formatted
     * @return String in default currency format
     *
     * @since 20211020
     * @author BJM
     */
    public static String toCurrency(double inputDouble) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(inputDouble);
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return String entered by the user
     * @since 20211020
     * @author BJM
     */
    public static String getInputString(String prompt, boolean useConsole) {

        String output = "";
        if (useConsole) {
            System.out.println(prompt + " -->");
            output = input.nextLine();
        }else{
            output = JOptionPane.showInputDialog(prompt);
        }
        
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @param useConsole Tells user to use console or gui
     * @return The double entered by the user
     * @since 20211020
     * @author BJM
     */
    public static int getInputInt(String prompt, boolean useConsole) {

        String inputString = getInputString(prompt,useConsole);
        int output = Integer.parseInt(inputString);
        return output;
    }

    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @since 20211108
     * @author BJM
     */
    public static boolean getInputBoolean(String prompt, boolean useConsole) {

        String inputString = getInputString(prompt + " (y/n)", useConsole);
        if (inputString.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * Provide today's date in the specified format
     *
     * @param format Date format desired
     * @return Today's date in specified format
     * @since 20211021
     * @author BJM
     */
    public static String getTodayString(String format) {
        //https://www.javatpoint.com/java-get-current-date

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    /**
     * Get a random number between min and max
     *
     * @since 20211109
     * @author BJM
     */
    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int theRandomNumber = rand.nextInt((max - min) + 1) + min;
        return theRandomNumber;
    }

}
