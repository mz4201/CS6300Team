package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

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
  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_add_job);
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
    var saveButton = findViewById(R.id.addJobSaveButton);
    saveButton.setOnClickListener(view -> save());

    var cancelButton = findViewById(R.id.addJobCancelButton);
    cancelButton.setOnClickListener(view -> cancel());
  }

  private void save() {
    finish();
  }

  private void cancel() {
    finish();
  }
}
