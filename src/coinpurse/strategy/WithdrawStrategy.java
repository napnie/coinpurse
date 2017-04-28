package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Strategy Interface for withdraw method in Purse.
 * @author Nitith Chayakul
 *
 */
public interface WithdrawStrategy {
	
	/**
	 * Withdraw valuable from Purse.
	 * @param amount - money that want to withdraw
	 * @param valuable - list of valuable in purse
	 * @return list of withdraw valuable, null if unable to withdraw
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> valuable);
}
