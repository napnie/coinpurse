package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * Greedy strategy for withdraw method in Purse.
 * Require Valuable list to be sort from small to big.
 * @author Nitith Chayakul
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	
	/**
	 * Withdraw the require amount of money with Greedy strategy.
	 * Require valuable list to be sort from small to big.
	 * Assume that amount is more than 0 and is less or equals than Purse balance.
	 * @see WithdrawStrategy#withdraw(double, List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuable) {
		List<Valuable> tempWithdraw = new ArrayList<Valuable>();
    	for(int i=valuable.size()-1 ; i >= 0 ; i--) {
    		if( valuable.get(i).getValue() <= amount ) {
    			tempWithdraw.add(valuable.get(i));
    			amount -= valuable.get(i).getValue();
    		}
    	}
		if( amount > 0 ) return null;
		return tempWithdraw;
	}

}
