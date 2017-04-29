package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * Recursive strategy for withdraw method in Purse.
 * @author Nitith Chayakul
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw the require amount of money with Recursive strategy.
	 * Assume that amount is more than 0 and is less or equals than Purse balance.
	 * @see WithdrawStrategy#withdraw(double, List)
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> valuable) {
		List<Valuable> withdraw = new ArrayList<Valuable>();
		
		// base case
		if( amount == 0 ) return withdraw;
		if( valuable.isEmpty() ) return null;
		
		Valuable first = valuable.get(0);
		List<Valuable> subList = valuable.subList(1, valuable.size() );
		
		// select
		List<Valuable> temp = withdraw(amount-first.getValue() , subList );
		if( temp != null ) {
			withdraw.add(first);
			withdraw.addAll(temp);
			return withdraw;
		}
		// don't select
		temp = withdraw(amount, subList );
		if( temp != null ) {
			withdraw.addAll(temp);
			return withdraw;
		}
		return null;
	}
}
