package coinpurse;

import java.util.ResourceBundle;

/**
 * Factory class to create money object.
 * @author Nitith Chayakul
 *
 */
abstract public class MoneyFactory {
	/** attribute to return in getInstance method */
	private static MoneyFactory factory = null;
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("moneyFactory");
	private static String factoryclass = bundle.getString("moneyfactory");
	
	
	
	/**
	 * MoneyFactory Constructor
	 */
	protected MoneyFactory() {}
	
	/**
	 * Return MoneyFactory object
	 * @return object of this subclass
	 */
	public static MoneyFactory getInstance() {
		if (factory == null) {
			if ( factoryclass.equals("coinpurse.ThaiMoneyFactory") ) {
				factory = new ThaiMoneyFactory();
			} else if ( factoryclass.equals("coinpurse.MalayMoneyFactory") ) {
				factory = new MalayMoneyFactory();
			}
			
		}
		return factory;
	}
	
	/**
	 * Create money object
	 * @param value - value of money
	 * @return Valuable object of money
	 */
	public abstract Valuable createMoney(double value) ;
	
	/**
	 * Create money object from String
	 * @param value - value of money in String
	 * @return Valuable object of money
	 */
	public Valuable createMoney(String value) {
		return this.createMoney(Double.parseDouble(value));
	}
}
