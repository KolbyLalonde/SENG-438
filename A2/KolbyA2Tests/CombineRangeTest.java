/*
 * Author: Kolby Lalonde
 * SENG 438 Assignment #2
 * org.jfree.data.Range testing method combine
 */

package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class CombineRangeTest {
	
	// Creating multiple Range objects for testing purposes
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
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
  
    }
    
    // Unit Tests below
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
    public void correctCombineLowerBound() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of -5.0 is not the lower bound of combination range -5.0 to 10.0",  exampleRangeCombine.getLowerBound() == -5.0);
    }
    
    @Test
    public void correctCombineUpperBound() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 10.0 is not the upper bound of combination range -5.0 to 10.0",  exampleRangeCombine.getUpperBound() == 10.0);
    }
    
    @Test
    public void valueInsideCombineRangeOne() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 8.8 is not in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= 8.8) && (exampleRangeCombine.getUpperBound() >= 8.8)));
    }
    
    @Test
    public void valueInsideCombineRangeTwo() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of -3.5 is not in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= -3.5) && (exampleRangeCombine.getUpperBound() >= -3.5)));
    }
    
    @Test
    public void valueLowerThanCombineRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertFalse("The value of -12.0 is in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= -12.0) && (exampleRangeCombine.getUpperBound() >= -12.0)));
    }
    
    @Test
    public void valueHigherThanCombineRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertFalse("The value of 33.3 is in combination range -5.0 to 10.0",  ((exampleRangeCombine.getLowerBound() <= 33.3) && (exampleRangeCombine.getUpperBound() >= 33.3)));
    }
    
    @Test
    public void centralValueInsideCombineRange() {
    	
    	// Combine Example Ranges 1 and 2
    	exampleRangeCombine = Range.combine(exampleRange1, exampleRange2);
        assertTrue("The value of 2.5 is not the central value of combination range -5.0 to 10.0",  exampleRangeCombine.getCentralValue() == 2.5);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}