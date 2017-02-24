package coinpurse;

import java.text.DecimalFormat;

/**
 * A Bank note with monetary value and currency. 
 * @author Nitith Chayakul
 *
 */
public class BankNote extends AbstractValuable {
	
	/** attribute for assigning unique serial number */
//	private static long nextSerialNumber = 10000000L;
	
	/** unique bank note's serial number */
	private final long serialNumber;
	
	/**
	 * Initialize a bank note.
	 * @param value - initial value of bank note
	 */
	public BankNote(double value, long serialNumber) {
		super( value, "Baht");
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Initialize a bank note with a currency.
	 * @param value - initial value of bank note
	 * @param currency - currency of bank note
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super( value, currency);
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Get bank note's serial number
	 * @return serial number of bank note
	 */
	public long getSerial() {
		return serialNumber;
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
    	BankNote other = (BankNote) obj;
    	if ( value == other.getValue() ) return true;
    	return false;
    }
	
	/**
	 * Get a String representation of bank note
	 * @return bank note's representation
	 */
	@Override
	public String toString() {
		DecimalFormat numFormat = new DecimalFormat("0.##");
		return String.format("%s-%s note [%s]",numFormat.format(value),currency,serialNumber);
	}
}
