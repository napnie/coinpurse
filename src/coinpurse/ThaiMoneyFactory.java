package coinpurse;

/**
 * Factory class to create thai money object.
 * @author Nitith Chayakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/** attribute for assigns banknote serial number */
	private static long nextSerialNumber = 10000001L;
	
	/**
	 * Create a baht money.
	 * @param value - value of a baht money
	 * @return Valuable object of a baht money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable thaiMoney = null;
		if ( isCoin(value) ) {
			thaiMoney = new Coin(value);
		} else if ( isBankNote(value) ) {
			thaiMoney = new BankNote(value, nextSerialNumber++);
		} else {
			throw new IllegalArgumentException();
		}
		return thaiMoney;
	}
	
	/**
	 * Check if value can be consider as baht coin.
	 * @param value - value that you want to check
	 * @return true if it is baht coin, false if it is not
	 */
	private boolean isCoin(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Check if value can be consider as baht banknote.
	 * @param value - value that we want to check
	 * @return true if it is baht banknote, false if it is not
	 */
	private boolean isBankNote(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return true;
		} else {
			return false;
		}
	}

}
