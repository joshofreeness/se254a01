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
	*Test values of zero as input, could reveal error depending on implimentation
	**/
    public void testZeroValues(){
	Money money = new Money();
	Money money1 = new Money(0,0);
	Money money2 = new Money(0,0,0);
	assertEquals("$0.00", money.toString());
	assertEquals("$0.00", money1.toString());
	assertEquals("$0.00", money2.toString());
	}


    public void testCompareToLessThan(){
	Money money = new Money(3, 50);
	Money money1 = new Money(3, 45, 32);
	assertEquals(-1, money.compareTo(new Money(5,23)));
	assertEquals(-1, money.compareTo(new Money(5,23, 13)));
	
    }

    public void testCompareToGeaterThan(){
	Money money = new Money(9, 90);
	Money money1 = new Money(10, 32, 15);
	assertEquals(1, money.compareTo(new Money(5,50)));
	assertEquals(1, money1.compareTo(new Money(5,50, 75)));
    }

    public void testCompareToEqual(){
	Money money = new Money(9, 70);
	Money money1 = new Money(10,30,45);
	assertEquals(0, money.compareTo(new Money(9,70)));
	assertEquals(0, money1.compareTo(new Money(10,30,45)));
    }

    public void testCompareToZeroEqual(){
	Money money = new Money();
	assertEquals(0, money.compareTo(new Money()));
    }

    public void testCompareToLessThanZero(){
	Money money = new Money();
	assertEquals(-1, money.compareTo(new Money(3,15)));
	assertEquals(-1, money.compareTo(new Money(3,15,45)));
    }

    public void testCompareToGreaterThanZero(){
	Money money = new Money();
	assertEquals(1, money.compareTo(new Money(-5,23)));
	assertEquals(1, money.compareTo(new Money(-5,23,98)));
    }


    public void testCompareToNegativeLessThan(){
	Money money = new Money(-30, 50);
	Money money1 = new Money(-25,13,45);
	assertEquals(-1, money.compareTo(new Money(-8,25)));
	assertEquals(-1, money1.compareTo(new Money(-8,25,73)));
    }

    public void testCompareNegativeToGeaterThan(){
	Money money = new Money(-50, 50);
	Money money1 = new Money(-49,99,99);
	assertEquals(1, money.compareTo(new Money(-75, 37)));
	assertEquals(1, money1.compareTo(new Money(-75,38,01)));
    }

    public void testCompareToNegativeEqual(){
	Money money = new Money(-8,30);
	assertEquals(0, money.compareTo(new Money(-8,30)));
	assertEquals(0, money.compareTo(new Money(-8,30, 00)));
    }





    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}
