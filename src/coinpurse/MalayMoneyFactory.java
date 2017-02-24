package coinpurse;

/**
 * Factory class to create a Malay money.
 * @author Nitith Chayakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	/** attribute for assigns banknote serial number */
	private static long nextSerialNumber = 10000001L;
	/** attribute for Malay currency */
	private final String CURRENCY = "Ringgit";
	
	/**
	 * Create a malay money.
	 * @param value - value of a malay money
	 * @return Valuable object of malay money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable malayMoney = null;
		if ( isCoin(value) ) {
			malayMoney = new Coin(value, CURRENCY, "Sen", 100);
		} else if ( isBankNote(value) ) {
			malayMoney = new BankNote(value, CURRENCY, nextSerialNumber++);
		} else {
			throw new IllegalArgumentException();
		}
		return malayMoney;
	}
	
	/**
	 * Return Malay currency.
	 * @return malay currency
	 */
	public String getCurrency() {
		return CURRENCY;
	}
	
	/**
	 * Check if value can be consider as malay coin.
	 * @param value - value that you want to check
	 * @return true if it is malay coin, false if it is not
	 */
	private boolean isCoin(double value) {
		double[] possibleCoin = { 0.05, 0.10, 0.20, 0.50};
		for (double coinValue : possibleCoin) {
			if (value == coinValue) return true;
		}
		return false;
	}
	
	/**
	 * Check if value can be consider as malay banknote.
	 * @param value - value that we want to check
	 * @return true if it is malay banknote, false if it is not
	 */
	private boolean isBankNote(double value) {
		double[] possibleBankNote = { 1, 2, 5, 10, 20, 50, 100};
		for (double bankNoteValue : possibleBankNote) {
			if (value == bankNoteValue) return true;
		}
		return false;
	}
}
