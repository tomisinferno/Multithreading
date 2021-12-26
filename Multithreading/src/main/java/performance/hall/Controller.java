/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.hall;

import info.hccis.util.CisUtility;
import performance.hall.entity.Order;
import performance.hall.threads.OrderConsole;
import performance.hall.threads.OrderGUI;

/**
 * Sample program for Test Driven Development
 *
 * @author bjmaclean
 * @since 20211122
 * @modified Oluwatomi
 * @since 12/2/2021
 */
public class Controller {

    public static void main(String[] args) {

        
        //Called Threads
        OrderConsole oConsole = new OrderConsole();
        oConsole.start();

        OrderGUI oGUI = new OrderGUI();
        oGUI.start();
    }

}
