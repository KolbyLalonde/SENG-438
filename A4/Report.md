**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group: Group Number 17     |
|-----------------|
| Student 1 Kolby Lalonde                |   
| Student 2 Sadman Shahriar              |   
| Student 3 Nolan Parmar              |   
| Student 4 Siddharth Menon           |   

# Introduction

The goals of this lab are to learn more about both muation testing and GUI testing. We will learn different tools to discover how these concepts work.


# Analysis of 10 Mutants of the Range class 

In this section we will look into a few of the Mutants reported by the PITest summary. For each Mutant we will show what has happenend provided in range code and explain why or why not the mutant has been killed.

## MUTANT #1.)

<img src="media/M1_mutant.png" alt="media/M1_mutant.png" width="600"/>

### Mutant 1 effects the getCentralValue() method

<img src="media/M1_class.png" alt="media/M1_class.png" width="600"/>

### Mutant 1 is killed by our getCentralValue() test

<img src="media/M1_test.png" alt="media/M1_test.png" width="600"/>

### Explanation

This mutant was killed by our unit test getCentralValue() seen above. This mutant changes the value of the 2.0 which divides the lower bound to 1.0. With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the value returned by exampleRange1.getCentralValue() will no longer be as expected 7.5. Instead since the exampleRange1 has range (5.0,10.0) the new calculation returned is (5.0/1.0) + (10.0/2.0) = 10.0. This does not match the previous expected value of 7.5 and is why the mutant is killed in this scenario.

## MUTANT #2.)

<img src="media/M2_mutant.png" alt="media/M2_mutant.png" width="600"/>

### Mutant 2 effects the intersects(Range range) method

<img src="media/M2_class.png" alt="media/M2_class.png" width="600"/>

### Mutant 2 is killed by our getIntersectsTestUpperBound() test

<img src="media/M2_test.png" alt="media/M2_test.png" width="600"/>

### Explanation

This mutant was killed by our unit test getIntersectsTestUpperBound() seen above. This mutant changes the return boolean to a fixed value of false. With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the value returned by exampleRange1.getCentralValue() will no longer be as expected true but rather false. Since the exampleRange1 has range (5.0,10.0) and the exampleRange3 has range (8.0,15.0) we expect a true result for overall in this test. The fixed false result does not match the previous expected result of true and is why the mutant is killed in this scenario.

## MUTANT #3.)

<img src="media/M3_mutant.png" alt="media/M3_mutant.png" width="600"/>

### Mutant 3 effects the contains() method

<img src="media/M3_class.png" alt="media/M3_class.png" width="600"/>

### Mutant 3 should be killed by our containsValueInRange() test

<img src="media/M3_test.png" alt="media/M3_test.png" width="600"/>

### Explanation

This mutant survived our unit test case as seen above. This particular mutant changes the value of the local variable given as 1 to be a -1. This mutant is not caught for our test because the example range we are using is (-5.5,11.1). Therefore both 1 and -1 are inside the range. So despite adding the mutant the test case will still pass as -5.5 is less than -1.0 and 11.1 is larger than -1.0. If we wanted this test case to kill this particular mutant, we would need to choose an example range with a lower bound greater than -1.0 so the mutant would not fall within the range. This would cause the test case to fail and the mutant would be killed.

## MUTANT #4.)

<img src="media/M4_mutant.png" alt="media/M4_mutant.png" width="600"/>

### Mutant 4 effects the getLength() method

<img src="media/M4_class.png" alt="media/M4_class.png" width="600"/>

### Mutant 4 is killed by our getLengthPositiveRange() test

<img src="media/M4_test.png" alt="media/M4_test.png" width="600"/>

### Explanation

This mutant was killed by our unit test getLengthPositiveRange() seen above. This mutant changes the sign of the return value statement from a negative to a positive. With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the value returned by exampleRange1.getLength() will no longer be as expected 5.0. Instead since the exampleRange1 has range (5.0,10.0) the new calculation returned is 5.0 + 10.0 = 15.0. This does not match the previous expected value of 5.0 and is why the mutant is killed in this scenario.

## MUTANT #5.)

<img src="media/M5_mutant.png" alt="media/M5_mutant.png" width="600"/>

### Mutant 4 effects the toString() method

<img src="media/M5_class.png" alt="media/M5_class.png" width="600"/>

### Mutant 4 is killed by our testToString() test

<img src="media/M5_test.png" alt="media/M5_test.png" width="600"/>

### Explanation

This mutant was killed by our unit test testToString() seen above. This mutant changes the expected return string created by the method to an empty string "". With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the string returned by exampleRange4.toString() will no longer be "Range[-5.5,11.1]" as expected. Instead since the returned string is just "" which does not match the previous expected string and is why the mutant is killed in this scenario.


# Report all the statistics and the mutation score for each test class

### Range Class Mutation Coverage Before = 54%

<img src="media/Range_Before.png" alt="media/Range_Before.png" width="900"/>

### DataUtilities Class Mutation Coverage Before = ?????

Note: These previous test suites from assignment 3 may have contained tests which failed or had errors. These had to be removed in order to run the mutation test.

### Range Class Mutation Coverage After = 64% (Goal increase 10%)

### DataUtilities Class Mutation Coverage After = ????? (Goal increase 10%)


# Analysis drawn on the effectiveness of each of the test classes

### RangeTest (Analysis and Design Strategy)

Reviewing the effectiveness of our mutation coverage on the range test class we created we noticed a few key factors. The first is that our original mutation coverage was only 54%. We found this somewhat suprising as we had previously found high coverages for this class in assignment 3. After reviewing the summary log, it was dizcovered that some areas of the code we were not being tested as closely as we had anticapated. We found that from the log there were areas where many mutants were surviving. Many of these mutant were mutants effecting the same code lines. Our plan was to target these mutants by writing new test cases into or previous test suites to increase the mutation coverage by killing numerous mutants in a singular test. We found a few areas in the class itself where many mutants surived. These included methods intersects(), expands() and combineIgnoringNaN(). So our plan was to target these classes with new, detailed and specific test cases to increase mutation coverage over the 10% mark. In the end our new tests starting on line 879 of the code included. However it should be noted that equivalence mutants do effect mutation score accuracy negatively as we will describe in more depth below.

getIntersectsTestUpperBoundCloseMatch(), getIntersectsTestLowerBoundCloseMatch(), getIntersectsTestInside(), testCombineIgnoringNaNWithUpperNaN(), testCombineIgnoringNaNWithLowerNaN()....

### DataUtilities (Analysis and Design Strategy)

...

# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants have a very negative effect on mutation score accuracy. In this lab we have treated mutation score to be the same as mutation coverage for purposes of the limitations of PITest. This is where the mutation score is equal to the (total mutants killed / all mutants). However, in an ideal calculation for mutation score we would not want to have equivalent mutants included in the mutation score. We would want to target a mutation score calculation that is (total mutants killed / all mutants which are not equivalent). This is because the definition of a equivalence mutant is a mutant which acts in the same behaviour as the program. If this was the case than these mutants are not really program bugs at all. Rather, a equivalence mutant is just the same code we are testing written in a different way that works the same. Therefore we are not really expecting a equivalence mutant to ever be killed as it really is not a program bug at all. With these equivalence mutants included in our mutation score accuracy we can see that the will actually dilute the level of mutation score accuracy as we are expecting to kill mutants which are not actually intended to be killed as they properly reflect the intentions of what the program should be doing. Therefore equivalent mutants being added to mutation score will actually produce a mutation score that is lower than that of the true mutation score. Equivalent mutants may be detected by hand if you are to review all survived mutants in the code in detail. However the majority of time equivalence mutation detection is a undecidable problem.

# A discussion of what could have been done to improve the mutation score of the test suites

Refelecting on our experince working with PITest and mutation testing we have learned a valuable new skill. We imporved our test suites mutation coverage to an extent however we could have done even more to imporve this. Our plan to contiune imporving the mutation coverages would have been extremly similar to that of the imporvements we made in this lab. The way to maximize mutation coverage increase is to target mutants affecting the same lines. This is because killing multiple mutants with one test is much more efficent than writing a whole test to target only a singular mutant at a time. We would expect a point were it would be extremely diffuclt to catch all mutants without very specific tests. For example or RangeTest.java suite now has over 50 unit tests but still not even over 70% mutation coverage. We would need to contiune to create even more specialized tests by directly reviewing the summary log to catch even more mutants and improve the mutation score of our test suites.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

...

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
