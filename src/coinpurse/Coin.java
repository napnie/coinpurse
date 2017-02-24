package coinpurse;

import java.text.DecimalFormat;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class Coin extends AbstractValuable {
    String denomination;
	
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
    
    public Coin(double value, String currency, String denomination) {
    	super( value, currency);
    	this.denomination = denomination;
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
    	String showCurrency="";
    	if ( denomination==null ) {
    		showCurrency = currency;
    	} else {
    		showCurrency = denomination;
    	}
    	DecimalFormat numFormat = new DecimalFormat("0.##");
    	return String.format("%s %s",numFormat.format(value),showCurrency);
    }
    
    public void setDenomination(String denomination) {
    	this.denomination = denomination;
    }
}
