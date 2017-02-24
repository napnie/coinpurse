package coinpurse;

import java.text.DecimalFormat;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class Coin extends AbstractValuable {
	/** attribute for a different denomination of a coin's currency */
    private String denomination;
    /** attribute for ratio to exchange from main currency to a different denomination */
    private double exchange; 
	
    /**
     * Create a coin with Baht currency.
     * @param value is the value of the coin
     */
    public Coin( double value ) {
        super( value , "Baht");	
    }
    
    /**
     * Create a coin
     * @param value is a value of the coin
     * @param currency is a coin's currency
     */
    public Coin( double value , String currency){
    	super( value, currency);
    }
    
    /**
     * Create a coin with denomination
     * @param value - value of a coin with currency
     * @param currency - currency of a coin
     * @param denomination - currenct's different denomination of a coin
     * @param exchange - ratio to exchange from main currency to different denomination
     */
    public Coin(double value, String currency, String denomination, double exchange) {
    	super( value, currency);
    	this.denomination = denomination;
    	this.exchange = exchange;
    }

    /**
     * Test if other object and this Money class are equal in value
     * @param obj - Other object
     * @return false if other object are null or not the Coin class or has different value, 
     * true if other object are the Coin class with the same value 
     */
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if ( obj.getClass() != getClass() ) return false;
    	Coin other = (Coin) obj;
    	if ( value == other.getValue() ) return true;
    	return false;
    }
    
    /**
     * Return String representation of the coin.
     * @return String representation of the coin
     */
    @Override
    public String toString(){
    	String showCurrency;
    	double showValue;
    	if ( denomination==null ) {
    		showCurrency = currency;
    		showValue = value;
    	} else {
    		showCurrency = denomination;
    		showValue = value * exchange;
    	}
    	DecimalFormat numFormat = new DecimalFormat("0.##");
    	return String.format("%s %s",numFormat.format(showValue),showCurrency);
    }
    
}
