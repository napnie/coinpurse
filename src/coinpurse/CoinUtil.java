package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.11
 */
public class CoinUtil {
	
	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	static List<Valuable> filterByCurrency(List<Valuable> coinlist,String currency) {
		List<Valuable> selCoins = new ArrayList<Valuable>();
		for (Valuable coin : coinlist){
			if ( coin.getCurrency().equals(currency) ) selCoins.add(coin);
		}
		return selCoins;
	}
	
	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	static void sortByCurrency(List<Valuable> coins) {
		Comparator<Valuable> byCurrency = new CompareByCurrency();
		Collections.sort(coins,byCurrency);
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	static void sumByCurrency(List<Valuable> moneys) {
//		List<String> currencys = new ArrayList<String>();
//		sortByCurrency(coins);
//		for (Valuable coin : coins) {
//			if ( !currencys.contains( coin.getCurrency() ) ) {
//				currencys.add( coin.getCurrency() );
//			}
//		}
//		for (String currency : currencys) {
//			List<Valuable> filtered = filterByCurrency(coins,currency);
//			double sum = 0;
//			for (Valuable coin : filtered) {
//				sum += coin.getValue();
//			}
//			System.out.println(String.format("Sum : %.2f %s",sum,currency));
//		}
		
		Map<String, Double> sum = new HashMap<String, Double>();
		for (Valuable money : moneys) {
			String currency = money.getCurrency();
			if ( sum.containsKey( currency ) ) {
				sum.put(currency,money.getValue()+sum.get(currency));
			} else {
				sum.put(currency, 0.0);
			}
		}
		for (String currency : sum.keySet() ) {
			System.out.println(String.format("Sum : %.2f %s",sum.get(currency),currency));
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List<Valuable> items, String separator) {
		Iterator<Valuable> iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}

/**
 * Comparator to compare order of the Coin object by their currency.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.11
 */
class CompareByCurrency implements Comparator<Valuable> {
	
	/**
	 * Compare the order of coin0 and coin1 by their currency.
	 * @param coin0 is first Coin object that need to compare
	 * @param coin1 is second Coin object that need to compare
	 * @return order between coin0 and coin1
	 */
	@Override
	public int compare(Valuable value0, Valuable value1) {
		if ( value0 == null && value1 ==null ) return 0;
		if ( value0 == null ) return -1;
		if ( value1 == null ) return 1;
		if ( value0.getCurrency().length() < value1.getCurrency().length() ) return -1;
		if ( value0.getCurrency().length() > value1.getCurrency().length() ) return 1;
		if ( value0.getCurrency().equalsIgnoreCase(value1.getCurrency()) ) return value0.compareTo(value1);
		return value0.getCurrency().compareToIgnoreCase(value1.getCurrency());
	}
}