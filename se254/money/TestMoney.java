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
	* Testing no arguments to see if compiler
	*works in that scenario
	* -----NOTE: Tests of the compiler assume that toString works correctly--------
	**/
    public void testCompilerNoArgs(){
	Money money = new Money();
	assertEquals("$0.00", money.toString());
    }
    
    public void testCompilerPositiveNumber(){
	Money money = new Money(5, 38);
	assertEquals("$5.38", money.toString());
    }

    public void testCompilerNegativeNumber(){
	Money money = new Money(-3, 17);
	assertEquals("-$3.17", money.toString());
    }


    public void testCompilerSingleNegativeError(){
	try{
		Money money = new Money(3, -21);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }

    public void testCompilerDoubleNegativeError(){
	try{
		Money money = new Money(-5, -21);
		fail("should have thrown exception");
	}catch (IllegalArgumentException e){
	}
    }

    public void testCompilerPositiveNumberHundredths(){
	Money money = new Money(18,54,13);
	assertEquals("$18.5413", money.toString());
    }

    public void testCompilerNegativeNumberHundredths(){
	Money money = new Money(-23, 17, 45);
	assertEquals("-$23.1745", money.toString());
    }

    public void testCompilerTrailingZeroHundredths(){
	Money money = new Money(7,64,20);
	assertEquals("$7.642", money.toString());
	Money money1 = new Money(-13, 54, 50);
	assertEquals("-$13.545", money1.toString());
	
    }
    public void testCompilerHundrethNegativeError(){
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
