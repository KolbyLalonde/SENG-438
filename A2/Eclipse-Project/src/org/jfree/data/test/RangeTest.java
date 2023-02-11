/*
 * Author: Kolby and Siddharth
 * SENG 438 Assignment #2
 * org.jfree.data.Range testing method combine
 */

package org.jfree.data.test;

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
     * This tests the contains method on a null range.
     */
    @Test
    public void containsWithNullRange() {
    	// Try running contains on a null range
        try { 
        	exampleRangeNull.contains(1.0);
        } catch(Exception e) {
        	// if contains method throws exception fail test
        	fail("contains on a null range fails");
        }
        // contains on a null range did not fail so test its return value to be false
        assertFalse("The value 1.0 is contianed in null range", exampleRange4.contains(1.0));
    }
    
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
    
    /*
     * Explanation:
     * This tests the contains method on value that is the lower bound of the range.
     */
    @Test
    public void containsValueIsRangeLowerBound() {
    	// Result of true expected
        assertTrue("The value -5.5 is not contianed in range -5.5 to 11.1", exampleRange4.contains(-5.5));
    }
    
    /*
     * Explanation:
     * This tests the contains method on value that is the upper bound of the range.
     */
    @Test
    public void containsValueIsRangeUpperBound() {
    	// Result of true expected
        assertTrue("The value 11.1 is not contianed in range -5.5 to 11.1", exampleRange4.contains(11.1));
    }
    
    /*
     * Explanation:
     * This tests the contains method on value that is the central value of the range.
     */
    @Test
    public void containsValueIsRangeCentralValue() {
    	// Result of true expected
        assertTrue("The value 2.8 is not contianed in range -5.5 to 11.1", exampleRange4.contains(2.8));
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
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}