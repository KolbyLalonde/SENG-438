**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group: Group Number 17     |
|-----------------|
| Student 1 Kolby Lalonde                |   
| Student 2 Sadman Shahriar              |   
| Student 3 Nolan Parmar              |   
| Student 4 Siddharth Menon           |   

# Introduction


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

This mutant was killed by our unit test getLengthPositiveRange() seen above. This mutant changes the sign of the return value statement from a negative to a positive. With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the value returned by exampleRange1.getCentralValue() will no longer be as expected 5.0. Instead since the exampleRange1 has range (5.0,10.0) the new calculation returned is 5.0 + 10.0 = 15.0. This does not match the previous expected value of 5.0 and is why the mutant is killed in this scenario.




# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
