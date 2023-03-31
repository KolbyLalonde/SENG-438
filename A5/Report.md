**SENG 438- Software Testing, Reliability, and Quality**

**Lab. Report \#5 – Software Reliability Assessment**

| Group: Group Number 17     |
|-----------------|
| Student 1 Kolby Lalonde                |   
| Student 2 Sadman Shahriar              |   
| Student 3 Nolan Parmar              |   
| Student 4 Siddharth Menon           |   

# Introduction

In this lab we will learn how to use reliability assessment tools to review integration test data. The two ways we will look into are 

  1. Reliability growth testing
  2. Reliability assessment using Reliability Demonstration Chart (RDC)

Both of which will be studied in this project.

# 

# Assessment Using Reliability Growth Testing 

# Assessment Using Reliability Demonstration Chart 

### 3 Plots for MTTFmin, Double MTTFmin and Half MTTFmin

### MTTFmin

<img src="media/Regular.png" alt="media/Regular.png" width="600"/>

### Double MTTFmin

<img src="media/Double.png" alt="media/Double.png" width="600"/>

### Half MTTFmin

<img src="media/Half.png" alt="media/Half.png" width="600"/>

### Explanation of the decided MTTFmin value

After the intial setting up of test data was input into our RDC we had to modifiy to a couple parameters inorder to obtain a useful RDC. First we explored how changing the maximum number of acceptable failures variable would affect our chart. It was discovered that increasing this variable would push our data to the left and cause for likely rejection. The other variable we changed was the number of input events. We found that the larger this was the more the data points would move to the right into the acceptable region. Our method for finding a useful MTTFmin was to get a ratio which would keep our data in the middle yellow region for the majority of the intervals. This is because it would provide a more accurate review of the reliability of the system. 

We ultimately spent a fair amount of time testing this ratio by increasing the max acceptable number of failures by 10 each time and the input events by 50 each time. We discovered that when the max acceptable number of failures was 100 and the input events was 5000 we had the best results. Therefore we preformed our MTTFmin calculation as follows. 

MTTFmin = (Max Acceptable Failures / Input Events) = (100/5000) = 0.02

our calculations for the other two RDC charts seen above where as follows

DoubleMTTFmin = (Max Acceptable Failures / Input Events) = (150/3750) = 0.04

HalfMTTFmin = (Max Acceptable Failures / Input Events) = (60/6000) = 0.01

The results of these three graph show how changing a RDC MTTFmin ratio can effect the result of the reliability. As we can now see if MTTFmin is larger then it is easier for the test data to pass and cross into the acceptable region. However, reducing MTTFmin will have the opposite effect as it will be more likely that the data with cross into the rejection region. This makes sense as larger MTTFmin has greater maximum number of acceptable failures to events which are input. Therefore we are allowing the system to fail more often and still accepting its reliability. Smaller MTTFmin let there be less acceptable failures which will make it harder to pass on the RDC as we have seen above.

### Advantages and Disadvantages of RDC

# Comparison of Results

# Discussion on Similarity and Differences of the Two Techniques

# How the team work/effort was divided and managed

# 

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
