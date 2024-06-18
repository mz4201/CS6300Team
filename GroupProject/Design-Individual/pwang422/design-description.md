1. Main Menu

When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers.

This requirement is realized by the MainMenu class, which contains methods enterCurrentJobDetails(), enterJobOffers(), adjustComparisonSettings(), and compareJobOffers(). These methods enable the user to access the respective functionalities from the main menu.

2. Enter Job Offers

When choosing to enter job offers, a user will be shown a user interface to enter all the details of the offer.

The JobOfferManager class maintains a list of Job objects in the jobOffers attribute. The addJobOffer(job: Job) and editJobOffer(job: Job) methods are used to add and edit job offers.

3.Enter/Edit Current Job Details

When choosing to enter current job details, a user will be shown a user interface to enter or edit all the details of their current job.

This requirement is realized by the JobOfferManager class, which contains an attribute currentJob of type Job to store the details of the current job. The addJobOffer(job) and editJobOffer(job) methods allow adding or editing job details.

4.Adjust Comparison Settings

When adjusting the comparison settings, the user can assign integer weights to various factors.

The JobOfferManager class contains a comparisonWeights to store weights for different factors. The adjustComparisonSettings() method in the MainMenu class updates the comparisonWeights

5.Compare Job Offers

When choosing to compare job offers, a user will be shown a list of job offers, displayed as Title and Company, ranked from best to worst, and including the current job

The JobOfferManager class has a method rankJobOffers() that calculates scores for job offers and returns a ranked list of Job objects. The compareJobOffers(job1, job2) method returns a ComparisonResult object that contains the comparison details

6. Ranking Jobs

A job’s score is computed as the weighted average of various factors

The JobOfferManager class's rankJobOffers() method calculates the job scores using the provided formula and weights, and returns a ranked list of Job objects

7. getAdjustedSalary() and getAdjustedBonus()

Yearly salary and yearly bonus should be adjusted for the cost of living in the job's location
