package coinpurse;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseStatusObserver;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class Main {
	
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
        // 1. create a Purse
    	Purse purse = new Purse( 10 );
    	PurseBalanceObserver purseObserver = new PurseBalanceObserver();
    	PurseStatusObserver purseStatus = new PurseStatusObserver();
    	purse.addObserver( purseObserver );
    	purse.addObserver(purseStatus);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
    	purseObserver.run();
    	purseStatus.run();
    	ui.run();
    	purse.notifyObservers();
    }
    
    
}
