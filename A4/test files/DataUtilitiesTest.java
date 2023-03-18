package org.jfree.data;


import org.jfree.data.DataUtilities;
import org.jfree.data.*;
import org.jmock.Expectations;
import org.jmock.Mockery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// Since NULL values are not permitted (JavaDOCS), no NULL tests

public class DataUtilitiesTest {
	
	double [] createNumberArrayNegativeDoubles;
    double [] createNumberArrayPositiveDoubles;
    double [] createNumberArrayInts;
    double [] createNumberArrayMixed;
	
	Mockery mockValues2D;
    Mockery mockKeyedValues;
    Values2D values2D;
    KeyedValues keyedValues;
    private Mockery mockingContext1 = new Mockery();
    private Values2D values1 = mockingContext1.mock(Values2D.class);
    @Before
    public void setUp() throws Exception
    {
        mockValues2D = new Mockery();
        values2D = mockValues2D.mock(Values2D.class);

        mockKeyedValues = new Mockery();
        keyedValues = mockKeyedValues.mock(KeyedValues.class);
        
        // createNumberArray() initialization for testing
		createNumberArrayNegativeDoubles = new double[]{-9.7, -100.55, -99.7777};
	    createNumberArrayPositiveDoubles = new double[]{345.345345345, 7.777777777};
	    createNumberArrayInts = new double[] {1, 2, 3, 4};
	    createNumberArrayMixed = new double[] {20.65423156, -78.17, 11};
    }
    
    /*
     * Author: Sadman
     * Testing method .calculateColumnTotal
     */
	
//	@Test
//	public void testEmptyTable() {
//
//		mockValues2D.checking(new Expectations() {
//
//			{
//				one(values2D).getRowCount();
//				will(returnValue(0));
//			}
//
//		});
//
//		double result = DataUtilities.calculateColumnTotal(values2D, 0);
//
//		assertEquals(0, result, 0.000000001d);
//
//	}
//

//    @Test
//    public void testCalculateColumnTotalForASingleColumn()
//    {
//        mockValues2D.checking(new Expectations()
//        {
//            {
//                one(values2D).getRowCount();
//                will(returnValue(1));
//
//                one(values2D).getValue(0, 0);
//                will(returnValue(7.5));
//            }
//        });
//
//        final double result = DataUtilities.calculateColumnTotal(values2D, 0);
//
//        assertEquals("Column Total of 7.5 should be 7.5\n", 7.5, result, .000000001d);
//    }
    
//    @Test
//    public void testCalculateColumnTotalForMultipleColumns()
//    {
//        mockValues2D.checking(new Expectations()
//        {
//            {
//                one(values2D).getRowCount();
//                will(returnValue(2));
//
//                one(values2D).getValue(0, 0);
//                will(returnValue(7.5));
//
//                one(values2D).getValue(1, 0);
//                will(returnValue(2.5));
//            }
//        });
//
//        final double result = DataUtilities.calculateColumnTotal(values2D, 0);
//
//        assertEquals("Column Total of 7.5 and 2.5 should be 10.0\n", 10.0, result, .000000001d);
//    }

    
 // equal
 	@Test
 	public void checkTwoArraysEqual() {
 		double array[][] = new double[2][2];
 		array[0][0] = 1d;
 		array[0][1] = 2d;
 		array[1][0] = 3d;
 		array[1][1] = 4d;
 		double doubleArray[][] = {
 				{1d,2d},
 				{3d,4d}
 		};
 		assertTrue(DataUtilities.equal(array, doubleArray));
 	}
 	 
 	@Test
 	public void checkTwoArraysEqualNull() {
 		double array[][] = null;
 		assertTrue(DataUtilities.equal(null, array));
 	}
 	
 	@Test
 	public void checkTwoArraysEqualNaN() {
 		double array[][] = {
 				{Math.log(-1), Math.log(-1)}
 		};
 		double array2[][] = {
 				{Math.sqrt(-1), Math.sqrt(-1)}
 		};
 		assertTrue(DataUtilities.equal(array2, array));
 	}
 	
 	@Test
 	public void checkTwoArraysEqualEmpty() {
 		double array[][] = {	 
 		};
 		double array2[][] = {
 		};
 		assertTrue(DataUtilities.equal(array2, array));
 	}
 	
 	@Test
 	public void checkTwoArraysNotEqual() {
 		double array[][] = {	
 				{1,2,3,4,5}
 		};
 		double array2[][] = {
 				{1,2,3,4},
 				{5}
 		};
 		assertFalse(DataUtilities.equal(array2, array));
 	}
     
 	@Test
     public void checkTwoArraysEqualBothNull() {
         double array[][] = null;
         double array2[][] = null;
         assertTrue(DataUtilities.equal(array, array2));
     }
 	
     @Test
     public void checkTwoArraysEqualOneArrayNull() {
         double array[][] = null;
         double array2[][] = {
                 {1,2,3,4},
                 {5}
         };
         assertFalse(DataUtilities.equal(array, array2));
     }
     
     @Test
     public void checkTwoArrayEqualSecondArrayNull() {
         double array[][] = {{1,2,3,4}};
         double array2[][] = null;
         assertFalse(DataUtilities.equal(array, array2));
     }
     
     @Test
     public void checkTwoArraysNotEqual2() {
         double array[][] = {    
                 {1,2,3,4,5}
         };
         double array2[][] = {
                 {4,2,3,4}
         };
         assertFalse(DataUtilities.equal(array2, array));
     }
 	private double[][] values; //for clone() method

     
     //clone
     //Test of null double[][] argument
     	 @Test(expected = IllegalArgumentException.class)
     	 public void testNullDoubleArray() {
     	     DataUtilities.clone(values);
     	 }
     	 
     	//Test of double[][] with null value argument
         @Test
     	public void testDoubleArrayWithNullValue() {
         	values=new double[2][5];
         	this.values[0]=null;
         	this.values[1][0]=3;
         	this.values[1][1]=4;
         	this.values[1][2]=5;
     		double[][] clone=DataUtilities.clone(values);
     		assertEquals(values[0],clone[0]);
     		assertEquals(values[1][0], clone[1][0], .000000001d);
     		assertEquals(values[1][1], clone[1][1], .000000001d);
     		assertEquals(values[1][2], clone[1][2], .000000001d);
     	}
         
       //Test of double[][] with no null value argument
         @Test
     	public void testDoubleArrayWithNoneNullValue() {
         	values=new double[2][5];
         	this.values[0][1]=1;
         	this.values[0][2]=2;
         	this.values[1][0]=3;
         	this.values[1][1]=4;
         	this.values[1][2]=5;
     		double[][] clone=DataUtilities.clone(values);
     		assertEquals(values[0][1],clone[0][1], .000000001d);
     		assertEquals(values[0][2],clone[0][2], .000000001d);
     		assertEquals(values[0][4],clone[0][4], .000000001d);
     		assertEquals(values[1][0], clone[1][0], .000000001d);
     		assertEquals(values[1][1], clone[1][1], .000000001d);
     		assertEquals(values[1][2], clone[1][2], .000000001d);
     	}
    /*
     * Author: Sadman
     * Testing method .calculateRowTotal
     */

//    @Test
//    public void testCalculateRowTotalForASingleRow() 
//    {
//        mockValues2D.checking(new Expectations()
//        {
//        	{
//                
//                one(values2D).getRowCount();
//                will(returnValue(1));
//                
//                
//                one(values2D).getColumnCount();
//                will(returnValue(2));
//                
//
//                one(values2D).getValue(0, 0);
//                will(returnValue(5.5));
//
//            }
//        });
//
//        final double result = DataUtilities.calculateRowTotal(values2D,  0);
//
//        assertEquals("Row Total of 5.5 should be 5.5\n", 5.5, result, .000000001d);
//    }
    
//    @Test
//    public void testCalculateRowTotalForMultipleRows() 
//    {
//        mockValues2D.checking(new Expectations()
//        {
//            {
//                one(values2D).getColumnCount();
//                will(returnValue(3));
//
//                one(values2D).getRowCount();
//                will(returnValue(1));
//
//                one(values2D).getValue(0, 0);
//                will(returnValue(5.5));
//
//                one(values2D).getValue(0, 1);
//                will(returnValue(6.5));
//            }
//        });
//
//        final double result = DataUtilities.calculateRowTotal(values2D,  0);
//
//        assertEquals("Row Total of 5.5 and 6.5 should be 12.0\n", 12.0, result, .000000001d);
//    }
    
    /*
     * Author: Sadman
     * Testing method .getCumulativePercentages
     */

//    @Test
//    public void testGetCumulativePercentagesCumulatesOneValue() 
//    {
//        mockKeyedValues.checking(new Expectations()
//        {
//            {
//                atLeast(1).of(keyedValues).getItemCount();
//                will(returnValue(1));
//
//                atLeast(1).of(keyedValues).getKey(0);
//                will(returnValue(5));
//
//                atLeast(1).of(keyedValues).getValue(0);
//                will(returnValue(3));
//            }
//        });
//
//        
//        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
//        double totalValue = 0.0;
//
//        for (int i = 0; i < keyedValues.getItemCount(); i++) {
//            totalValue += (keyedValues.getValue(i)).intValue();
//        }
//
//        // From the Example in JavaDOCS
//        final double expectedValue = (keyedValues.getValue(0)).intValue() / totalValue;
//
//        assertEquals("Cumulative percentage of a single value should be 1.0\n", expectedValue, result.getValue(0));
//    }
//    
    
    // Fails
   // @Test
//    public void testGetCumulativePercentagesCumulatesTwoValues() 
//    {
//        mockKeyedValues.checking(new Expectations()
//        {
//            {
//                atLeast(2).of(keyedValues).getItemCount();
//                will(returnValue(2));
//
//                atLeast(1).of(keyedValues).getKey(0);
//                will(returnValue(5));
//
//                atLeast(1).of(keyedValues).getValue(0);
//                will(returnValue(3));
//
//                atLeast(1).of(keyedValues).getKey(1);
//                will(returnValue(1));
//
//                atLeast(1).of(keyedValues).getValue(1);
//                will(returnValue(7));
//            }
//        });
//
//        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
//
//        double totalValue = 0.0;
//
//        for (int i = 0; i < keyedValues.getItemCount(); i++) {
//            totalValue += (keyedValues.getValue(i)).intValue();
//        }
//
//        // From the Example in JavaDOCS 
//        final double expectedValue1 = ((keyedValues.getValue(0)).intValue() / totalValue);
//        final double expectedValue2 = (((keyedValues.getValue(0)).intValue() + (keyedValues.getValue(1)).intValue()) / totalValue);
//
//        assertEquals("Cumulative percentage of the first value should be 0.1\n", expectedValue1, result.getValue(0));
//        assertEquals("Cumulative percentage of all values should be 0.1\n", expectedValue2, result.getValue(1));
//    }
//    
     
    
 // Tests for the createNumberArray(double[] data)
    
    //By:Nolan Parmar
    // Tests for a null double array which should cause an IllegalArgumentException to be thrown		
    @Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullData22() 
	{
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
//    @Test
//  	public void createNumberArrayIntsTest()
//    {
//      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayInts);
//      Number [] expectedVal = {Double.valueOf(1), Double.valueOf(2), Double.valueOf(3), Double.valueOf(4)};
//      assertArrayEquals(expectedVal, returnVal);
//    }
//    
    //By:Nolan Parmar
    //Tests for a mixed array of doubles and integers with different signs which should return a array of Number objects that matches the expected array of Number objects 
//    @Test
//  	public void createNumberArrayMixedTest()
//    {
//      Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayMixed);
//      Number [] expectedVal = {Double.valueOf(20.65423156), Double.valueOf(-78/17), Double.valueOf(11)};
//      assertArrayEquals(expectedVal, returnVal);
//    }
//    
    
    
    //Test of null Value2D and regular array argument
	 @Test(expected = IllegalArgumentException.class)
	 public void testNullValue2DForcalculateRowTotalwithArray() {
		 int[] arr= {0,1,2};
	     DataUtilities.calculateRowTotal(null, 0, arr);
	 }
	 


	 
	 //Test of null Value2D argument
	 @Test(expected = IllegalArgumentException.class)
	 public void testNullValue2DForcalculateColumnTotal() {
	     DataUtilities.calculateColumnTotal(null, 0);
	 }
	 
	
	
	 
	 //Test of null Value2D and regular array argument
	 @Test(expected = IllegalArgumentException.class)
	 public void testNullValue2DForcalculateColumnTotalwithArray() {
		 int[] arr= {0,1,2};
	     DataUtilities.calculateColumnTotal(null, 0, arr);
	 }
	 
	 
	

	 @Test
		// This tests the method using positive integers and decimals
		public void createNumberArrayEmptyTest() {
			double[] inputDoubleArray = {};
			Number[] actualArray = DataUtilities.createNumberArray(inputDoubleArray);
			assertEquals("This array should be empty.", 0, actualArray.length);
		}
		
		
		@Test
		// This tests the method using positive integers and decimals
		public void createNumberArrayPositiveTest() {
			double[] inputDoubleArray = {1.2, 3.4, 5.6, 7.8, 9.0,10};
			Number[] actualArray = DataUtilities.createNumberArray(inputDoubleArray);
			assertEquals(actualArray[0].doubleValue(), 1.2, 0.0000001d);
			assertEquals(actualArray[1].doubleValue(), 3.4, 0.0000001d);
			assertEquals(actualArray[2].doubleValue(), 5.6, 0.0000001d);
			assertEquals(actualArray[3].doubleValue(), 7.8, 0.0000001d);
			assertEquals(actualArray[4].doubleValue(), 9.0, 0.0000001d);
			assertEquals(actualArray[5].doubleValue(), 10, 0.0000001d);
		}
		
	
		
		@Test
		// This tests the method using positive integers and decimals
		public void createNumberArrayMixedTest() {
			double[] inputDoubleArray = {1.2, -3.4, -5.6, 7.8, -9.0,10};
			Number[] actualArray = DataUtilities.createNumberArray(inputDoubleArray);
			assertEquals(actualArray[0].doubleValue(), 1.2, 0.0000001d);
			assertEquals(actualArray[1].doubleValue(), -3.4, 0.0000001d);
			assertEquals(actualArray[2].doubleValue(), -5.6, 0.0000001d);
			assertEquals(actualArray[3].doubleValue(), 7.8, 0.0000001d);
			assertEquals(actualArray[4].doubleValue(), -9.0, 0.0000001d);
			assertEquals(actualArray[5].doubleValue(), 10, 0.0000001d);
		}
		
		@Test
		// This tests the method using null values, which are not permitted. Thus, it should throw an illegal argument exception.
		public void createNumberArrayNullTest() {
			double[] inputDoubleArray = null;
			try {
				Number[] actualArray = DataUtilities.createNumberArray(inputDoubleArray);
				}catch (Exception e){
					assertEquals("Null does not throw "
							+ "an InvalidParameterException", IllegalArgumentException.class, e.getClass());
				}
		}
		
		@Test
		//Tests the method using positive decimals
		public void createNumberArray2DPositiveTest() {
			double[][] inputDoubleArray = {{1.2, 3.4}, {5.6, 7.8}, {9.0, 8.7},{10}};
	    	Number[][] actualArray = DataUtilities.createNumberArray2D(inputDoubleArray);
			assertEquals(actualArray[0][0].doubleValue(), 1.2, 0.0000001d);
			assertEquals(actualArray[0][1].doubleValue(), 3.4, 0.0000001d);
			assertEquals(actualArray[1][0].doubleValue(), 5.6, 0.0000001d);
			assertEquals(actualArray[1][1].doubleValue(), 7.8, 0.0000001d);
			assertEquals(actualArray[2][0].doubleValue(), 9.0, 0.0000001d);
			assertEquals(actualArray[2][1].doubleValue(), 8.7, 0.0000001d);
			assertEquals(actualArray[3][0].doubleValue(), 10, 0.0000001d);
		}
		
		@Test
		public void createNumberArray2DNegativeTest() {
			double[][] inputDoubleArray = {{-1.2, -3.4}, {-5.6, -7.8}, {-9.0, -8.7},{-10}};
	    	Number[][] actualArray = DataUtilities.createNumberArray2D(inputDoubleArray);
			assertEquals(actualArray[0][0].doubleValue(), -1.2, 0.0000001d);
			assertEquals(actualArray[0][1].doubleValue(), -3.4, 0.0000001d);
			assertEquals(actualArray[1][0].doubleValue(), -5.6, 0.0000001d);
			assertEquals(actualArray[1][1].doubleValue(), -7.8, 0.0000001d);
			assertEquals(actualArray[2][0].doubleValue(), -9.0, 0.0000001d);
			assertEquals(actualArray[2][1].doubleValue(), -8.7, 0.0000001d);
			assertEquals(actualArray[3][0].doubleValue(), -10, 0.0000001d);
		}
		
		@Test
		public void createNumberArray2DMixedTest() {
			double[][] inputDoubleArray = {{-1.2, 3.4}, {-5.6, -7.8}, {9.0, 8.7},{-10}};
	    	Number[][] actualArray = DataUtilities.createNumberArray2D(inputDoubleArray);
			assertEquals(actualArray[0][0].doubleValue(), -1.2, 0.0000001d);
			assertEquals(actualArray[0][1].doubleValue(), 3.4, 0.0000001d);
			assertEquals(actualArray[1][0].doubleValue(), -5.6, 0.0000001d);
			assertEquals(actualArray[1][1].doubleValue(), -7.8, 0.0000001d);
			assertEquals(actualArray[2][0].doubleValue(), 9.0, 0.0000001d);
			assertEquals(actualArray[2][1].doubleValue(), 8.7, 0.0000001d);
			assertEquals(actualArray[3][0].doubleValue(), -10, 0.0000001d);
		}
		
		@Test
		// This tests the method using null values, which are not permitted. Thus, it should throw an illegal argument exception.
		public void createNumberArray2DNullTest() {
			double[][] inputDoubleArray = null;
			try {
			Number[][] actualArray = DataUtilities.createNumberArray2D(inputDoubleArray);
			}catch (Exception e){
				assertEquals("Null does not throw "
						+ "an InvalidParameterException", IllegalArgumentException.class, e.getClass());
			}
		}
		
    //Tests for createNumberArray2D(double[][] data)
	
    //By:Nolan Parmar
    //Equivalence test (illegal value); passing in a null object to turn into a 2D Number array
    //Expected outcome: Exception is thrown
    @Test
	public void nullObjectTo2DArrayTest() 
	{
		boolean testPassed = false;
		
		try {
			DataUtilities.createNumberArray2D(null);
		} catch (Exception e) {
			//exception was thrown
			testPassed = true;
		} finally {
			assertEquals("Method should throw exception.", true, testPassed);
		}
	}
    
    //By:Nolan Parmar
    //Boundary testing with least number of possible elements; passing in an empty 2D double array to turn into a Number array
    //Expected outcome:  empty Number array
    @Test
	public void empty2DArrayTest() 
    {
		double [][] test = {};
		Number [][] expected = {};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals(expected, actual);
	}
    
    //By:Nolan Parmar
    //Boundary testing 
    //passing in a 2D double array with more than 17 decimal places
    @Test
	public void moreThan17DecimalPlaces2DArrayTest() 
    {
		double [][] test = {{15.1234567890123456789}}; 
		Number [][] expected = {{15.12345678901234567}}; //last two decimal places are cut off
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals(expected, actual);
	}
	
    //By:Nolan Parmar
    //Equivalence test 
    // passing in a 2D double array with 1 row and 10 columns
    
    @Test
	public void tenByOne2DArrayTest() 
    {
		double [][] test = {{19.56782},{-19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782}};
		Number [][] expected = {{19.56782},{-19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals(expected, actual);
	}
    
    //By:Nolan Parmar
    //Equivalence test 
    //passing in a 2D double array with 10 rows and 1 column
    @Test
	public void oneByTen2DArrayTest() 
    {
    	
		double [][] test = {{19.56782, -19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782}};
		Number [][] expected = {{19.56782, -19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals(expected, actual);
	}
    
}
