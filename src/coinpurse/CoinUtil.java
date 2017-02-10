package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A collections of utility method of Coin for practice using List and Comparator.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class CoinUtil {
	
	/**
	 * Return a List of Coins that contains only the coins from coinlist (the parameter)
	 * that have same currency as the currency parameter.
	 * @param coinlist is list of coin to be filter
	 * @param currency is currency to filter coinlist
	 * @return List of coins in coinlist that has the same currency as currency parameter
	 */
	static List<Coin> filterByCurrency(List<Coin> coinlist,String currency) {
		List<Coin> selCoins = new ArrayList<Coin>();
		for (Coin coin : coinlist){
			if ( coin.getCurrency().equals(currency) ) selCoins.add(coin);
		}
		return selCoins;
	}
	
	/**
	 * Sort the coins by currency. You can't use the Coin's own compareTo because
	 * that order the coins by value.
	 * @param coins is list of coins that need to be sort
	 */
	static void sortByCurrency(List<Coin> coins) {
		Comparator<Coin> byCurrency = new CompareByCurrency();
		Collections.sort(coins,byCurrency);
	}
	
	/**
	 * Sum the value of coins for each currency that appears in the coins list.
	 * Print the sum for each currency on a separate line.
	 * @param coins is list of coins that need to sum the value for each currency
	 */
	static void sumByCurrency(List<Coin> coins) {
		List<String> currencys = new ArrayList<String>();
		sortByCurrency(coins);
		for (Coin coin : coins) {
			if ( !currencys.contains(coin.getCurrency()) ) {
				currencys.add(coin.getCurrency());
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
	 * Contain a code to test method above.
	 * @param arg are not use
	 */
	public static void main (String [] arg) {
		// make a list of coins
		List<Coin> coins = new ArrayList<Coin>();
		Coin oneBaht = new Coin(1);
		Coin fiveBaht = new Coin(5);
		Coin tenBaht = new Coin(10);
		Coin oneDollar = new Coin(1,"Dollar");
		Coin fiveDollar = new Coin(5,"Dollar");
		Coin tenDollar = new Coin(10,"Dollar");
		for (int i=0 ; i<3 ; i++) {
			coins.add(oneDollar);
			coins.add(fiveBaht);
			coins.add(oneBaht);
			coins.add(tenDollar);
			coins.add(fiveDollar);
			coins.add(tenBaht);
		} 
		coins.add(new Coin(2,"Yen"));
		
		// print put all the coins in the list
		System.out.println(Arrays.toString( coins.toArray() ));
		// print the result of filterByCurrency method
		System.out.println(Arrays.toString( filterByCurrency(coins,"Dollar").toArray() ));
		// test sortByCurrency method and print the result
		sortByCurrency(coins);
		System.out.println(Arrays.toString( coins.toArray() ));
		// test sumByCurrency method
		sumByCurrency(coins);
	}
}
