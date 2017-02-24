package coinpurse;

/**
 * Factory class to create thai money object.
 * @author Nitith Chayakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/** attribute for assigns banknote serial number */
	private static long nextSerialNumber = 10000001L;
	/** attribute for Thai currency */
	private final String CURRENCY = "Baht";
	
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
	 * Return Thai currency.
	 * @return thai currency
	 */
	public String getCurrency() {
		return CURRENCY;
	}
	
	/**
	 * Check if value can be consider as baht coin.
	 * @param value - value that you want to check
	 * @return true if it is baht coin, false if it is not
	 */
	private boolean isCoin(double value) {
		double[] possibleCoin = {1, 2, 5, 10};
		for (double coinValue : possibleCoin) {
			if (value == coinValue) return true;
		}
		return false;
	}
	
	/**
	 * Check if value can be consider as baht banknote.
	 * @param value - value that we want to check
	 * @return true if it is baht banknote, false if it is not
	 */
	private boolean isBankNote(double value) {
		double[] possibleBankNote = { 20, 50, 100, 500, 1000};
		for (double bankNoteValue : possibleBankNote) {
			if (value == bankNoteValue) return true;
		}
		return false;
	}

}
