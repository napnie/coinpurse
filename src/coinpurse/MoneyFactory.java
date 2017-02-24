package coinpurse;

import java.util.ResourceBundle;

/**
 * 
 * @author Nitith Chayakul
 *
 */
abstract public class MoneyFactory {
	/** attribute to return in getInstance method */
	private static MoneyFactory factory = null;
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("moneyFactory");
	private static String factoryclass = bundle.getString("moneyfactory");
	
	
	
	/**
	 * Constructor
	 */
	protected MoneyFactory() {}
	
	/**
	 * 
	 * @return
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
	 * 
	 * @param value
	 * @return
	 */
	public abstract Valuable createMoney(double value) ;
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public Valuable createMoney(String value) {
		return this.createMoney(Double.parseDouble(value));
	}
}
