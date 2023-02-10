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
 Methods Being Tested:
 
  Range:
  
  R1.) contains(double value)
  
  R2.) combine(Range range1, Range range2)
  
  DataUtilities:
  
  D1.) createNumberArray(double[] data)
  
  D2.) createNumberArray2D(double[][] data)
  
  Designed Partitions:
  
  R1.) Test Ranges R1(-5.5,11.1), R2(null)
  | Class: Range   |Method: contains  |
| -------------- | --- |
| Range 1 | X < -5.5 Invalid |
| Range 1 |  X > -5.5 and X < 11.1 Valid  |
| Range 1 |  X = -5.5 Valid  |
| Range 1 |  X = 11.1 Valid  |
| Range 1 | X > 11.1 Invalid|
| null | Invalid on all X |

R2.)
Test Ranges R1(5,10), R2(-5, 5), R3(8, 15), R4(null)
| Class: Range   |Method: combine  |
| -------------- | --- |
| Range 1 , Range 2 | Valid Range(-5,10) |
| Range 2 , Range 1 | Valid Range(-5,10) |
| Range 1 , null | Valid Range(5,10) |
| null , Range 2 | Valid Range(-5,5) |
| null , null | Valid Range(null) |
| Range 1 , Range 1 | Valid Range(5,10) |
| Range 1 , Range 1 | Valid Range(5,10) |
| Range 1 , Range 3 | Valid Range(5,15) |
| Range 3 , Range 1 | Valid Range(5,15) |
| Range 3 , Range 2 | Valid Range(-5,15) |
| Range 2 , Range 3 | Valid Range(-5,15) |
  
  Test Determination Procedure:
  
  Benefits and Drawback of using Mocking:
Mocking is a very useful concept which allows for more efficient unit testing. However, it does contain drawbacks. One of the major benefits of mocking is that it allows users to partially simulate behavior of an object, based on the parts on which they are testing. This leads to a more efficient process as time is not spent creating the components of the object which will not be tested upon in each individual test. As such, isolation of particular functionality becomes much easier. One drawback is that each component must be individually set/determined, which could lead to a larger setup time before testing even begins. As such, it is imperative to use mocking only when the time saved outweighs the time spent on setting each value in the object.
  
// including the input partitions you have designed
// including the input partitions you have designed

# 3 Test cases developed

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

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

The main diffuclties we discovered in this lab were with learning how to create JUnit tests on eclipse. We all had little to no experince ever using the eclipse IDE. However we overcame this issue by working as a team through the familiarization portion of this lab. We learned many new lessons in teamwork and delegating equal workload to individuals.

# 6 Comments/feedback on the lab itself

Overall, we found this lab to be more straightfoward than the first lab. This was likly because we now have some experince now with working on a lab in this format. We enjoyed this lab and getting to write code and work with JUnit tests. Some minor feedback we have for future labs may include providing more explanation on how to work with new forms of software such as eclipse in a video demo. We found the begin stages of setting up the lab to be somewhat diffcult with only the instructions in the lab document. However, we were still able to complete this lab minimal setbacks/issues.
