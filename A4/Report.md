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

### MUTANT #1.)

Info

Mutant 1 reported as KILLED

Mutant 1 effects the getCentralValue() method

Mutant 1 should be killed by our getCentralValue() test

Explanation

This mutant was killed by our unit test getCentralValue() seen above. This mutant changes the value of the 2.0 which divides the lower bound to 1.0. With this happening our test will now fail and thus kill the mutant as reported. Our test fails with this mutant as the value returned by exampleRange1.getCentralValue() will no longer be as expected 7.5. Instead since the exampleRange1 has range (5.0,10.0) the new calculation returned is (5.0/1.0) + (10.0/2.0) = 10.0. This does not match the previous expected value of 7.5 and is why the mutant is killed in this scenario.


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
