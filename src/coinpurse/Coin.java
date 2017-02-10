package coinpurse;

import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class Coin implements Comparable<Coin> {

    /** Value of the coin. */
    private double value;
    /** The currency, of course. */
    private String currency = "Baht";
    
    /**
     * Create a coin with Baht currency.
     * @param value is the value of the coin
     */
    public Coin( double value ) {
        this.value = value;
    }
    
    /**
     * Create a coin
     * @param value is a value of the coin
     * @param currency is a coin's currency
     */
    public Coin( double value , String currency){
    	this.value = value;
    	this.currency = currency;
    }

    /**
     * Get the value of the coin.
     * @return value of the coin
     */
    public double getValue( ) { return value; }
    
    /**
     * Get the coin's currency.
     * @return coin's currency
     */
    public String getCurrency() {return this.currency;}
    
    /**
     * Test if other object and this Coin class are equal in value
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
     * Compare order of the coin.
     * @param other is other coin to compare
     * @return order of the object : negative if this value is less than coin or other coin is null, positive if this value is more than coin
     * 		, zero if their value is the same
     */
    @Override
    public int compareTo(Coin other){
    	if ( other == null ) return -1;
    	if ( value < other.getValue() ) return -1;
    	if ( value > other.getValue() ) return 1;
    	return 0;
    	
    }

    /**
     * Return String representation of the coin.
     * @return String representation of the coin
     */
    @Override
    public String toString(){
    	DecimalFormat numFormat = new DecimalFormat("0.##");
    	return String.format("%s %s",numFormat.format(value),currency);
    }

    
}
