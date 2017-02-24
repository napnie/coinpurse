package coinpurse;

/**
 * 
 * @author Nitith Chayakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 10000001L;
	
	/**
	 * 
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
	 * 
	 * @param value
	 * @return
	 */
	private boolean isCoin(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10) {
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
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return true;
		} else {
			return false;
		}
	}

}
