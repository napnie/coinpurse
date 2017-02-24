package coinpurse;

/**
 * Abstract class for Valuable interface to avoid duplicate code.
 * @author Nitith Chayakul
 *
 */
abstract public class AbstractValuable implements Valuable {
	/** attribute of a value */
	protected final double value;
	/** attribute of a currency */
	protected final String currency;
	
	/**
	 * Initialize a AbstractValuable 
	 * @param value - value of the money
	 * @param currency - currency of the money
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
     * Get the value of the money.
     * @return value of the money
     */
	@Override
    public double getValue( ) { 
    	return value; 
    }
    
    /**
     * Get the Money's currency.
     * @return money's currency
     */
	@Override
    public String getCurrency() {
    	return currency;
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
     * Compare order of the money.
     * @param other is other money to compare
     * @return order of the object : negative if this value is less than money or other coin is null, positive if this value is more than money
     * 		, zero if their value is the same
     */
    @Override
    public int compareTo(Valuable other){
    	if ( other == null ) return -1;
    	
    	if ( !currency.equalsIgnoreCase(other.getCurrency()) ) {
    		return currency.compareToIgnoreCase( other.getCurrency() );
    	}
    	
    	if ( value < other.getValue() ) return -1;
    	if ( value > other.getValue() ) return 1;
    	return 0;
    	
    }
}
