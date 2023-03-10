>   **SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#1 – Introduction to Testing and Defect Tracking**

| Group: Group Number 17     |
|-----------------|
| Student 1 Kolby Lalonde                |   
| Student 2 Sadman Shahriar              |   
| Student 3 Nolan Parmar              |   
| Student 4 Siddharth Menon           |   


**Table of Contents**

(When you finish writing, update the following list using right click, then
“Update Field”)

[1 Introduction	1](#_Toc439194677)

[2 High-level description of the exploratory testing plan	1](#_Toc439194677)

[3 Comparison of exploratory and manual functional testing	1](#_Toc439194679)

[4 Notes and discussion of the peer reviews of defect reports	1](#_Toc439194680)

[5 How the pair testing was managed and team work/effort was
divided	1](#_Toc439194681)

[6 Difficulties encountered, challenges overcome, and lessons
learned	1](#_Toc439194682)

[7 Comments/feedback on the lab and lab document itself	1](#_Toc439194683)

# Introduction

In this lab we were given a program that's purpose is to allow the user to deposit, withdraw, query and transfer funds to/from his/her hypothetical bank account(s). The goal would be to use our knowledge of different testing methods to gain a basic understanding of new software testing concepts. Three key concepts we will discover from the lab are:

1.) Practical experience in testing a software system.

2.) Knowledge of the differences between exploratory, manual scripted, and regression testing.

3.) Familiarity with industrial defect tracking systems, processes, and practices.

Before starting this lab our knowledge of exploratory and manual functional testing was limited to what we learned in lectures. This was that exploratory testing is all about testing the system as you use it. There is no exact plan to test the functionality of thr system but rather ideas for testing are discovered as you go. However, with the manual function testing scripts are designed to lay out the exact way the program will be tested. This script will include test cases and steps which are documented. No deviation from the original testing plans will be made. In short, an exploratory test is dynamic and may change where a manual test has a strict plan to abide by. Our understanding of these methods are to be further developed through the completion of this lab.


# High-level description of the exploratory testing plan

To accomplish the exploratory testing portion of the assignment we have created the following plan. We will begin by categorising the testing to target each of the specific use cases. We want to test the specific functions of system startup/shutdown, PIN entry and transactions such as withdraw, deposit or transfer. By testing each use case to some extent we will better understand the system as a whole. Our approach will be to test the broad scope of the system rather than only a few functions extensively. Our test cases will follow the most common paths of the system to determine whether the function is working as expected or has underlying issues.

# Comparison of exploratory and manual functional testing

Comparing the results of the exploratory testing to the manual testing we found that many of the bugs found in each overlapped. The exploratory testing was better at finding issues in the program which where small such as the spelling or grammar errors. However, when looking to test the functionality of certian use cases of the system the manual funtional testing was both more efficent and effective. An example of this can be seen with the withdraw funtionality. In our exploratory testing we found that the withdraw had some errors with returning correct funds. In the manual scripted testing we discovered that much more was wrong with the withdraw including checking if the system had the sufficent funds to process such a request. The Report.pdf file added to the repo holds the detailed bug reports we created using Jira. Throughout both the exploratory and manual function testing we discovered how various bugs can be discovered in two completely different methods. 

# Notes and discussion of the peer reviews of defect reports
To complete the pair testing portion of this assignment our team of 4 was split into teams of 2 with Kolby and Sadman as a team and Nolan and Siddharth as the other teams. How each group handled dividing the work/effort in this portion of the assignment is described in the sections below.

Pair1: Kolby and Sadman (Peer Review of Pair2)

After reviewing the bug reports provided by our other group members, we discovered that they had found very similar tests to that of our own. However their reports were initailly a little weak in a few of the steps provided by the lab handout under the writing effective bug reports section. In the future we think its important that they take more care in writing the detailed state and steps of the system explicitly stating the functionality they are testing. Providing more screenshots may better improve the quality of the reports. Overall, their tests were effective in describing the issues of the system.


Pair2: Nolan and Siddharth (Peer Review of Pair1)

After going through the defect reports that were completed by the other pair, we analayzed that the tests were very detailed and effective defect reports. They divided the work in logical section and provided insightful screenshots on how the defect was found and the expected outcome should have been. In the future we think they should continue to create consistent defect reports like they are doing now. They could add the actual outcome explicitly in its own section though instead of just through the title to make it more clear.

# How the pair testing was managed and team work/effort was divided 

How each group handled dividing the work/effort in the pair testing portion of the assignment is described in the sections below.

Pair1: Kolby and Sadman

To divide the work we each wanted to have a turn to learn the system and its capabilities. We each played around trying to find an issue with each main capability while the other could record the issue and provide feedback. We then worked on creating our own bug reports for the issues we each discovered. In total we both put in an equal amount of effort while working through the exploratory pair testing portion of this assignment.

Pair2: Nolan and Siddharth

We divided the work by having one member conducting the tests on the software application while the other would review and analyze the results of the tests with the appendix or look for outright errors. We would then switch roles after every few tests so we could both learn the process and from each other. This technique made sure both of us were putting the same amount of effort and work into the testing process.

# Difficulties encountered, challenges overcome, and lessons learned

This first assignment gave us a few challenges that has taught us a few valuable lessons. Learning how a new bug testing software Jira worked was a challenge intially. With little knowledge we had to make sure the whole team was able to keep on track and up to speed to finish the assignment. In future labs our group plans to work through these issues sooner rather than later. This will give us more time to modify and perfect our assignment. Another diffuclty we faced was trying to schedule meetings where we could all collaborate at one time to preform the group testing portion of this assignment. From this we learned that it will be critical to use the lab period to work on the group work portion of any assignment. To save us time in the labs we will come more prepared as a group by reading over the assignment and understanding the tasks beforehand. This way we will be better prepared to get straight into working. The lab itself taught us the importance of good communication in teamwork.

# Comments/feedback on the lab and lab document itself

As a group we found this lab to be quite informative on the different testing methods of exploratory, manual funtional and regression. However, our group struggled getting started on this assignment as we had never used a bug tracking software such as Jira before. Perhaps in future labs more guidance can be provided through a quick lab overview video. In regrads to the lab document itself we had very few previous experinces with a github upload style such as this. We had a little confusion over what exact forms we were to be submitting things so a detailed example of what a github repo submission should look like may be a great resource to add in future assignments.
