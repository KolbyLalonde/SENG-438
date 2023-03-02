/*
 * Author: Kolby and Siddharth
 * SENG 438 Assignment #2
 * org.jfree.data.Range testing method combine
 */

package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
	
	// Creating multiple Range objects for testing purposes
	// Kolby's Test Example Ranges
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRangeCombine;
    private Range exampleRangeNull;

    //Siddharth's Test Example Ranges
    private Range exampleRange5;
    private Range exampleRange6;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	
    	// Declaring values for example Range objects
    	exampleRange1 = new Range(5.0, 10.0);
    	exampleRange2 = new Range(-5.0, 5.0);
    	exampleRange3 = new Range(8.0, 15.0);
    	exampleRange4 = new Range(-5.5, 11.1);
    	exampleRange5 = new Range(5.0,5.0);
    	exampleRange6 = new Range(-10.0,-5.0);
    }
    
    
    ////////////////////////////
    /* Created By: Kolby 
     * Testing Method: combine */
    ////////////////////////////
    
    /*
     * Explanation:
     * This tests two ranges which are disjointed where the larger range 
     * is the first input parameter to the combine method
     */
    @Test
    public void combineDistjointedRangesLargeFirst() {
    	// Combine Example Ranges 3 and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRange3, exampleRange2);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with disjointed ranges where larger range is first");
    	}
    	Range expected  = new Range(-5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges which are disjointed where the smaller range 
     * is the first input parameter to the combine method
     */
    @Test
    public void combineDistjointedRangesSmallFirst() {
    	// Combine Example Ranges 2 and 3
    	try {
    		exampleRangeCombine = Range.combine(exampleRange2, exampleRange3);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with disjointed ranges where smaller range is first");
    	}
    	Range expected  = new Range(-5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges which are overlapping where the smaller range 
     * is the first input parameter to the combine method
     */
    @Test
    public void combineOverlapingRangesSmallFirst() {
    	// Combine Example Ranges 1 and 3
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange3);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with overlapping ranges where smaller range is first");
    	}
    	Range expected  = new Range(5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges which are overlapping where the larger range 
     * is the first input parameter to the combine method
     */
    @Test
    public void combineOverlapingRangesLargeFirst() {
    	// Combine Example Ranges 3 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange3, exampleRange1);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with overlapping ranges where larger range is first");
    	}
    	Range expected  = new Range(5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests ranges which are the exact same
     */
    @Test
    public void combineSameRanges() {
    	// Combine Example Ranges 1 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange1);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with both the same ranges");
    	}
        assertEquals("The combine of the same ranges", exampleRange1, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests ranges which are the both null
     */
    @Test
    public void combineNullRanges() {
    	// Combine Example Ranges null and null
    	try {
    		exampleRangeCombine = Range.combine(exampleRangeNull, exampleRangeNull);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with both null ranges");
    	}
        assertEquals("The combine of null range 1 with nul range 2", null, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges where the first parameter to combine is null
     * and the second parameter to combine is valid
     */
    @Test
    public void combineNullRangeOne() {
    	// Combine Example Ranges null and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRangeNull, exampleRange2);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with null range one");
    	}
    	Range expected  = new Range(-5.0, 5.0);
        assertEquals("The combine of null range 1 with range 2",  expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges where the first parameter to combine is valid
     * and the second parameter to combine is null
     */
    @Test
    public void combineNullRangeTwo() {
    	// Combine Example Ranges 1 and null
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRangeNull);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with null range two");
    	}
    	Range expected  = new Range(5.0, 10.0);
        assertEquals("The combine of range 1 with null range 2",  expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges where the first parameter to combine is larger
     * and the second parameter to combine is smaller. 
     * The ranges connect at their boundary.
     */
    @Test
    public void combineLargerRangeOne() {
    	// Combine Example Ranges 1 and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with smaller range one");
    	}
    	Range expected  = new Range(-5.0, 10.0);
        assertEquals("The combine of larger range 1 with smaller range 2",  expected, exampleRangeCombine);
    }
    
    /*
     * Explanation:
     * This tests two ranges where the first parameter to combine is smaller
     * and the second parameter to combine is larger. 
     * The ranges connect at their boundary.
     */
    @Test
    public void combineSmallerRangeOne() {
    	// Combine Example Ranges 2 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange2, exampleRange1);
    	}catch(Exception e){
    		// if combine method throws exception fail test
    		fail("combine method failed with smaller range one");
    	}
    	Range expected  = new Range(-5.0, 10.0);
        assertEquals("The combine of smaller range 1 with larger range 2",  expected, exampleRangeCombine);
    }
    
    ////////////////////////////
    /* Created By: Kolby 
     * Testing Method: contains */
    ////////////////////////////
  
    
    /*
     * Explanation:
     * This tests the contains method on value that is inside the range.
     */
    @Test
    public void containsValueInRange() {
    	// Result of true expected
        assertTrue("The value 1.0 not contianed in range -5.5 to 11.1", exampleRange4.contains(1.0));
    }
    
    /*
     * Explanation:
     * This tests the contains method on value that is above the range.
     */
    @Test
    public void containsValueAboveRange() {
    	// Result of false expected
        assertFalse("The value 55.5 is contianed in range -5.5 to 11.1", exampleRange4.contains(55.5));
    }
    
    /*
     * Explanation:
     * This tests the contains method on value that is below the range.
     */
    @Test
    public void containsValueBelowRange() {
    	// Result of false expected
        assertFalse("The value -23.4 is contianed in range -5.5 to 11.1", exampleRange4.contains(-23.4));
    }
  
    	
	    
	    ////////////////////////////
	    /* Created By: Siddharth
	     * Testing Method: getLength */
	    ////////////////////////////
    
	
	 @Test
	 public void getLengthPositiveRange() {
	   double length = exampleRange1.getLength();
	   assertEquals(5, length, 0.0);
	 }
	
	 @Test
	 public void getLengthZeroRange() {
	   double length = exampleRange5.getLength();
	   assertEquals(0, length, 0.0);
	 }
	
	 @Test
	 public void getLengthNegativeRange() {
	   double length = exampleRange6.getLength();
	   assertEquals(5, length, 0.0);
	 }
	
	 @Test
	 public void getLengthLargeNumberFirstRange() {
	    
	   try {
	     Range exampleInvalidRange = new Range (5, 10);
	     double length = exampleInvalidRange.getLength();
	     assertEquals(5, length, 0.0);
	   }catch(Exception e) {
	     fail("Lower Bound range needs to be before the Upper Bound range");
	   }
	 }
	 
		////////////////////////////
		/* Created By: Siddharth
		* Testing Method: getLowerBound */
		////////////////////////////
	  @Test
	  public void getLowerBoundPositiveRange() {
	    double lowerBound = exampleRange1.getLowerBound();
	    assertEquals(5.0, lowerBound, 0.0);
	  }
	
	  @Test
	  public void getLowerBoundZeroRange() {
	    double lowerBound = exampleRange5.getLowerBound();
	    assertEquals(5, lowerBound, 0.0);
	  }
	
	  @Test
	  public void getLowerBoundNegativeRange() {
	    double lowerBound = exampleRange6.getLowerBound();
	    assertEquals(-10, lowerBound, 0.0);
	  }
	
	  @Test
	  public void getLowerBoundLargeNumberFirstRange() {
		   try {
		    	Range exampleInvalidRange = new Range (10, 5);
		    	double lower = exampleInvalidRange.getLowerBound();
		    	assertEquals(5, lower, 0.0);
		    }catch(Exception e) {
		    	fail("Lower Bound range value needs to be before the Upper Bound range value in constructor");
		    }
	  }
		
		////////////////////////////
		/* Created By: Siddharth
		* Testing Method: getUpperBound */
		////////////////////////////
	
	  @Test
	  public void getUpperBoundPositiveRange() {
	    double UpperBound = exampleRange1.getUpperBound();
	    assertEquals(5.0, UpperBound, 0.0);
	  }
	
	  @Test
	  public void getUpperBoundZeroRange() {
	    double UpperBound = exampleRange5.getUpperBound();
	    assertEquals(5, UpperBound, 0.0);
	  }
	
	  @Test
	  public void getUpperBoundNegativeRange() {
	    double UpperBound = exampleRange6.getUpperBound();
	    assertEquals(-10, UpperBound, 0.0);
	  }
	
	  @Test
	  public void getUpperBoundLargeNumberFirstRange() {
		   try {
		    	Range exampleInvalidRange = new Range (10, 5);
		    	double upper = exampleInvalidRange.getUpperBound();
		    	assertEquals(10, upper, 0.0);
		    }catch(Exception e) {
		    	fail("Lower Bound range value needs to be before the Upper Bound range value in constructor");
		    }
	  }
	  
	///////////////////////////////////////////////////////////////////////////////
	// 																			 //
	//    NOTE: Above Tests were created for Assignment #2 black-box testing    ///
	// 																			 //
	///////////////////////////////////////////////////////////////////////////////
	// 																			 //
	//   NOTE: Below Tests were created for Assignment #3 white-box testing     ///
	// 																			 //
    ///////////////////////////////////////////////////////////////////////////////
	  
	  /*
		* Explanation:
		* This tests the combineIgnoringNaN method with positive Ranges.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNPositives() {
	  		
	  		Range expected = new Range(5.0, 15.0);
	  		Range combined = Range.combineIgnoringNaN(exampleRange1, exampleRange3);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  	
	  	/*
		* Explanation:
		* This tests the combineIgnoringNaN method with NaN Range 1 and NaN Range 2.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNWithBothNaN() {
	  		
	  		Range expected = null;
	  		Range exampleRangeNaN1 = new Range(Double.NaN, Double.NaN);
	  		Range exampleRangeNaN2 = new Range(Double.NaN, Double.NaN);
	  		Range combined = Range.combineIgnoringNaN(exampleRangeNaN1, exampleRangeNaN2);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  	
	  	/*
		* Explanation:
		* This tests the combineIgnoringNaN method with NaN Range 2 and null Range 1.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNWithNaN2andNull1() {
	  		
	  		Range expected = null;
	  		Range exampleRangeNaN = new Range(Double.NaN, Double.NaN);
	  		Range combined = Range.combineIgnoringNaN(exampleRangeNull, exampleRangeNaN);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  
	   /*
		* Explanation:
		* This tests the combineIgnoringNaN method with NaN Range 1 and null Range 2.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNWithNaN1andNull2() {
	  		
	  		Range expected = null;
	  		Range exampleRangeNaN = new Range(Double.NaN, Double.NaN);
	  		Range combined = Range.combineIgnoringNaN(exampleRangeNaN, exampleRangeNull);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  
	  	/*
		* Explanation:
		* This tests the combineIgnoringNaN method with null Ranges.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNNullRanges() {
	  		
	  		Range expected = null;
	  		Range combined = Range.combineIgnoringNaN(exampleRangeNull, exampleRangeNull);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  
	  	/*
		* Explanation:
		* This tests the combineIgnoringNaN method with null Range 2 and positive range 1.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNNullRange2() {
	  		
	  		Range expected = new Range(5.0, 10.0);
	  		Range combined = Range.combineIgnoringNaN(exampleRange1, exampleRangeNull);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  
	  
	  	/*
		* Explanation:
		* This tests the combineIgnoringNaN method with null Range 1 and positive range 2.
		* Creator: Kolby Lalonde
		*/
	  	@Test
	  	public void testCombineIgnoringNaNNullRange1() {
	  		
	  		Range expected = new Range(5.0, 10.0);
	  		Range combined = Range.combineIgnoringNaN(exampleRangeNull, exampleRange1);
	  		assertEquals("The expected range is not equal to the combine range", expected, combined);
	  	
	  	}
	  
	  
	  	/*
		* Explanation:
		* This tests the shift method with no crossing parameter and positive bounds.
		* Creator: Kolby Lalonde
		*/
	  
	  	@Test
	  	public void shiftTest() {
	  		
	  		// created expected range after shift
	  		Range expected = new Range(7.0, 12.0);
	  		// Call shift on example range
	  		Range shiftedExample1 = Range.shift(exampleRange1, 2.0);
	  		
	  		// Check if expected equals returned shifted range
	  		boolean flag = false;
	  		if(shiftedExample1.equals(expected)) {
	  			flag = true;
	  		}
	  		assertTrue("The shift was not as expected", flag);
	  	}
	  
	  	/*
		* Explanation:
		* This tests the shift method with zero crossing and positive bounds.
		* Creator: Kolby Lalonde
		*/
	  
	  	@Test
	  	public void shiftTestYesCrossZeroBase() {
	  		
	  		// created expected range after shift
	  		Range expected = new Range(7.0, 12.0);
	  		// Call shift on example range
	  		Range shiftedExample1 = Range.shift(exampleRange1, 2.0, true);
	  		
	  		// Check if expected equals returned shifted range
	  		boolean flag = false;
	  		if(shiftedExample1.equals(expected)) {
	  			flag = true;
	  		}
	  		assertTrue("The shift was not as expected", flag);
	  	}
	  
	  
	  	/*
		* Explanation:
		* This tests the shift method without zero crossing and negative bounds.
		* Creator: Kolby Lalonde
		*/
	  
	  	@Test
	  	public void shiftTestNoCrossZeroBase() {
	  		
	  		// created expected range after shift
	  		Range expected = new Range(-8.0, -3.0);
	  		// Call shift on example range
	  		Range shiftedExample1 = Range.shift(exampleRange6, 2.0, false);
	  		
	  		// Check if expected equals returned shifted range
	  		boolean flag = false;
	  		if(shiftedExample1.equals(expected)) {
	  			flag = true;
	  		}
	  		assertTrue("The shift was not as expected", flag);
	  	}
	  
	  
	   /*
		* Explanation:
		* This tests the shift method without zero crossing and zero bounds.
		* Creator: Kolby Lalonde
		*/
	  
	  	@Test
		public void shiftTestNoCrossZeroBounds() {
	  		
	  		// created expected range after shift
	  		Range zeroBoundsExample = new Range(0.0, .0);
	  		Range expected = new Range(2.0, 2.0);
	  		// Call shift on example range
	  		Range shiftedExample1 = Range.shift(zeroBoundsExample, 2.0, false);
	  		
	  		// Check if expected equals returned shifted range
	  		boolean flag = false;
	  		if(shiftedExample1.equals(expected)) {
	  			flag = true;
	  		}
	  		assertTrue("The shift was not as expected", flag);
	  	}
	  
	  
	  	/*
		* Explanation:
		* This tests the shift method without zero crossing and positive bounds.
		* Creator: Kolby Lalonde
		*/
	  
	  	@Test
		public void shiftTestNoCrossPositiveBounds() {
	  		
	  		// created expected range after shift
	  		Range expected = new Range(10.0, 15.0);
	  		// Call shift on example range
	  		Range shiftedExample1 = Range.shift(exampleRange1, 5.0, false);
	  		
	  		// Check if expected equals returned shifted range
	  		boolean flag = false;
	  		if(shiftedExample1.equals(expected)) {
	  			flag = true;
	  		}
	  		
	  		assertTrue("The shift was not as expected", flag);
	  	}
	  
	  	/*
		* Explanation:
		* This tests the scale method with a negative factor.
		* Creator: Kolby Lalonde
		*/
	  	@Test
		public void scaleTestNegativeFactor() {
	  		// set newR
	  		Range newR = Range.scale(exampleRange1, 2.0);
	  		//try negative factor
	  		try {
	  			newR = Range.scale(exampleRange1, -2.0);
	  		} catch(IllegalArgumentException e) {
	  			fail("scale method failed with negative scale factor");
	  		}
	  		// if possible assert equals
	  		assertEquals(5.0, newR.getLowerBound(),0.0);
			assertEquals(2.5, newR.getUpperBound(),0.0);
		}
	  
	  	/*
		* Explanation:
		* This tests the scale method with a positive factor.
		* Creator: Siddharth Menon
		*/
	  	@Test
		public void scaleTestPositiveFactor() {
			Range newR = Range.scale(exampleRange1, 2.0);
			assertEquals(10.0, newR.getLowerBound(),0.0);
			assertEquals(20.0, newR.getUpperBound(),0.0);
		}
	  
	  	/*
		* Explanation:
		* This tests the equals method to see if it catches a invalid input parameter.
		* Creator: Kolby Lalonde
		*/
	  	@Test
		public void equalsTestWithStringParameter() {
	  		
	  		// Manually creating a duplicate test range6
	  		Object newTestRange6 = "Range is -10.0 to -5.0";
			assertFalse("Ranges should not be equal due to lowerbound", exampleRange6.equals(newTestRange6));
		}
	  
	  
	  	/*
		* Explanation:
		* This tests the equals method to see if it catches ranges equal upper bound but not lower bound.
		* Creator: Kolby Lalonde
		*/
	  	@Test
		public void equalsTestFailsLowerBound() {
	  		
	  		// Manually creating a duplicate test range6
	  		Range newTestRange6 = new Range(-6.0, -5.0);
			assertFalse("Ranges should not be equal due to lowerbound", newTestRange6.equals(exampleRange6));
		}
	  
	  	/*
		* Explanation:
		* This tests the equals method to see if it catches ranges equal lower bound but not upper bound.
		* Creator: Kolby Lalonde
		*/
	  	@Test
		public void equalsTestFailsUpperBound() {
	  		
	  		// Manually creating a duplicate test range6
	  		Range newTestRange6 = new Range(-10.0, 3.0);
			assertFalse("Ranges should not be equal due to upperbound", newTestRange6.equals(exampleRange6));
		}
	  
	  	/*
		* Explanation:
		* This tests the equals method to see if it catches ranges equal.
		* Creator: Kolby Lalonde
		*/
	  	@Test
		public void equalsTestSuccess() {
	  		
	  		// Manually creating a duplicate test range6
	  		Range newTestRange6 = new Range(-10.0,-5.0);
			assertTrue("Ranges should be equal", newTestRange6.equals(exampleRange6));
		}
	  	
	  	/*
		* Explanation:
		* This tests the equals method to see if it catches ranges not equal at all.
		* Creator: Siddharth Menon
		*/
	  	@Test
		public void equalsTestFailsBothBounds() {
			assertFalse("Range shouldnt be equal",exampleRange1.equals(exampleRange3));
		}
	  
		
		/*
		* Explanation:
		* This tests the hashCode method to see if it returns a integer code.
		* Creator: Kolby Lalonde
		*/
		@Test
		public void testHashCode() {
		
			// Call hashCode into code variable
			int code =  exampleRange4.hashCode();
			// Variable flag
			boolean int_flag = false;
			// if code is positive set flag
			if(code > 0) {
				int_flag = true;
			}
			// if code is negative or zero set flag
			else if(code <= 0) {
				int_flag = true;
			}
			// Result of true expected
			assertTrue("The hashcode function did not return a int code", int_flag);
		}
		
		/*
		* Explanation:
		* This tests the toString method to see if it returns a the expected range in string format.
		* Creator: Kolby Lalonde
		*/
		@Test
		public void testToString() {
		
			// Call toString into rangeString variable
			String rangeString = exampleRange4.toString();
			// Variable flag
			boolean expected_flag = false;
			// If rangeString equals string we expect set flag
			if (rangeString.equals("Range[" + "-5.5" + "," + "11.1" + "]")) {
				expected_flag = true;
			}
			// Result of true expected
			assertTrue("The toString() function did not return the expected string: Range[-5.5,11.1]", expected_flag);
		}
		
		
		//Author: Siddharth Menon
		// start of methods tested
		  
		@Test
		public void getCentralValueTest() {
			double center = exampleRange1.getCentralValue();
			assertEquals(7.5,center,0.0);
		}
		  
		@Test
		public void getIntersectsTestUpperBound() {
			boolean correct = true;
			boolean inter = exampleRange1.intersects(exampleRange3);
			assertEquals(correct,inter);
		}
		
		@Test
		public void getIntersectsTestLowerBound() {
			boolean correct = true;
			boolean inter = exampleRange3.intersects(exampleRange1);
			assertEquals(correct,inter);
		}
		  
		@Test
		public void getConstrainsTest() {
			double constrain = exampleRange1.constrain(7.5);
			assertEquals(7.5,constrain,0.0);
		}
		  
		@Test
		public void expandToIncludeTest() {
			Range newR = Range.expandToInclude(exampleRangeNull, 5.0);
			assertEquals(5.0, newR.getLowerBound(),0.0);
			assertEquals(5.0, newR.getUpperBound(),0.0);
		}
		
		@Test
		public void expandToIncludeHigherTest(){
			Range highR = Range.expandToInclude(exampleRange1, 15);
			assertEquals(5.0, highR.getLowerBound(),0.0);
			assertEquals(15.0, highR.getUpperBound(),0.0);
		}
		
		@Test
		public void expandToIncludeLowerTest(){	
			Range lowR = Range.expandToInclude(exampleRange1, 1);
			assertEquals(1.0, lowR.getLowerBound(),0.0);
			assertEquals(10.0, lowR.getUpperBound(),0.0);
		}
		
		@Test
		public void expandToIncludeWithinTest(){	
			Range lowR = Range.expandToInclude(exampleRange1, 7);
			assertEquals(5.0, lowR.getLowerBound(),0.0);
			assertEquals(10.0, lowR.getUpperBound(),0.0);
		}
		
		@Test
		public void expandTest() {
			Range newR = Range.expand(exampleRange1, 1.0, 2.0);
			assertEquals(4.0, newR.getLowerBound(),0.0);
			assertEquals(12.0, newR.getUpperBound(),0.0);
		}
		 
		
		@Test
		public void isNaNRangeTestFail() {
			assertFalse("Range should not be null", exampleRange1.isNaNRange());
		}
		
		@Test
	    public void constrainTest() {
	        // create a new Range object with lower bound 0 and upper bound 10
	        Range range = new Range(0, 10);
	        
	        // test a value below the range
	        double value1 = -5;
	        double expected1 = 0;
	        double result1 = range.constrain(value1);
	        assertEquals(expected1, result1, 0.0001);
	        
	        // test a value above the range
	        double value2 = 15;
	        double expected2 = 10;
	        double result2 = range.constrain(value2);
	        assertEquals(expected2, result2, 0.0001);
	        
	        // test a value within the range
	        double value3 = 5;
	        double expected3 = 5;
	        double result3 = range.constrain(value3);
	        assertEquals(expected3, result3, 0.0001);
	        
	        // test a value equal to the lower bound
	        double value4 = 0;
	        double expected4 = 0;
	        double result4 = range.constrain(value4);
	        assertEquals(expected4, result4, 0.0001);
	        
	        // test a value equal to the upper bound
	        double value5 = 10;
	        double expected5 = 10;
	        double result5 = range.constrain(value5);
	        assertEquals(expected5, result5, 0.0001);
	        
	        // test a NaN value
	        double value6 = Double.NaN;
	        double expected6 = 0;
	        double result6 = range.constrain(value6);
	        assertTrue(Double.isNaN(result6));
	    }
		//end of methods tested
	
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
