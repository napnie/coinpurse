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
	static List<Coin> filterByCurrency(List<Coin> coinlist,String currency) {
		List<Coin> selCoins = new ArrayList<Coin>();
		for (Coin coin : coinlist){
			if ( coin.getCurrency().equals(currency) ) selCoins.add(coin);
		}
		return selCoins;
	}
	
	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	static void sortByCurrency(List<Coin> coins) {
		Comparator<Coin> byCurrency = new CompareByCurrency();
		Collections.sort(coins,byCurrency);
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	static void sumByCurrency(List<Coin> coins) {
		List<String> currencys = new ArrayList<String>();
		sortByCurrency(coins);
		for (Coin coin : coins) {
			if ( !currencys.contains( coin.getCurrency() ) ) {
				currencys.add( coin.getCurrency() );
			}
		}
		for (String currency : currencys) {
			List<Coin> filtered = filterByCurrency(coins,currency);
			double sum = 0;
			for (Coin coin : filtered) {
				sum += coin.getValue();
			}
			System.out.println(String.format("Sum : %.2f %s",sum,currency));
		}
		
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Coin> rupees = filterByCurrency(coins, currency);
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
	public static List<Coin> makeInternationalCoins( ) {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Coin> makeCoins(String currency, double ... values) {
		List<Coin> list = new ArrayList<Coin>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
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
class CompareByCurrency implements Comparator<Coin> {
	
	/**
	 * Compare the order of coin0 and coin1 by their currency.
	 * @param coin0 is first Coin object that need to compare
	 * @param coin1 is second Coin object that need to compare
	 * @return order between coin0 and coin1
	 */
	@Override
	public int compare(Coin coin0, Coin coin1) {
		if ( coin0 == null && coin1 ==null ) return 0;
		if ( coin0 == null ) return -1;
		if ( coin1 == null ) return 1;
		if ( coin0.getCurrency().length() < coin1.getCurrency().length() ) return -1;
		if ( coin0.getCurrency().length() > coin1.getCurrency().length() ) return 1;
		if ( coin0.getCurrency().equalsIgnoreCase(coin1.getCurrency()) ) return coin0.compareTo(coin1);
		return coin0.getCurrency().compareToIgnoreCase(coin1.getCurrency());
	}
}