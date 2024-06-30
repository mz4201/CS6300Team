package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;
import edu.gatech.seclass.jobcompare6300.data.Job;
import edu.gatech.seclass.jobcompare6300.data.User;
import edu.gatech.seclass.jobcompare6300.data.WeightSettings;

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

  //setup references
  private void initializeViews() {

    userModel = new ViewModelProvider(this).get(UserModel.class);

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
  }

  //buttons action
  private void setupListeners() {
    addJobSaveButton.setOnClickListener(view -> save());
    addJobCancelButton.setOnClickListener(view -> cancel());
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
    User user = new User(1, job, new WeightSettings());
    userModel.setUser(user);
    finish();
  }

  private void cancel() {
    finish();
  }
}
