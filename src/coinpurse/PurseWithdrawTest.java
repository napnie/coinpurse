package coinpurse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test for withdraw method in Purse.
 * @author Nitith Chayakul
 *
 */
public class PurseWithdrawTest {
	private Purse purse;
	
	/** Initialize purse with 10 capacity. */
	@Before
	public void setup() {
		purse = new Purse(10);
	}
	
	@Test
	public void greedyTest() {
		initValuable(2,2);
		initValuable(5,2);
		Valuable[] ans = purse.withdraw(9);
		assertNotNull( ans );
		assertEquals( 9.0, getBalance(ans) ,1.0E-10);
		assertEquals(5, purse.getBalance(), 1.0E-10);
	}
	
	@Test
	public void recursiveTest() {
		initValuable( 5,1 );
		initValuable(2, 3);
		purse.setWithdrawStrategy(Purse.RECURSIVE);
		assertArrayEquals( fillCoin(2,3) , purse.withdraw(6) );
		assertEquals(5, purse.getBalance(), 1.0E-10);
	}
	
	@Test
	public void setStrategyTest() {
		initValuable(5, 2);
		initValuable(2, 4);
		
		assertNull( purse.withdraw(8) );
		assertEquals( "Failed withdraw should not chang anything.", 18, purse.getBalance(), 1.0E-10);
		purse.setWithdrawStrategy(Purse.RECURSIVE);
		assertArrayEquals("Recursive strategy should be able to solve this.", fillCoin(2,4) , purse.withdraw(8) );
		assertEquals(10, purse.getBalance(), 1.0E-10);
	}
	
	/**
	 * Get balance from Valuable array.
	 * @param list - array of valuable
	 * @return balance of valuable array
	 */
	private double getBalance(Valuable[] list) {
		double sum = 0;
		for(Valuable coin : list) sum += coin.getValue();
		return sum;
	}
	
	/**
	 * Fill purse with Valuable array.
	 * @param value - value of coin to fill in purse
	 * @param amount - amount of coin to fill in purse
	 */
	private void initValuable(int value, int amount) {
		for(Valuable coin : fillCoin(value, amount)) purse.insert(coin);
	}
	
	/**
	 * Create Valuable array.
	 * @param value - value of coin to fill in array
	 * @param amount - amount of coin to fill in array
	 * @return Valuable array that filled with coin
	 */
	private Valuable[] fillCoin(int value, int amount) {
		Valuable[] valueList = new Valuable[amount];
		for(int i=0 ; i<amount ; i++ ) valueList[i] = new Coin(value);
		return valueList;
	}

}
