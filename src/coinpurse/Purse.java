package coinpurse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  A Valuable purse contains valuable.
 *  You can insert valuable, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the valuable purse decides which
 *  valuable to remove.
 *  
 *  @author Nitith Chayakul
 *  @version 2017.02.10
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of Valuable you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    }

    /**
     * Count and return the number of Valuable in the purse.
     * This is the number of Valuable, not their value.
     * @return the number of Valuable in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0;
    	for (Valuable value: money ) sum += value.getValue();
    	return sum; 
    }

    
    /**
     * Return the capacity of the Valuable purse.
     * @return the capacity
     */
    public int getCapacity() { return capacity; }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if ( money.size() == capacity ) return true;
        return false;
    }

    /** 
     * Insert a Valuable into the purse.
     * The coin is only inserted if the purse has space for it
     * and the Valuable has positive value.  No worthless Valuable!
     * @param value is a Valuable object to insert into purse
     * @return true if Valuable inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.
    	if ( isFull() ) return false;
    	if ( value.getValue() <= 0 ) return false;
    	
    	money.add(value);
    	
    	Collections.sort(money);
    	return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
	   /*
		* See lab sheet for outline of a solution, 
		* or devise your own solution.
		*/
    	if ( amount < 0 ) return null;
    	if ( amount > getBalance() ) return null;
    	
		List<Valuable> tempWithdraw = new ArrayList<Valuable>();
    	for (int i=money.size()-1 ; i>=0 ; i--) {
    		if ( money.get(i).getValue() <= amount ) {
    			tempWithdraw.add(money.get(i));
    			amount -= money.get(i).getValue();
    		}
    	}
    	
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a Valuable.
		if ( amount > 0 )
		{	// failed. Don't change the contents of the purse.
			return null;
		}

		// Success.
		// Remove the Valuable you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		for (Valuable remove : tempWithdraw) money.remove( remove );
		Collections.sort(money);
		Valuable[] withdraw = new Coin[tempWithdraw.size()];
		tempWithdraw.toArray(withdraw);
        return withdraw;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     * @return String representation of the purse
     */
    @Override
    public String toString() {
    	DecimalFormat numFormat = new DecimalFormat("0.##");
    	return String.format("%d coins with value %s",money.size(), numFormat.format(this.getBalance()) );
    }

}