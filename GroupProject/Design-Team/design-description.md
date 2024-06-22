# Team 032 - CS6300 Summer 2024 - Design Description

### When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

The user initially views the `MainActivity`. The `MainActivity` UI can trigger one of four methods: `addJob`, `addOffer`, `editSettings`, or `rankOffers`. These methods each spawn their own respective activities. Information about the user is stored in the `User` class. Available offers are stored as a list of `Job` class instances.

### When choosing to enter current job details, a user will be shown a user interface to enter (if it is the first time) or edit all the details of their current job.

The user triggers the `addJob` method which launches the `AddJobActivity`. This activity contains a form to add or modify the user's job.

### User must be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The `AddJobActivity` includes a button to save modifications and a button to cancel. Both buttons return to the `MainActivity`, but the save button modifies the `User` data instance first (accessible via a `ViewModel`).

### When choosing to enter job offers, a user will be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

The `addOffer` method launches an `AddOfferActivity` which provides a form to create a new offer (a `Job` instance).

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

Job ranking is handled by the `JobRanker` class which is a customized Java `Comparator`.

### The user interface must be intuitive and responsive.

This is hopefully covered by the layout of the pages and direct mapping to the desired actions.

### For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

This app doesn't have any networking or communication component. All information is stored locally.
