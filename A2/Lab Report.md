**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  17   |
| -------------- | --- |
| Student Names: |   Kolby Lalonde  |
|                |   Sadman Shahriar  |
|                |   Nolan Parmar  |
|                |   Siddharth Menon  |

# 1 Introduction

In this lab we where given the task of creating unit tests for different methods of the org.jfree.data.Range and org.jfree.data.DataUtilities in the  package org.jfree.data. We will complete this using eclipse IDE and Junit. Our learning objectives for this lab are as follows:

1.) Create automated test code using JUnit and other XUnit testing frameworks such as NUnit.

2.) Incorporate and work with mock objects in test code development.

This lab will be an oppurtunity to develop our understanding of debbugging code through unit tests. We also will learn valuable skills in teamwork and planning to successfully complete this lab.


# 2 Detailed description of unit test strategy

The purpose of this black-box testing is to scrutinize the requirements for each method and create tests solely based on those requirements, without looking at the source code. We did equivalence classes and boundary value analysis. To create equivalence classes, we will list each type of input for an individual method. After listing every possible type of input, the pair will identify any inputs which are similar and will provide the same expected output. These groupings will be the classes, and thus when creating test cases. This will lead to a more efficient testing process.To cover all edge cases, we will look towards performing boundary-value analysis. To do so, we will look at the boundaries of the equivalence classes, and choose an input that lies on that boundary, or just outside of it. For example, if the JavaDocs specify that the input range of a variable is [0, 10], boundary test cases would be to provide an input of -1, 0, 10, and 11. These test cases allow the program specifications to be held accountable and ensures that those edge cases are properly handled by the system.

 Methods Being Tested:
 
  Range:
  
  R1.) contains(double value)
  
  R2.) combine(Range range1, Range range2)
  
  R3.) getLength(Range range1, Range range2)
  
  R4.) getLowerBound(Range range1, Range range2)
  
  R5.) getUpperBound(Range range1, Range range2)
  
  DataUtilities:
  
  D1.) createNumberArray(double[] data)
  
  D2.) createNumberArray2D(double[][] data)
  
  Designed Partitions:
  
  R1.) Test Ranges: R1(-5.5,11.1), R2(null)
 |Partition| Class: Range   |Method: contains  |
|---| -------------- | --- |
|A| Range 1 | X < -5.5 Invalid |
|B| Range 1 |  X > -5.5 and X < 11.1 Valid  |
|C| Range 1 |  X = -5.5 Valid  |
|D| Range 1 |  X = 11.1 Valid  |
|E| Range 1 | X > 11.1 Invalid|
|F| null | Invalid on all X |
|G| Range 1 | X = Central Value |

R2.)
Test Ranges: R1(5,10), R2(-5, 5), R3(8, 15), R4(null)
|Partition| Class: Range   |Method: combine  |
|---| -------------- | --- |
|A| Range 1 , Range 2 | Valid Range(-5,10) |
|B| Range 2 , Range 1 | Valid Range(-5,10) |
|C| Range 1 , null | Valid Range(5,10) |
|D| null , Range 2 | Valid Range(-5,5) |
|E| null , null | Valid Range(null) |
|F| Range 1 , Range 1 | Valid Range(5,10) |
|G| Range 1 , Range 3 | Valid Range(5,15) |
|H| Range 3 , Range 1 | Valid Range(5,15) |
|I| Range 3 , Range 2 | Valid Range(-5,15) |
|J| Range 2 , Range 3 | Valid Range(-5,15) |

  R3.) Test Ranges: R1(5.0,10.0), R2(5.0,5.0),R3(-10.0,-5.0) ,R4(10.0,5.0)
 |Partition| Class: Range   |Method: getLength  |
|---| -------------- | --- |
|A| Range 1 | X = 5.0 Valid |
|B| Range 2 |  X = 0 Valid  |
|C| Range 3 |  X = 5.0 Valid  |
|D| Range 4 |  Invalid on All X |

  R4.) Test Ranges: R1(5.0,10.0), R2(5.0,5.0),R3(-10.0,-5.0) ,R4(10.0,5.0)
 |Partition| Class: Range   |Method: getLowerBound  |
|---| -------------- | --- |
|A| Range 1 | X = 5.0 Valid |
|B| Range 2 |  X = 5.0 Valid  |
|C| Range 3 |  X = -10.0 Valid  |
|D| Range 4 |  Invalid on All X |

  R5.) Test Ranges: R1(5.0,10.0), R2(5.0,5.0),R3(-10.0,-5.0) ,R4(10.0,5.0)
 |Partition| Class: Range   |Method: getUpperBound  |
|---| -------------- | --- |
|A| Range 1 | X = 10.0 Valid |
|B| Range 2 |  X = 5.0 Valid  |
|C| Range 3 |  X = -5.0 Valid  |
|D| Range 4 |  Invalid on All X |
  
 D1.) Test Arrays: A1{null}, A2{-9.7, -100.55, -99.7777}, A3{345.345345345, 7.777777777}, A4{1, 2, 3, 4}, R5{20.65423156, -78.17, 11} 
 |Partition| Class: DataUtilities   |Method: createNumberArray  |
|---| -------------- | --- |
|A| Array 1 | null input|
|B| Array 2 |  X = negative double inputs Valid  |
|C| Array 3 |  X = positive double input types invalid  |
|D| Array 4 |  X =  integer input invalid |
|E| Array 5 |  X =  mixed input invalid |

D2.) Test Arrays: A1{null}, A2{}, A3{15.1234567890123456789}, A4{{19.56782},{-19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782},{19.56782}}, A5{{19.56782, -19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782, 19.56782}}
 |Partition| Class: DataUtilities   |Method: createNumberArray2D  |
|---| -------------- | --- |
|A| Array 1 | null input|
|B| Array 2 |  X = empty array Valid  |
|C| Array 3 |  X = more than 17 decimal places invalid  |
|D| Array 4 |  X = 2D array with 1 row and 10 comlumns invalid |
|E| Array 5 |  X =  2D array with 10 rows and 1 column invalid |
 
D3.) Test Tables: A. 2D 2x2 matrix with a value index (0,0) of 0. B. 2D 2x2 matrix with a value index (0,0) of 2.5. C. 2D 2x2 matrix with a value index (0,0) of (2.5, 7.5).
|Partition| Class: DataUtilities   |Method: calculateColumnTotal  |
|---| -------------- | --- |
|A| Table 1 | table = {(0, 0), (0, 0) checks for empty with 0 values,function returns 0 valid |
|B| Table 2 |  X = 7.5, single column total valid  |
|C| Table 3 |  X = 10.0, multiple column total valid  |

D4.) Test Tables: A. 2D 2x2 matrix with a value index (0, 0) of 0. B. 2D 2x2 matrix with a value index (5.5,0) of (0,0) C. 2D 2x2 matrix with a value index (5.5, 6,5) of (0, 0).
|Partition| Class: DataUtilities   |Method: calculateRowTotal  |
|---| -------------- | --- |
|A| Table 1 | table = {(0,0), (0,0) checks for empty with 0 values,function returns 0 valid |
|B| Table 2 |  X = 5.5, single row total valid  |
|C| Table 3 |  X = 12.0, multiple row total valid  |

D5.) Test keyedvalues: A. {(0,5), (1, 3)}  B. {(0,5), (1, 3), (2, 1), (3, 7}
|Partition| Class: DataUtilities   |Method: getCumulativePercentages   |
|---| -------------- | --- |
|A| keyedvalues 1 | X = 1 (100 percent) invalid |
|B| keyedvalues 2 |  X = 0.3, (31 percent) invalid  |

 
  Test Determination Procedure:
  
  Benefits and Drawback of using Mocking:
Mocking is a very useful concept which allows for more efficient unit testing. However, it does contain drawbacks. One of the major benefits of mocking is that it allows users to partially simulate behavior of an object, based on the parts on which they are testing. This leads to a more efficient process as time is not spent creating the components of the object which will not be tested upon in each individual test. As such, isolation of particular functionality becomes much easier. One drawback is that each component must be individually set/determined, which could lead to a larger setup time before testing even begins. As such, it is imperative to use mocking only when the time saved outweighs the time spent on setting each value in the object.
 

# 3 Test cases developed

  R1.) 
  Method: Contains
 |Partition| Test Name  |
|---|  --- |
|A| containsValueBelowRange() |
|B| containsValueInRange() |
|C| containsValueIsRangeLowerBound()|
|D| containsValueIsRangeUpperBound()|
|E| containsValueAboveRange()|
|F| containsWithNullRange() |
|G| containsValueIsRangeCentralValue() |

R2.)
Method: Combine
|Partition|Test Name|
|---| --- |
|A| combineLargerRangeOne()) |
|B| combineSmallerRangeOne()) |
|C| combineNullRangeTwo() |
|D| combineNullRangeOne() |
|E| combineNullRanges() |
|F| combineSameRanges() |
|G| combineOverlapingRangesSmallFirst() |
|H| combineOverlapingRangesLargeFirst() |
|I| combineDistjointedRangesLargeFirst() |
|J| combineDistjointedRangesSmallFirst() |

R3.)
Method: getLength
|Partition| Test Name  |
|---|  --- |
|A| getLengthPositiveRange() |
|B| getLengthZeroRange() |
|C| getLengthNegativeRange() |
|D| getLengthLargeNumberFirstRange() |

R4.)
Method: getLowerBound
|Partition| Test Name  |
|---|  --- |
|A| getLowerBoundPositiveRange() |
|B| getLowerBoundZeroRange() |
|C| getLowerBoundNegativeRange() |
|D| getLowerBoundLargeNumberFirstRange() |

R5.)
Method: getUpperBound
|Partition| Test Name  |
|---|  --- |
|A| getUpperBoundPositiveRange() |
|B| getUpperBoundZeroRange() |
|C| getUpperBoundNegativeRange() |
|D| getUpperBoundLargeNumberFirstRange() |

D1.) 
Method: createNumberArray 
 |Partition| Test Name|
|---| -------|
|A| testCreateNumberArrayNullData22()|
|B| createNumberArrayNegativeDoublesTest()  |
|C| createNumberArrayPositiveDoublesTest() |
|D| createNumberArrayIntsTest() |
|E| createNumberArrayMixedTest() |

D2.) 
Method: createNumberArray2D
 |Partition| Test Name  |
|---| --- |
|A|  nullObjectTo2DArrayTest() |
|B| empty2DArrayTest()  |
|C| moreThan17DecimalPlaces2DArrayTest()   |
|D| tenByOne2DArrayTest()  |
|E| oneByTen2DArrayTest() |


D3.) 
Method: calculateColumnTotal
 |Partition| Test Name  |
|---| --- |
|A| testEmptyTable() |
|B| testCalculateColumnTotalForASingleColumn()  |
|C| testCalculateColumnTotalForMultipleColumns()   |


D4.) 
Method: calculateRowTotal
 |Partition| Test Name  |
|---| --- |
|A| testEmptyTable() |
|B| testCalculateRowTotalForASingleRow()   |
|C| testCalculateRowTotalForMultipleRows()  |


D5.) 
Method: getCumulativePercentages
 |Partition| Test Name  |
|---| --- |
|A| testGetCumulativePercentagesCumulatesOneValue()  |
|B| testGetCumulativePercentagesCumulatesTwoValues()   |



# 4 How the team work/effort was divided and managed

To divide the workload of this lab fairly we where given 10 methods to test with 5 from .DataUtilities and 5 from .Range. We decided it would be fair to have two group members handle two methods and two group members handle three methods. The group members tasked with only two methods would be responsible for picking up the extra work by collaborating to write the lab report. The inital divison of work was as follows:

org.jfree.data.Range

Kolby - Two methods tested (combine and contains) + writing report .md

Siddharth - Three methods tested (getLowerBound, getUpperBound and getLength)

org.jfree.data.DataUtilities

Nolan - Two methods tested (createNumberArray and createNumberArray2D) + writing report .md

Sadman - Three methods tested (calculateColumnTotal, calculateRowTotal and getCumulativePercentages)

An agreement was made and expectation was all group members would be willing to provide feedback/guidance to others in cases of confusion. In the end all group members collborated and worked equally on this lab. Each member had a chance to walkthrough all 10 methods tested afterwards to gain a proper understanding of all learning objectives presented. We learned from this process that it is resonable to work individually on small tasks and then collabroate once everyone has had a chance to work in order complete a project.

# 5 Difficulties encountered, challenges overcome, and lessons learned

The main diffuclties we discovered in this lab were with learning how to create JUnit tests on eclipse. We all had little to no experience ever using the eclipse IDE. However we overcame this issue by working as a team through the familiarization portion of this lab. We learned many new lessons in teamwork and delegating equal workload to individuals. Another challenge we encountered was trying to figure out the best way to plan or design our unit test. We knew we wanted to test all possible cases in the partitions we planned. Researching exactly how the methods worked before testing them was something we where fairly unfarmilar with. The majority of the bug testing and troubleshooting experince we had is with an exploratory approach. Ultimatly this lab gave us the opportunity to impove our skills in debugging software by creating a plan for how to test a program.
Mocking was a comparatively more complicated concept to completely understand. We took time to discuss it between our teammates and studied individually to develop a better understanding of it. We learned that mocking can be a really useful tool, specially when software needs to be developed within a short period of time. Mocking allows the development of test cases parallel to the software's development.

# 6 Comments/feedback on the lab itself

Overall, we found this lab to be more straightfoward than the first lab. This was likly because we now have some experince now with working on a lab in this format. We enjoyed this lab and getting to write code and work with JUnit tests. Some minor feedback we have for future labs may include providing more explanation on how to work with new forms of software such as eclipse in a video demo. We found the beginning stages of setting up the lab to be somewhat diffcult with only the instructions in the lab document. However, we were still able to complete this lab with minimal setbacks/issues.
