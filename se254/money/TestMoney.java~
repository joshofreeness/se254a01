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

//Test compareTo-----------------------------------------

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


//Test Multiply ----------------------------------------------
    public void testMultiplyPositive(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(2);
	assertEquals("$6.00",money1.toString());
    }
    public void testMultiplyNegative(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(-2);
	assertEquals("-$6.00",money1.toString());
    }

    public void testMultiplyPositiveDecimal(){
	Money money = new Money(3,00);
	Money money1 = money.multiply(4.5);
	assertEquals("$13.50",money1.toString());
    }

   public void testMultiplyPositiveRoundUp(){
	Money money = new Money(4,55,32);
	Money money1 = money.multiply(1.02);
	assertEquals("$4.6443",money1.toString());
    }

  public void testMultiplyPositiveRoundDown(){
	Money money = new Money(7,56,18);
	Money money1 = money.multiply(1.01);
	assertEquals("$7.6374",money1.toString());
    }

   public void testMultiplyNegativeRoundUp(){
	Money money = new Money(-4,55,32);
	Money money1 = money.multiply(1.02);
	assertEquals("-$4.6443",money1.toString());
    }

  public void testMultiplyNegativeRoundDown(){
	Money money = new Money(-7,56,18);
	Money money1 = money.multiply(1.01);
	assertEquals("-$7.6374",money1.toString());
    }

  public void testMultiplyPositiveRoundHalfwayMark(){
	Money money = new Money(7,00,01);
	Money money1 = money.multiply(1.000022);
	assertEquals("$7.0003",money1.toString());
    }

  public void testMultiplyNegativeRoundHalfwayMark(){
	Money money = new Money(7,00,01);
	Money money1 = money.multiply(-1.000022);
	assertEquals("-$7.0003",money1.toString());
    }


//Test add ---------------------------------------------------------
  public void testAddNull(){
	Money money = new Money(7,60);
	Money money1 = null;
	try{
	    Money money2 =money.add(money1);
	    fail("Should have failed as Null was passed");
	}catch (IllegalArgumentException e){
	}
    }

  public void testAddPositives(){
	Money money = new Money(4,60);
	Money money1 = new Money(3,50);
	Money moneyFin = money.add(money1);
	assertEquals("$8.10",moneyFin.toString());
    }


  public void testAddZero(){
	Money moneyZ = new Money();
	Money money = new Money(7,60);
	Money moneyFin1 = money.add(moneyZ);
	Money moneyFin2 = moneyZ.add(moneyZ);
	assertEquals("$7.60",moneyFin1.toString());
	assertEquals("$0.00",moneyFin2.toString());
    }

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


    public void testAddThousandthsPositive(){
	Money money1 = new Money();
	Money money2 = new Money(0,00,13);
	Money money3 = new Money(3,45,23);
	Money moneyFin1 = money1.add(money2);
	Money moneyFin2 = money2.add(money3);
	assertEquals("$0.0013",moneyFin1.toString());
	assertEquals("$3.4536",moneyFin2.toString());

    }

    public void testAddThousandthsNegativeZero(){
	Money money1 = new Money();
	Money money3 = new Money(-4,15,12);
	Money moneyFin = money3.add(money1);
	Money moneyFin1 = money1.add(money3);
	assertEquals("-$4.1512",moneyFin.toString());
	assertEquals("-$4.1512",moneyFin.toString());

    }

    public void testAddThousandthsNegativePositive(){
	Money money2 = new Money(3,45,23);
	Money money3 = new Money(-4,15,12);
	Money moneyFin = money2.add(money3);
	Money moneyFin1 = money3.add(money2);
	assertEquals("-$0.6989",moneyFin.toString());
	assertEquals("-$0.6989",moneyFin1.toString());

    }
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
	
	



//Test Equals-------------------------------------------------


    public void testEqualsPositive(){
	Money money = new Money(3, 17);
	Money money1 = new Money(3, 17);
	assertTrue(money.equals(money1));
    }

    public void testEqualsNegative(){
	Money money = new Money(-4,32);
	Money money1 = new Money(-4,32);
	assertTrue(money.equals(money1));
    }

    public void testEqualsZero(){
	Money money = new Money(0,00);
	Money money1 = new Money();
	assertTrue(money.equals(money1));
    }

     public void testEqualsNull(){
	Money money = new Money(0,00);
	Money money1 = null;
	assertFalse(money.equals(money1));
    
    }

    public void testEqualPositiveNegative(){
	Money money1 = new Money(13,75);
	Money money2 = new Money(-13,75);
	assertFalse(money1.equals(money2));
	assertFalse(money2.equals(money1));

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
