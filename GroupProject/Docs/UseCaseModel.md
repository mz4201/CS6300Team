# Use Case Model
**Author**: Team032

## 1 Use Case Diagram
![UseCaseDiagram](/GroupProject/Docs/Images/UseCaseDiagram.png "Use Case Diagram")

## 2 Use Case Descriptions

### Use Case 1: Enter/Edit Current Job Detail
- **Requirements:** Allow users to enter/edit their current job details including Title, Company, Location, Cost of living, Yearly Salary, Yearly Bonus, Training and Development Fund, Leave Time and Telework Days per Week.
- **Pre-conditions:** Application is started and the main menu is displayed.
- **Post-conditions:** The job details can be saved, canceled, exit without saving, and both cases would return to main menu. 
- **Scenarios:**
    1. User selects "Enter or Edit Current Job Details" from the main menu.
    2. The application display a page to enter required information if no current job exists; Display current job information if exists.
    3. User enters/updates information
    4. User select "Save" to save the details
       1. User can select "Cancel" and exit without saving
    5. User returns to the Main Menu
### Use Case 2: Adjust Comparison Settings
- **Requirements:** Allow users to adjust integer weights to Yearly Salary, Yearly Bonus, Training and Development Fund, Leave Time, and Telework Days per week.
- **Pre-conditions:** Application is started and the main menu is displayed.
- **Post-conditions:** Comparison setting is saved by the user; If no edits, it's all equal.
- **Scenarios:**
  1. User selects "Adjust Comparison Settings" from the main menu.
  2. The application display a page to enter integer as weights for each setting.
     1. if user never adjusted comparison settings, the integer for each weights are equal.
  3. User select "Save" to save the details
      1. User can select "Cancel" and exit without saving.
  4. return to main menu
## Use Case 3: Enter Job Offers
- **Requirements:** Allow user to enter new job offer detail including the same information as the current job.
- **Pre-conditions:** Application is started and the main menu is displayed.
- **Post-conditions:** The job details can be saved, canceled; Able to enter another offer; Return to manin menu; Compare the saved job offer with current job details (if exists).
- **Scenarios:**
    1. User selects "Enter Job Offers" from the main menu.
    2. The application display a page to enter required information just like entering current job details.
    3. User enters information
    4. User select "Save" to save the job offer
        1. User can select "Cancel" and return to main menu
    5. After offer is saved, User can select "Enter Another Offer" which will start over this process
       1. User can return to the main menu
       2. User can compare the saved offer with the current job if present.
### Use Case 4: Compare Job Offers
- **Requirements:** Allow user to see a list of ranked best to worst, including current job (if present). Allowing user to select to jobs to compare by calculating job score with consideration of comparison setting.
- **Pre-conditions:** Application is started and the main menu is displayed; If there is current job, at least 1 job offer must be saved; If no current job, at least 2 job offers must be saved.
- **Post-conditions:** Display list of job offers ranked from best to worst; User can select two job offers for comparison.
- **Scenarios:**
    1. User selects "Compare Job Offers" from the main menu.
    2. The application display a list of job offers ranked from best to worst
  3. User selects two jobs and initiate the comparison
  4. The application display a table comparing two jobs with their Title, Company, Location, Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living, TDF, LT, and RWT.
  5. User can choose to perform another comparison that go back to the displayed list
     1. User can also choose to go back to the main menu.