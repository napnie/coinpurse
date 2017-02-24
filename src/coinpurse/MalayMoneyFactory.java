package coinpurse;

/**
 * Factory class to create a Malay money.
 * @author Nitith Chayakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 10000001L;
	
	/**
	 * Create a malay money.
	 * @param value - value of a malay money
	 * @return Valuable object of malay money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable malayMoney = null;
		if ( isCoin(value) ) {
			malayMoney = new Coin(value, "Ringgit", "Sen");
		} else if ( isBankNote(value) ) {
			malayMoney = new BankNote(value, "Ringgit", nextSerialNumber++);
		} else {
			throw new IllegalArgumentException();
		}
		return malayMoney;
	}
	
	/**
	 * Check if value can be consider as malay coin.
	 * @param value - value that you want to check
	 * @return true if it is malay coin, false if it is not
	 */
	private boolean isCoin(double value) {
		if (value == .05 || value == .1 || value == .2 || value == .5) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Check if value can be consider as malay banknote.
	 * @param value - value that we want to check
	 * @return true if it is malay banknote, false if it is not
	 */
	private boolean isBankNote(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			return true;
		} else {
			return false;
		}
	}
}
