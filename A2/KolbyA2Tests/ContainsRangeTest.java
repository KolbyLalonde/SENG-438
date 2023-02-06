/*
 * Author: Kolby Lalonde
 * SENG 438 Assignment #2
 * org.jfree.data.Range testing method contains
*/

package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
 
public class ContainsRangeTest {
     
    // Creating multiple Range objects for testing purposes
    private Range exampleRange1;
    private Range exampleRangeNull;
     
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
 
    @Before
    public void setUp() throws Exception { 
         
        // Declaring values for example Range objects
        exampleRange1 = new Range(-5.5, 11.1);
   
    }
     
    // Unit Tests below
    @Test
    public void containsWithNullRange() {
        // Try running contains on a null range
        try { 
            exampleRangeNull.contains(1.0);
        } catch(Exception e) {
            fail("contains on a null range fails");
        }
        // contains on a null range did not fail so test its return value to be false
        assertFalse("The value 1.0 is contianed in null range", exampleRange1.contains(1.0));
    }
     
    @Test
    public void valueInRange() {
        assertTrue("The value 1.0 not contianed in range -5.5 to 11.1", exampleRange1.contains(1.0));
    }
     
    @Test
    public void valueAboveRange() {
        assertFalse("The value 55.5 is contianed in range -5.5 to 11.1", exampleRange1.contains(55.5));
    }
     
    @Test
    public void valueBelowRange() {
        assertFalse("The value -23.4 is contianed in range -5.5 to 11.1", exampleRange1.contains(-23.4));
    }
     
    @Test
    public void valueIsRangeLowerBound() {
        assertTrue("The value -5.5 is not contianed in range -5.5 to 11.1", exampleRange1.contains(-5.5));
    }
     
    @Test
    public void valueIsRangeUpperBound() {
        assertTrue("The value 11.1 is not contianed in range -5.5 to 11.1", exampleRange1.contains(11.1));
    }
     
    @Test
    public void valueIsRangeCentralValue() {
        assertTrue("The value 2.8 is not contianed in range -5.5 to 11.1", exampleRange1.contains(2.8));
    }
     
    @After
    public void tearDown() throws Exception {
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
