# Team 032 - CS6300 Summer 2024 - Design Description

### When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

The user interface is composed of several Activity classes:

`MainActivity` serves as the entry point, providing navigation to other activities.
`AddJobActivity` allows users to input or edit their current job details, updating the Job in the User object managed by UserModel.
`AddOfferActivity` enables users to add new job offers, which are then stored in the OffersModel.
`EditSettingsActivity` lets users modify their WeightSettings, which are part of the User object in UserModel.
`RankOffersActivity` displays a ranked list of job offers. It uses the JobRanker class to sort the offers based on the user's preferences.
`CompareOffersActivity` shows a side-by-side comparison of two selected Job objects.

### When choosing to enter current job details, a user will be shown a user interface to enter (if it is the first time) or edit all the details of their current job.

The user triggers the `addJob` method which launches the `AddJobActivity`. This activity contains a form to add or modify the user's job. It uses the `User` class, which contains a reference to the user's current `Job`.

### User must be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The `AddJobActivity` includes a button to save modifications and a button to cancel. Both buttons return to the `MainActivity`, but the save button modifies the `User` data instance first (accessible via a `ViewModel`).

### When choosing to enter job offers, a user will be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

The `addOffer` method launches an `AddOfferActivity` which provides a form to create a new offer (a `Job` instance). A new `Job` instance is added to the `User` instance.

### User must be able to either save the job offer details or cancel.

The `AddOfferActivity` includes a button to save modifications and a button to cancel. Both buttons return to the `MainActivity`, but the save button adds a new `Job` data instance into the offers list (accessible via a `ViewModel`).

### User must be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

The `AddOfferActivity` includes a button to launch another `AddOfferActivity` recursively. Another button triggers the `RankOffersActivity`.

### When adjusting the comparison settings, the user can assign integer weights to available categories.

The `editSettings` method in the `MainActivity` launches the `EditSettingsActivity` for the current user. This page has a form for the various settings. The form is preloaded with the settings in the current user (accessible via a `ViewModel`). A save button writes modifications to the user's settings. Both the save and cancel buttons return to the `MainActivity`.

### When choosing to compare job offers, a user will be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

The `MainActivity` launches a `RankOffersActivity`. This activity pulls the job offers (via a `ViewModel`) and sorts them with a `JobRanker` instance (which is a Java `Comparator`). The offers are displayed once sorted.

### User must be able to select two jobs to compare and trigger the comparison.

The `RankOffersActivity` allows the user to check two rows. Once checked, the `CompareOffersActivity` is launched.

### When comparing, user must be shown a table comparing the two jobs.

The `CompareOffersActivity` displays a table with the details of the two jobs.

### User must be offered to perform another comparison or go back to the main menu.

The `CompareOffersActivity` has a button to cancel (and go back to the `MainActivity`) and a button to compare more offers (by going back to the `RankOffersActivity`).

### When ranking jobs, a job’s score is computed as the weighted average of a big formula.

Job ranking is handled by the `JobRanker` class which is a customized Java `Comparator`. It implementes `compare(Job left, Job right)`, comparing two Job objects and returns an integer indicating their relative order. Internally, it calls `calculateScore()` for each job and compares the resulting scores, returning -1 if the left job scores higher, 1 if the right job scores higher, and 0 if they're equal. The method `calculateScore(Job job)` calculates the score for each job, taking into account the weights from the `WeightSettings` class, and the formula given in the assignment.

### The user interface must be intuitive and responsive.

The user interface follows best practices by having clear words on the field names, buttons that make the navigation self-evident, and input methods that account for the data types - e.g. for numerical data types, the number keyboard is shown, for the range inputs for the weights, sliders are shown.

### For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

This app doesn't have any networking or communication component. All information is stored locally. Data persistence and management are handled by two key classes: `UserModel` and `OffersModel`. Both extend AndroidViewModel for lifecycle-aware data handling. `UserModel` manages the `User` object, including the current job and weight settings. `OffersModel` manages a list of `Job` objects representing various job offers. Both these persist data to disk using `ObjectOutputStream` and are able to do this because the underlying data classes being saved have implemented the `Serializable` interface.

