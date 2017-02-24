package coinpurse;

/**
 * 
 * @author Nitith Chayakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 10000001L;
	
	/**
	 * 
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
	 * 
	 * @param value
	 * @return
	 */
	private boolean isCoin(double value) {
		if (value == .05 || value == .1 || value == .2 || value == .5) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private boolean isBankNote(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			return true;
		} else {
			return false;
		}
	}
}
