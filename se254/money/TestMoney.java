package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Joshua Free, jfre553)
 **/

import junit.framework.TestCase;

public class TestMoney extends TestCase {

    // Your tests here.
	/**
	* Testing no arguments to see if constructor
	*works in that scenario
	* -----NOTE: Tests of the constructor assume that toString works correctly--------
	**/
    public void testConstructorNoArgs(){
	Money money = new Money();
	assertEquals("$0.00", money.toString());
    }
	/**
	*Check that constructor works with positive numbers
	**/
    public void testConstructorPositiveNumber(){
	Money money = new Money(5, 38);
	assertEquals("$5.38", money.toString());
    }

	/**
	*Check constructor with negative numbers
	**/
    public void testConstructorNegativeNumber(){
	Money money = new Money(-3, 17);
	assertEquals("-$3.17", money.toString());
    }

	
	/**
	*Check the first type of error that can occur and should be 
	*accounted for in code (a negative number after an initial positive number)
	**/
    public void testConstructorSingleNegativeError(){
	try{
		Money money = new Money(3, -21);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }


	/**
	*Checks second type of error that should be accounted for (two negative numbers input)
	**/
    public void testConstructorDoubleNegativeError(){
	try{
		Money money = new Money(-5, -21);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }

	
	/**
	*Check the third part of the constructor that handles 100ths. With correct positive
	* numbers as input
	**/
    public void testConstructorPositiveNumberHundredths(){
	Money money = new Money(18,54,13);
	assertEquals("$18.5413", money.toString());
    }

	
	/**
	*Check 100ths section with negative numbers
	**/
    public void testConstructorNegativeNumberHundredths(){
	Money money = new Money(-23, 17, 45);
	assertEquals("-$23.1745", money.toString());
    }
	
	/**
	*Check that tailing hundredths are handled correctly (more testing toString than constructor)
	**/
    public void testConstructorTrailingZeroHundredths(){
	Money money = new Money(7,64,20);
	assertEquals("$7.642", money.toString());
	Money money1 = new Money(-13, 54, 50);
	assertEquals("-$13.545", money1.toString());
	
    }

	/**
	*Check hundredths error with negative numbers (all combinations)
	**/
    public void testConstructorHundrethNegativeError(){
	try{
		Money money = new Money(-5, 21,-13);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}

	try{
		Money money1 = new Money(-5, -21,13);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
	try{
		Money money = new Money(5, 21,-13);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }







    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}