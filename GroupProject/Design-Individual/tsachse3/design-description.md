1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

The user starts using the application by viewing the MainPage. The main page UI can trigger one of four methods: addJob, addOffer, editSettings, or compareOffers. These different methods can each spawn their own respective pages. Information about the user is stored in the User class. Available offers are stored as a list of Job class instances. The current user information and available offers can be stored or loaded from disk with a Storage class instance.


2. When choosing to enter current job details, a user will be shown a user interface to enter (if it is the first time) or edit all the details of their current job.

The user triggers the addJob method which launches the AddJobPage. This page contains a form to add or modify the user's job. The addJob method takes the User instance as an argument.


3. User must be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

When executing the addJob method, if the AddJobPage modifies the user (which contains a 'job' attribute) then that modified user is returned from the method. If no modifications are made then an Optional.Empty is returned. The MainPage handles these two cases upon return.


4. When choosing to enter job offers, a user will be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

The addOffer method launches an AddOfferPage which provides a form to create a new offer (a Job instance).


5. User must be able to either save the job offer details or cancel.

If the user chooses to save via a button, the Job instance is added to the provided offers list and the list is returned via the addOffer method. If the user cancels, Optional.Empty is returned. The MainPage handles these two cases.


6. User must be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

The AddOfferPage can include a button to launch another AddOfferPage recursively. The return to the main menu happens by default otherwise. Another button can trigger the CompareOffersPage.


7. When adjusting the comparison settings, the user can assign integer weights to available categories.

The editSettings method in the MainPage launches a EditSettings page for the current user. This page has a form for the various settings. The form is preloaded with the settings in the current user (passed via the method). If modifications are made the modified user is returned via editSettings. If no modifications, the method returns Optional.Empty. The MainPage handles both of these cases.


8. When choosing to compare job offers, a user will be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

The MainPage launches a CompareOffersPage with two jobs as arguments (the jobs to compare) and a user instance (which contains a settings attribute). This information is routed to a Comparator instance in the CompareOffersPage which contains the logic required to rank the jobs.


9. User must be able to select two jobs to compare and trigger the comparison.

This is done in the UI of the MainPage.


10. When comparing, user must be shown a table comparing the two jobs.

The CompareOffersPage displays a table with the details of the two jobs.


11. User must be offered to perform another comparison or go back to the main menu.

Users will go back to the MainPage to select another pair of jobs.


12. When ranking jobs, a job’s score is computed as the weighted average of a big formula.

This ranking takes place in the compare() method of the Comparator used by the CompareOffersPage.


13. The user interface must be intuitive and responsive.

This is hopefully covered by the layout of the pages and direct mapping to the desired actions.


14. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

This app doesn't have any networking or communication component. All information is stored on disk via the Storage class.
