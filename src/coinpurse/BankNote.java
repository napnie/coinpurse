package coinpurse;

import java.text.DecimalFormat;

/**
 * A Bank note with monetary value and currency. 
 * @author Nitith Chayakul
 *
 */
public class BankNote implements Valuable {
	
	/** attribute for assigning unique serial number */
	private static long nextSerialNumber = 10000000L;
	/** value of the bank note */
	private double value;
	/** currency of the bank note */
	private String currency;
	/** unique bank note's serial number */
	private long serialNumber;
	
	/**
	 * Initialize a bank note.
	 * @param value - initial value of bank note
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = "Baht";
		serialNumber = nextSerialNumber++;
	}
	
	/**
	 * Initialize a bank note with a currency.
	 * @param value - initial value of bank note
	 * @param currency - currency of bank note
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		serialNumber = nextSerialNumber++;
	}

	/**
	 * Get a bank note currency.
	 * @return currency of bank note
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get a bank note value
	 * @return value of bank note
	 */
	@Override
	public double getValue() {
		return value;
	}
	
	/**
	 * Get bank note's serial number
	 * @return serial number of bank note
	 */
	public long getSerial() {
		return serialNumber;
	}
	
	/**
	 * Check if other bank note are equals to this bank note
	 * @param obj - other bank note to check
	 * @return true if other value are equal, false if they are not equal or other bank note are null
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

	/**
	 * compare order of the bank note
	 * @return order of the bank note. zero if equal, negative if this bank note come before other bank note,
	 * 		positive if this bank note come after other bank note.
	 */
	@Override
	public int compareTo(Valuable other) {
		if ( other == null ) return -1;
    	if ( value < other.getValue() ) return -1;
    	if ( value > other.getValue() ) return 1;
    	return 0;
	}
}
