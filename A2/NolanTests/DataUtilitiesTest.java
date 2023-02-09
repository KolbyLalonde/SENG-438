package org.jfree.data.test;

import static org.junit.Assert.*;


import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.junit.Before;

public class DataUtilitiesTest extends DataUtilities  
{

    double [] createNumberArrayNegativeDoubles;
    double [] createNumberArrayPositiveDoubles;
    double [] createNumberArrayInts;
    double [] createNumberArrayMixed;

    
    @Before
    public void setUp() throws Exception 
    {
    // createNumberArray() initialization for testing
    			createNumberArrayNegativeDoubles = new double[]{-9.7, -100.55, -99.7777};
    		    createNumberArrayPositiveDoubles = new double[]{345.345345345, 7.777777777};
    		    createNumberArrayInts = new double[] {1, 2, 3, 4};
    		    createNumberArrayMixed = new double[] {20.65423156, -78.17, 11};
    		    

    }
    // Tests for the createNumberArray(double[] data)
    //By:Nolan Parmar
    // Tests for a null double array which should cause an IllegalArgumentException to be thrown		
    @Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullData22() {
		Number[] expected = null;
		double[] data = null;
		Number[] result = DataUtilities.createNumberArray(data);
		assertArrayEquals(expected, result);
	}
    
    //By:Nolan Parmar
    // Tests for a negative array of doubles which should return a array of Number objects that matches the expected array of Number objects
    @Test
    public void createNumberArrayNegativeDoublesTest()
    {
      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayNegativeDoubles);
    }
    
    //By:Nolan Parmar
    // Tests for a positive array of doubles which should return a array of Number objects that matches the expected array of Number objects 
    @Test
  	public void createNumberArrayPositiveDoublesTest()
    {
      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayPositiveDoubles);
      Number [] expectedVal = {Double.valueOf(345.345345345), Double.valueOf(7.777777777)};
      assertArrayEquals(expectedVal, returnVal);
    }
    
    //By:Nolan Parmar
    // Tests for a integer array which should return a array of Number objects that matches the expected array of Number objects 
    @Test
  	public void createNumberArrayIntsTest()
    {
      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayInts);
      Number [] expectedVal = {Double.valueOf(1), Double.valueOf(2), Double.valueOf(3), Double.valueOf(4)};
      assertArrayEquals(expectedVal, returnVal);
    }
    
    //By:Nolan Parmar
    //Tests for a mixed array of doubles and integers with different signs which should return a array of Number objects that matches the expected array of Number objects 
    @Test
  	public void createNumberArrayMixedTest()
    {
      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayMixed);
      Number [] expectedVal = {Double.valueOf(20.65423156), Double.valueOf(-78/17), Double.valueOf(11)};
      assertArrayEquals(expectedVal, returnVal);
    }
    
    //Tests for createNumberArray2D(double[][] data) 
    //By:Nolan Parmar
    //Boundary testing with least number of possible elements; passing in an empty 2D double array to turn into a Number array
    //Expected outcome:  empty Number array
    @Test
	public void empty2DArrayTest() 
    {
		double [][] test = {};
		Number [][] expected = {};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the empty, expected Number 2D Array", expected, actual);
	}
    
    //By:Nolan Parmar
    //createNumberArray2D(double [][]) 
    //Boundary testing 
    //passing in a 2D double array with more than 17 decimal places
    @Test
	public void moreThan17DecimalPlaces2DArrayTest() 
    {
		double [][] test = {{15.1234567890123456789}}; 
		Number [][] expected = {{15.12345678901234567}}; //last two decimal places are cut off
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected Number 2D Array with more than" + "17 decimal places", expected, actual);
	}
	
    //By:Nolan Parmar
    //createNumberArray2D(double [][]) 
    //Equivalence test 
    // passing in a 2D double array with 1 row and 10 columns
    
    @Test
	public void tenByOne2DArrayTest() 
    {
		double [][] test = {{19.56782},{-19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782}};
		Number [][] expected = {{19.56782},{-19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected ten by one Number 2D Array"
	, expected, actual);
	}
    
    //By:Nolan Parmar
    //createNumberArray2D(double [][]) 
    //Equivalence test 
    //passing in a 2D double array with 10 rows and 1 column
    @Test
	public void oneByTen2DArrayTest() 
    {
    	
		double [][] test = {{19.56782, -19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782}};
		Number [][] expected = {{19.56782, -19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected one by ten Number 2D Array"
	, expected, actual);
	}
}
