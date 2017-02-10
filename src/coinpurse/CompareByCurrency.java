package coinpurse;

import java.util.Comparator;

/**
 * Comparator to compare order of the Coin object by their currency.
 * 
 * @author Nitith Chayakul
 * @version 2017.02.10
 */
public class CompareByCurrency implements Comparator<Coin> {
	
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
		if ( coin0.getCurrency().equals(coin1.getCurrency()) ) return coin0.compareTo(coin1);
		return coin0.getCurrency().compareToIgnoreCase(coin1.getCurrency());
	}
}
