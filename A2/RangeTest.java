/*
 * Author: Kolby Lalonde
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
    
    /* 
     * Author: Kolby 
     * Combine Method
     */
    
    @Test
    public void combineDistjointedRangesLargeFirst() {
    	// Combine Example Ranges 3 and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRange3, exampleRange2);
    	}catch(Exception e){
    		fail("combine method failed with disjointed ranges where larger range is first");
    	}
    	Range expected  = new Range(-5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    @Test
    public void combineDistjointedRangesSmallFirst() {
    	// Combine Example Ranges 2 and 3
    	try {
    		exampleRangeCombine = Range.combine(exampleRange2, exampleRange3);
    	}catch(Exception e){
    		fail("combine method failed with disjointed ranges where smaller range is first");
    	}
    	Range expected  = new Range(-5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    @Test
    public void combineOverlapingRangesSmallFirst() {
    	// Combine Example Ranges 1 and 3
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange3);
    	}catch(Exception e){
    		fail("combine method failed with overlapping ranges where smaller range is first");
    	}
    	Range expected  = new Range(5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    @Test
    public void combineOverlapingRangesLargeFirst() {
    	// Combine Example Ranges 3 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange3, exampleRange1);
    	}catch(Exception e){
    		fail("combine method failed with overlapping ranges where larger range is first");
    	}
    	Range expected  = new Range(5.0, 15.0);
        assertEquals("The combine of overlapping ranges", expected, exampleRangeCombine);
    }
    
    @Test
    public void combineSameRanges() {
    	// Combine Example Ranges 1 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange1);
    	}catch(Exception e){
    		fail("combine method failed with both the same ranges");
    	}
        assertEquals("The combine of the same ranges", exampleRange1, exampleRangeCombine);
    }
    
    @Test
    public void combineNullRanges() {
    	// Combine Example Ranges null and null
    	try {
    		exampleRangeCombine = Range.combine(exampleRangeNull, exampleRangeNull);
    	}catch(Exception e){
    		fail("combine method failed with both null ranges");
    	}
        assertEquals("The combine of null range 1 with nul range 2", null, exampleRangeCombine);
    }
    
    @Test
    public void combineNullRangeOne() {
    	// Combine Example Ranges null and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRangeNull, exampleRange2);
    	}catch(Exception e){
    		fail("combine method failed with null range one");
    	}
    	Range expected  = new Range(-5.0, 5.0);
        assertEquals("The combine of null range 1 with range 2",  expected, exampleRangeCombine);
    }
    
    @Test
    public void combineNullRangeTwo() {
    	// Combine Example Ranges 1 and null
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRangeNull);
    	}catch(Exception e){
    		fail("combine method failed with null range two");
    	}
    	Range expected  = new Range(5.0, 10.0);
        assertEquals("The combine of range 1 with null range 2",  expected, exampleRangeCombine);
    }
    
    
    @Test
    public void combineLargerRangeOne() {
    	// Combine Example Ranges 1 and 2
    	try {
    		exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
    	}catch(Exception e){
    		fail("combine method failed with smaller range one");
    	}
    	Range expected  = new Range(-5.0, 10.0);
        assertEquals("The combine of larger range 1 with smaller range 2",  expected, exampleRangeCombine);
    }
    
    @Test
    public void combineSmallerRangeOne() {
    	// Combine Example Ranges 2 and 1
    	try {
    		exampleRangeCombine = Range.combine(exampleRange2, exampleRange1);
    	}catch(Exception e){
    		fail("combine method failed with smaller range one");
    	}
    	Range expected  = new Range(-5.0, 10.0);
        assertEquals("The combine of smaller range 1 with larger range 2",  expected, exampleRangeCombine);
    }
    


    /* NOTE: The Tests below require a working getUpperBound(), getLowerBound(), getCentralValue()
    	     AND a combine range that passes the combineLargerRangeOne test. */
    @Test
    public void combineValidLowerBound() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of -5.0 is not the lower bound of combination range -5.0 to 10.0",  exampleRangeCombine.getLowerBound() == -5.0);
    }
    
    @Test
    public void combineValidUpperBound() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 10.0 is not the upper bound of combination range -5.0 to 10.0",  exampleRangeCombine.getUpperBound() == 10.0);
    }
    
    @Test
    public void combineValueInsideRangeOne() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 8.8 is not in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= 8.8) && (exampleRangeCombine.getUpperBound() >= 8.8)));
    }
    
    @Test
    public void combineValueInsideRangeTwo() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of -3.5 is not in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= -3.5) && (exampleRangeCombine.getUpperBound() >= -3.5)));
    }
    
    @Test
    public void combineValueLowerThanRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertFalse("The value of -12.0 is in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= -12.0) && (exampleRangeCombine.getUpperBound() >= -12.0)));
    }
    
    @Test
    public void combineValueHigherThanRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertFalse("The value of 33.3 is in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= 33.3) && (exampleRangeCombine.getUpperBound() >= 33.3)));
    }
    
    @Test
    public void combineValueInsideCombineRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 2.5 is not the central value of combination range -5.0 to 10.0",  exampleRangeCombine.getCentralValue() == 2.5);
    }
    
    
    /* 
     * Author: Kolby 
     * Contains Method
     */
    
    @Test
    public void containsWithNullRange() {
    	// Try running contains on a null range
        try { 
        	exampleRangeNull.contains(1.0);
        } catch(Exception e) {
        	fail("contains on a null range fails");
        }
        // contains on a null range did not fail so test its return value to be false
        assertFalse("The value 1.0 is contianed in null range", exampleRange4.contains(1.0));
    }
    
    @Test
    public void containsValueInRange() {
        assertTrue("The value 1.0 not contianed in range -5.5 to 11.1", exampleRange4.contains(1.0));
    }
    
    @Test
    public void containsValueAboveRange() {
        assertFalse("The value 55.5 is contianed in range -5.5 to 11.1", exampleRange4.contains(55.5));
    }
    
    @Test
    public void containsValueBelowRange() {
        assertFalse("The value -23.4 is contianed in range -5.5 to 11.1", exampleRange4.contains(-23.4));
    }
    
    @Test
    public void containsValueIsRangeLowerBound() {
        assertTrue("The value -5.5 is not contianed in range -5.5 to 11.1", exampleRange4.contains(-5.5));
    }
    
    @Test
    public void containsValueIsRangeUpperBound() {
        assertTrue("The value 11.1 is not contianed in range -5.5 to 11.1", exampleRange4.contains(11.1));
    }
    
    @Test
    public void containsValueIsRangeCentralValue() {
        assertTrue("The value 2.8 is not contianed in range -5.5 to 11.1", exampleRange4.contains(2.8));
    }
    /* 
     * Author: Siddharth 
     * getLength Method
     */

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
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
