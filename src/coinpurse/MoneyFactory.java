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
			ResourceBundle bundle = ResourceBundle.getBundle("moneyFactory");
	    	String factoryclass = bundle.getString("moneyfactory");
	    	if (factoryclass == null) {
	    		factoryclass = "coinpurse.ThaiMoneyFactory";
	    	}
	    	
	    	try {
	    		factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
	    	} catch (ClassCastException cce) {
	    		System.out.println(factoryclass+" is not type MoneyFactory");
	    	} catch (Exception ex) {
	    		System.out.println("Error creating MoneyFactory "+ex.getMessage() );
	    	} if (factory == null) System.exit(1);
		}
		return factory;
	}
	
	/**
	 * Create money object
	 * @param value - value of money
	 * @return Valuable object of money
	 */
	public abstract Valuable createMoney(double value) ;
	
	public abstract String getCurrency() ;
	
	/**
	 * Create money object from String
	 * @param value - value of money in String
	 * @return Valuable object of money
	 */
	public Valuable createMoney(String value) {
		return this.createMoney(Double.parseDouble(value));
	}
}
