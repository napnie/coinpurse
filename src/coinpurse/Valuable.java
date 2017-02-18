package coinpurse;

/**
 * An interface to described a characteristics of money.
 * @author Nitith Chayakul
 * 
 */
public interface Valuable extends Comparable<Valuable> {
	
	/**
	 * Get the currency of this object.
	 * @return the currency of this object
	 */
	public String getCurrency() ;
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public double getValue() ;
}
