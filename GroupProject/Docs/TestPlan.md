# Test Plan

**Author**: Team32

## 1 Testing Strategy

### 1.1 Overall strategy

Since we’re a small team working on this assignment, we'll keep our testing strategy straightforward and manageable. 

**Unit Testing**: Each of us will test the individual parts of the code we write to make sure they work correctly on their own.

**Integration Testing**: Once we’ve verified that the individual pieces are working, we’ll start testing how they interact with each other. 

**System Testing**: After integration testing, we’ll test the entire app as a whole to make sure it meets all the requirements and behaves as expected. 

**Regression Testing**: Whenever we make changes or add new features, we’ll re-run our tests to make sure we haven’t broken anything that was working before. 

### 1.2 Test Selection

we'll use a mix of techniques, depending on what we're testing

**Unit Testing**(white-box testing):

statement coverage - We'll make sure every single line of code gets executed

branch coverage - every possible decision gets tested

path coverage - we follow all possible paths through the code 



**Integration Testing**(Both):

On the white-box side, we'll check how our units interact with each other. For black-box testing, we'll look at inputs and outputs



**System Testing**(Black-box testing):

We won't care how the code works inside. Instead, we'll use equivalence partitioning to test different ranges of input values
Do boundary value analysis to test the edge cases



**Regression Testing**(Black-box testing):

This will be mostly black-box testing. We'll run our automated test suite to ensure everything still works as expected after any changes





### 1.3 Adequacy Criterion

We will do functional coverage and structural coverage to test all the app’s functions and to get a high percentage of statement and branch coverage

### 1.4 Bug Tracking

We'll have a clear process for tracking bugs:

**Logging Bugs**: Whenever our team member finds a bug, they'll record all the details like a unique ID, a summary of the problem, a detailed description, steps to reproduce it, the severity of the bug, and its current status

**Prioritizing Bugs**: Bugs will be prioritized based on their impact on the app

**Tracking Progress**: We'll keep track of the status of each bug as it moves from being newly reported, to being worked on, to being resolved, and finally to being closed once it's verified fixed

### 1.5 Technology

JUnit for unit tests in our Java code, and Selenium for automating UI tests

## 2 Test Cases

### MainActivity

| Test ID | Purpose                          | Steps                    | Expected Result                                              | Actual Result | Pass/Fail | Additional Info |
| ------- | -------------------------------- | ------------------------ | ------------------------------------------------------------ | ------------- | --------- | --------------- |
| Test01  | Verify main menu options         | 1. Launch the app        | Main menu shows options: addJob, addOffer, editSettings, rankOffers |               |           |                 |
| Test02  | Navigate to AddJobActivity       | 1. Select 'addJob'       | User navigates to AddJobActivity                             |               |           |                 |
| Test03  | Navigate to AddOfferActivity     | 1. Select 'addOffer'     | User navigates to AddOfferActivity                           |               |           |                 |
| Test04  | Navigate to EditSettingsActivity | 1. Select 'editSettings' | User navigates to EditSettingsActivity                       |               |           |                 |
| Test05  | Navigate to RankOffersActivity   | 1. Select 'rankOffers'   | User navigates to RankOffersActivity                         |               |           |                 |

### AddJobActivity

| Test ID | Purpose                   | Steps                                                        | Expected Result                                              | Actual Result | Pass/Fail | Additional Info |
| ------- | ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------- | --------- | --------------- |
| Test06  | Enter current job details | 1. Activity is created (onCreate called), 2. Enter job details, 3. Save details | Job details are saved in UserModel, user returns to MainActivity |               |           |                 |
| Test07  | Cancel adding job details | 1. Enter job details, 2. Cancel                              | No job details are saved, user returns to MainActivity       |               |           |                 |

### AddOfferActivity

| Test ID | Purpose                 | Steps                                                        | Expected Result                                              | Actual Result | Pass/Fail |
| ------- | ----------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------- | --------- |
| Test08  | Enter job offer details | 1. Activity is created (onCreate called), 2. Enter job offer details, 3. Save offer | Job offer is saved in OffersModel, user can enter another offer, return to MainActivity, or compare offers |               |           |
| Test09  | Cancel adding job offer | 1. Enter job offer details, 2. Cancel                        | No job offer is saved, user returns to MainActivity          |               |           |
| Test10  | Compare job offers      | 1. Trigger comparison                                        | Comparison table shows adjusted values and results in CompareOffersActivity |               |           |



### EditSettingsActivity

| Test ID | Purpose                    | Steps                                                        | Expected Result                                              | Actual Result | Pass/Fail | Additional Info |
| ------- | -------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------- | --------- | --------------- |
| Test11  | Adjust comparison settings | 1. Activity is created (onCreate called), 2. Set weights for each factor, 3. Save settings | Weights are saved in UserModel settings, user returns to MainActivity |               |           |                 |
| Test12  | Cancel adjusting settings  | 1. Set weights for each factor, 2. Cancel                    | No changes are saved, user returns to MainActivity           |               |           |                 |

### 

### RankOffersActivity

| Test Case ID | Purpose            | Steps                                                        | Expected Result                                              | Actual Result | Pass/Fail |
| ------------ | ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------- | --------- |
| Test13       | Rank job offers    | 1. Activity is created (onCreate called), 2. Enter multiple job offers | Job offers are ranked correctly based on user settings and job details |               |           |
| Test14       | Compare job offers | 1.Trigger comparison                                         | Comparison table shows adjusted values and results in CompareOffersActivity |               |           |
| Test15       | Cancel rank offer  | 1. Enter multiple job offers,2.Cancel                        | No changes are saved, user returns to MainActivity           |               |           |

### CompareOffersActivity

| Test ID | Purpose                  | Steps                                                      | Expected Result                                              | Actual Result | Pass/Fail | Additional Info |
| ------- | ------------------------ | ---------------------------------------------------------- | ------------------------------------------------------------ | ------------- | --------- | --------------- |
| Test16  | Verify comparison output | 1. Select two job offers to compare, 2. Trigger comparison | Comparison table displays correct adjusted values for selected jobs |               |           |                 |
| Test17  | Cancel comparison        | 1. Select two job offers to compare, 2. Cancel             | User returns to RankOffersActivity without performing comparison |               |           |                 |

### 