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
		return withdrawHelp(amount, valuable, null);
	}
	
	/**
	 * Helper method for withdraw.
	 * @param amount - money that want to withdraw
	 * @param valuable - list of valuable in the Purse
	 * @param withdraw - list of possible valuable to withdraw
	 * @return list of valuable to withdraw, null if unable to withdraw
	 */
	private List<Valuable> withdrawHelp(double amount, List<Valuable> valuable, ArrayList<Valuable> withdraw) {
		if( withdraw == null ) withdraw = new ArrayList<Valuable>();
//		System.out.printf("%f %s %s \n",amount,Arrays.toString(valuable.toArray()),Arrays.toString(withdraw.toArray()));
		if(amount == 0) return withdraw;
		if( valuable.isEmpty() ) return null;
		Valuable first = valuable.get(0);
		
		List<Valuable> anwser;
		
		// don't select
		anwser = withdrawHelp(amount, valuable.subList(1, valuable.size() ), withdraw);
		if( anwser != null ) {
			return anwser ;
		}
		
		// select
		if( amount >= first.getValue() ) {
			@SuppressWarnings("unchecked")
			ArrayList<Valuable> temp = (ArrayList<Valuable>) withdraw.clone();
			temp.add(first);
			anwser = withdrawHelp(amount-first.getValue(), valuable.subList(1, valuable.size() ), temp);
			if( anwser != null ) {
				return anwser;
			}
		}
		
		return null;
	}
	
}
