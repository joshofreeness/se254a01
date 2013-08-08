package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Joshua Free, jfre553)
 **/

import junit.framework.TestCase;

public class TestMoney extends TestCase {



//Test Constructor -------------------------------------------
	/**
	* Testing no arguments to see if constructor
	*works in that scenario
	* -----NOTE: Tests of the constructor assume that toString 			works correctly--------
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
	Money money1 = new Money(0,13);
	Money money2 = new Money(0,00,25);
	assertEquals("$5.38", money.toString());
	assertEquals("$0.13", money1.toString());
	assertEquals("$0.0025", money2.toString());
    }

	/**
	*Check constructor with negative numbers
	**/
    public void testConstructorNegativeNumber(){
	Money money = new Money(-3, 17);
	assertEquals("-$3.17", money.toString());
    }

    public void testConstructorNegativeNumberAfterFirst(){
	Money money = new Money(0,-23);
	assertEquals("-$0.23", money.toString());
	Money money1 = new Money(0,00,-13);
	assertEquals("-$0.0013", money1.toString());
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
	Money money = new Money(-4, 15, 12);
	assertEquals("-$4.1512", money.toString());
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
	try{
		Money money = new Money(5, -21,-13);
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


	/**
	*Tests whether an exception wil be thrown when input is out
	* of range
	**/
    public void testConstructorOutOfRange(){
	try{
		Money money = new Money(5, 211);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
	try{
		Money money = new Money(9, 3,112);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
	try{
		Money money = new Money(0, 231,112);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }
	/**
	*Test constructing large numbers(within the range of int)
	**/
    public void testConstructorLargeNumbers(){
	Money money = new Money(1000000000,00);
	Money money1 = new Money(2000000000,00);
	assertEquals("$1000000000.00", money.toString());
	assertEquals("$2000000000.00", money1.toString());
    }

//Test compareTo-----------------------------------------
	
	/**
	*Compare to a value that the original is less than(positive)
	**/
    public void testCompareToLessThan(){
	Money money = new Money(3, 50);
	Money money1 = new Money(3, 45, 32);
	assertEquals(-1, money.compareTo(new Money(5,23)));
	assertEquals(-1, money.compareTo(new Money(5,23, 13)));
	
    }
	/**
	*Compare to a value that the original is greater than 	
	*(positive)
	**/
    public void testCompareToGeaterThan(){
	Money money = new Money(9, 90);
	Money money1 = new Money(10, 32, 15);
	assertEquals(1, money.compareTo(new Money(5,50)));
	assertEquals(1, money1.compareTo(new Money(5,50, 75)));
    }

	/**
	*Tests two objects witht the same value to see it will
	*return the right value
	**/
    public void testCompareToEqual(){
	Money money = new Money(9, 70);
	Money money1 = new Money(10,30,45);
	assertEquals(0, money.compareTo(new Money(9,70)));
	assertEquals(0, money1.compareTo(new Money(10,30,45)));
    }
	/**
	*Test if it recognizes two zeros as equal value
	**/
    public void testCompareToZeroEqual(){
	Money money = new Money();
	assertEquals(0, money.compareTo(new Money(0,00)));
    }

	/**
	*Tests if it recignizes numbers in relation to zero as
	*a value that it is less than
	**/
    public void testCompareToLessThanZero(){
	Money money = new Money();
	assertEquals(-1, money.compareTo(new Money(3,15)));
	assertEquals(-1, money.compareTo(new Money(3,15,45)));
    }
	/**
	*Tests if it recignizes numbers in relation to zero as
	*a value that it is greater than
	**/
    public void testCompareToGreaterThanZero(){
	Money money = new Money();
	assertEquals(1, money.compareTo(new Money(-5,23)));
	assertEquals(1, money.compareTo(new Money(-5,23,98)));
    }

	/**
	*Tests two negative numbers compared to each other(less than)
	**/
    public void testCompareToNegativeLessThan(){
	Money money = new Money(-30, 50);
	Money money1 = new Money(-25,13,45);
	assertEquals(-1, money.compareTo(new Money(-8,25)));
	assertEquals(-1, money1.compareTo(new Money(-8,25,73)));
    }
	/**
	*Tests two negative numbers compared to each other(greater 
	*than)
	**/
    public void testCompareNegativeToGeaterThan(){
	Money money = new Money(-50, 50);
	Money money1 = new Money(-49,99,99);
	assertEquals(1, money.compareTo(new Money(-75, 37)));
	assertEquals(1, money1.compareTo(new Money(-75,38,01)));
    }
	/**
	*Test if two negative numbers can be concidered equal
	**/
    public void testCompareToNegativeEqual(){
	Money money = new Money(-8,30);
	assertEquals(0, money.compareTo(new Money(-8,30)));
	assertEquals(0, money.compareTo(new Money(-8,30, 00)));
    }
	/**
	*Tests if two positive numbers with a very small difference
	*are stil concidered different
	**/
    public void testCompareToPositiveSmall(){
	Money money1 = new Money(3,15,78);
	assertEquals(1, money1.compareTo(new Money(3,15,77)));
	assertEquals(-1, money1.compareTo(new Money(3,15,79)));
	
    }
	/**
	*Test if two negative numbers with a small difference
	*are still concidered different
	**/
    public void testCompareToNegativeSmall(){
	Money money1 = new Money(-24,75,02);
	assertEquals(1, money1.compareTo(new Money(-24,75,03)));
	assertEquals(-1, money1.compareTo(new Money(-24,75,01)));
	
    }


//Test Multiply ----------------------------------------------

	/**
	*Test a positive multiply with positive number
	**/
    public void testMultiplyPositive(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(2);
	assertEquals("$6.00",money1.toString());
    }

	/**
	*Test a negative multiply with positive number
	**/
    public void testMultiplyNegative(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(-2);
	assertEquals("-$6.00",money1.toString());
    }


	/**
	*Test a positive multiply with a decimal with a positive number
	**/
    public void testMultiplyPositiveDecimal(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(4.5);
	assertEquals("$13.50",money1.toString());
    }


	/**
	*Test a positive multiply with a round up
	**/
   public void testMultiplyPositiveRoundUp(){
	Money money = new Money(4,55,32);
	Money money1 = money.multiply(1.02);
	assertEquals("$4.6443",money1.toString());
    }

	/**
	*Test a positive multiply with a round down
	**/
  public void testMultiplyPositiveRoundDown(){
	Money money = new Money(7,56,18);
	Money money1 = money.multiply(1.01);
	assertEquals("$7.6374",money1.toString());
    }

	/**
	*Test a negative multiply with a round up
	**/
   public void testMultiplyNegativeRoundUp(){
	Money money = new Money(-4,55,32);
	Money money1 = money.multiply(1.02);
	assertEquals("-$4.6443",money1.toString());
    }

	/**
	*Test a negative multiply with a round down
	**/
  public void testMultiplyNegativeRoundDown(){
	Money money = new Money(-7,56,18);
	Money money1 = money.multiply(1.01);
	assertEquals("-$7.6374",money1.toString());
    }

	/**
	*Make sure to cover the halfway mark (positive)
	**/
  public void testMultiplyPositiveRoundHalfwayMark(){
	Money money = new Money(7,00,01);
	Money money1 = money.multiply(1.000022);
	assertEquals("$7.0003",money1.toString());
    }

	/**
	*test the halfway mark on a negative number
	**/
  public void testMultiplyNegativeRoundHalfwayMark(){
	Money money = new Money(7,00,01);
	Money money1 = money.multiply(-1.000022);
	assertEquals("-$7.0003",money1.toString());
    }


//Test add ---------------------------------------------------------

	/**
	*Check for error when adding null to an object
	**/
  public void testAddNull(){
	Money money = new Money(7,60);
	Money money1 = null;
	try{
	    Money money2 =money.add(money1);
	    fail("Should have failed as Null was passed");
	}catch (IllegalArgumentException e){
	}
    }

	/**
	*Add two positive numbers together
	**/
  public void testAddPositives(){
	Money money = new Money(4,60);
	Money money1 = new Money(3,50);
	Money moneyFin = money.add(money1);
	assertEquals("$8.10",moneyFin.toString());
    }


	/**
	*Add a number to zero and add zero to itself
	**/
  public void testAddZero(){
	Money moneyZ = new Money();
	Money money = new Money(7,60);
	Money moneyFin1 = money.add(moneyZ);
	Money moneyFin2 = moneyZ.add(moneyZ);
	assertEquals("$7.60",moneyFin1.toString());
	assertEquals("$0.00",moneyFin2.toString());
    }

	/**
	*Test adding negatives and also adding negatives to zero
	**/
  public void testAddNegatives(){
	Money money = new Money(-4,60);
	Money money1 = new Money(-3,50);
	Money moneyZ = new Money();
	Money moneyP = new Money(13,75);
	Money moneyFin1 = money.add(money1);
	Money moneyFin2 = money.add(moneyZ);
	Money moneyFin3 = moneyZ.add(money1);
	Money moneyFin4 = money.add(moneyP);
	assertEquals("-$8.10",moneyFin1.toString());
	assertEquals("-$4.60",moneyFin2.toString());
	assertEquals("-$3.50",moneyFin3.toString());
	assertEquals("$9.15",moneyFin4.toString());
    }

	/**
	*Check that the addition works on the smaller increments
	**/
    public void testAddThousandthsPositive(){
	Money money1 = new Money();
	Money money2 = new Money(0,00,13);
	Money money3 = new Money(3,45,23);
	Money moneyFin1 = money1.add(money2);
	Money moneyFin2 = money2.add(money3);
	assertEquals("$0.0013",moneyFin1.toString());
	assertEquals("$3.4536",moneyFin2.toString());

    }

	/**
	*Test small increments with negative numbers
	**/
    public void testAddThousandthsNegativeZero(){
	Money money1 = new Money();
	Money money3 = new Money(-4,15,12);
	Money moneyFin = money3.add(money1);
	Money moneyFin1 = money1.add(money3);
	assertEquals("-$4.1512",moneyFin.toString());
	assertEquals("-$4.1512",moneyFin.toString());

    }

	/**
	*Add 1000ths together one being positive and one negative
	**/
    public void testAddThousandthsNegativePositive(){
	Money money2 = new Money(3,45,23);
	Money money3 = new Money(-4,15,12);
	Money moneyFin = money2.add(money3);
	Money moneyFin1 = money3.add(money2);
	assertEquals("-$0.6989",moneyFin.toString());
	assertEquals("-$0.6989",moneyFin1.toString());

    }

	/**
	*Attempt to find any corener cases if the exist
	**/
    public void testAddCornerCases(){
	Money money1 = new Money(9,99,99);
	Money money2 = new Money(0,00,01);
	Money money3 = new Money(-9,99,99);
	Money money4 = new Money(0,00,-01);
	Money moneyFin1 = money1.add(money2);
	Money moneyFin2 = money4.add(money3);
	Money moneyFin3 = money3.add(money2);
	Money moneyFin4 = money1.add(money3);
	assertEquals("$10.00",moneyFin1.toString());
	assertEquals("-$10.00",moneyFin2.toString());
	assertEquals("-$9.9998",moneyFin3.toString());
	assertEquals("$0.00",moneyFin4.toString());
    }

	/**
	*Adding large numbers together (Not to large as to overflow 
	*int(already tested constructor))
	**/
    public void testAddLargeNumbers(){

	Money money1 = new Money(1000000000,00);
	Money money2 = new Money(1000000000,00);
	Money moneyfin = money1.add(money2);
	assertEquals("$2000000000.00",moneyfin.toString());
    }
	
	



//Test Equals-------------------------------------------------

	/**
	*Confirm two positive equal numbers are seen as equal
	**/
    public void testEqualsPositive(){
	Money money = new Money(3, 17);
	Money money1 = new Money(3, 17);
	assertTrue(money.equals(money1));
    }

	/**
	*Confirm two negative numbers are seen as equal
	**/
    public void testEqualsNegative(){
	Money money = new Money(-4,32);
	Money money1 = new Money(-4,32);
	assertTrue(money.equals(money1));
    }

	/**
	*Test zero can be seen as equal even when called from different
	*constructors
	**/
    public void testEqualsZero(){
	Money money = new Money(0,00);
	Money money1 = new Money();
	assertTrue(money.equals(money1));
    }

	/**
	*Test that error handling has been handled by seeing if it 
	*equals null
	**/
     public void testEqualsNull(){
	Money money = new Money(0,00);
	Money money1 = null;
	assertFalse(money.equals(money1));
    
    }

	/**
	*Test if positive and negative numbers are seen as equal
	**/
    public void testEqualPositiveNegative(){
	Money money1 = new Money(13,75);
	Money money2 = new Money(-13,75);
	assertFalse(money1.equals(money2));
	assertFalse(money2.equals(money1));

    }

	/**
	*Test if numbers with small difference are concidered equal
	*both positive and negative
	**/
    public void testEqualSmallDifference(){
	Money money1 = new Money(45,13,56);
	Money money2 = new Money(45,13,55);
	Money money3 = new Money(-45,73,97);
	Money money4 = new Money(-45,73,96);
	assertFalse(money1.equals(money2));
	assertFalse(money2.equals(money1));
	assertFalse(money3.equals(money4));
	assertFalse(money4.equals(money3));
    }





//----------Finished-----------------------------------------

    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}
