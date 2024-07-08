package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;
import edu.gatech.seclass.jobcompare6300.data.Job;
import edu.gatech.seclass.jobcompare6300.data.User;

public class AddJobActivity extends AppCompatActivity {
  private EditText jobTitle;
  private EditText company;
  private EditText city;
  private EditText state;
  private EditText costOfLiving;
  private EditText yearlySalary;
  private EditText yearlyBonus;
  private EditText trainingFund;
  private EditText leaveTime;
  private EditText teleworkDays;
  private Button addJobSaveButton;
  private Button addJobCancelButton;

  private UserModel userModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_job);
    initializeViews();
    setupListeners();
  }

  private void initializeViews() {
    var app = (JobCompareApplication) getApplication().getApplicationContext();
    userModel = app.getUserModel();

    jobTitle = findViewById(R.id.jobTitle);
    company = findViewById(R.id.company);
    city = findViewById(R.id.city);
    state = findViewById(R.id.state);
    costOfLiving = findViewById(R.id.costOfLiving);
    yearlySalary = findViewById(R.id.yearlySalary);
    yearlyBonus = findViewById(R.id.yearlyBonus);
    trainingFund = findViewById(R.id.trainingFund);
    leaveTime = findViewById(R.id.leaveTime);
    teleworkDays = findViewById(R.id.teleworkDays);
    addJobSaveButton = findViewById(R.id.addJobSaveButton);
    addJobCancelButton = findViewById(R.id.addJobCancelButton);

    var job = userModel.getUser().getJob();
    if (job != null) {
      jobTitle.setText(job.getTitle());
      company.setText(job.getCompany());
      city.setText(job.getCity());
      state.setText(job.getState());
      costOfLiving.setText(String.valueOf(job.getCol()));
      yearlySalary.setText(String.valueOf(job.getSalary()));
      yearlyBonus.setText(String.valueOf(job.getBonus()));
      trainingFund.setText(String.valueOf(job.getTraining()));
      leaveTime.setText(String.valueOf(job.getLeave()));
      teleworkDays.setText(String.valueOf(job.getTelework()));
    }
  }

  private void setupListeners() {
    addJobSaveButton.setOnClickListener(this::handleClick);
    addJobCancelButton.setOnClickListener(this::handleClick);
  }

  public void handleClick(View view) {
    if (view.getId() == R.id.addJobSaveButton) {
      if (areFieldsValid()) {
        if (isCityStateValid()) {
          if (isLeaveTimeValid() && isTeleworkDaysValid()) {
            save();
          }
        } else {
          showToast("City and State should only contain letters.");
        }
      } else {
        showToastForEmptyFields();
      }
    } else if (view.getId() == R.id.addJobCancelButton) {
      cancel();
    }
  }

  private boolean areFieldsValid() {
    return !isEmptyField(jobTitle) &&
            !isEmptyField(company) &&
            !isEmptyField(city) &&
            !isEmptyField(state) &&
            !isEmptyField(costOfLiving) &&
            !isEmptyField(yearlySalary) &&
            !isEmptyField(yearlyBonus) &&
            !isEmptyField(trainingFund) &&
            !isEmptyField(leaveTime) &&
            !isEmptyField(teleworkDays);
  }

  private boolean isEmptyField(EditText editText) {
    return editText.getText().toString().trim().isEmpty();
  }

  private boolean isCityStateValid() {
    String regex = "^[a-zA-Z]+$";
    return city.getText().toString().matches(regex) &&
            state.getText().toString().matches(regex);
  }

  private boolean isLeaveTimeValid() {
    String leaveInput = leaveTime.getText().toString().trim();
    if (leaveInput.isEmpty()) {
      showToast("Please enter leave time.", leaveTime);
      return false;
    }
    try {
      int leaveDays = Integer.parseInt(leaveInput);
      if (leaveDays < 0 || leaveDays > 366) {
        showToast("Leave time must be between 0 and 366 days.", leaveTime);
        return false;
      }
      return true;
    } catch (NumberFormatException e) {
      showToast("Invalid leave time format.", leaveTime);
      return false;
    }
  }

  private boolean isTeleworkDaysValid() {
    String teleworkInput = teleworkDays.getText().toString().trim();
    if (teleworkInput.isEmpty()) {
      showToast("Please enter telework days.", teleworkDays);
      return false;
    }
    try {
      int teleworkDaysValue = Integer.parseInt(teleworkInput);
      if (teleworkDaysValue < 0 || teleworkDaysValue > 7) {
        showToast("Telework days must be between 0 and 7 days.", teleworkDays);
        return false;
      }
      return true;
    } catch (NumberFormatException e) {
      showToast("Invalid telework days format.", teleworkDays);
      return false;
    }
  }

  private void showToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void showToast(String message, EditText field) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void showToastForEmptyFields() {
    if (isEmptyField(jobTitle)) {
      showToast("Please enter job title.");
    }
    if (isEmptyField(company)) {
      showToast("Please enter company.");
    }
    if (isEmptyField(city)) {
      showToast("Please enter city.");
    }
    if (isEmptyField(state)) {
      showToast("Please enter state.");
    }
    if (isEmptyField(costOfLiving)) {
      showToast("Please enter cost of living.");
    }
    if (isEmptyField(yearlySalary)) {
      showToast("Please enter yearly salary.");
    }
    if (isEmptyField(yearlyBonus)) {
      showToast("Please enter yearly bonus.");
    }
    if (isEmptyField(trainingFund)) {
      showToast("Please enter training fund.");
    }
    if (isEmptyField(leaveTime)) {
      showToast("Please enter leave time.");
    }
    if (isEmptyField(teleworkDays)) {
      showToast("Please enter telework days.");
    }
  }


  private void save() {
    Job job = new Job(
            jobTitle.getText().toString(),
            company.getText().toString(),
            city.getText().toString(),
            state.getText().toString(),
            Integer.parseInt(costOfLiving.getText().toString()),
            Integer.parseInt(yearlySalary.getText().toString()),
            Integer.parseInt(yearlyBonus.getText().toString()),
            Integer.parseInt(trainingFund.getText().toString()),
            Integer.parseInt(leaveTime.getText().toString()),
            Integer.parseInt(teleworkDays.getText().toString())
    );

    var oldUser = userModel.getUser();
    var newUser = new User(oldUser.getId(), job, oldUser.getSettings());
    userModel.setUser(newUser);
    finish();
  }

  private void cancel() {
    finish();
  }
}
