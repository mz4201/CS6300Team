package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.data.Job;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;
import edu.gatech.seclass.jobcompare6300.bridge.OffersModel;

public class AddOfferActivity extends AppCompatActivity {
  private EditText jobTitle, company, city, state, costOfLiving, yearlySalary, yearlyBonus, trainingFund, leaveTime, teleworkDays;
  private UserModel userModel;
  private OffersModel offersModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_offer);

    var app = (JobCompareApplication) getApplication().getApplicationContext();
    userModel = app.getUserModel();
    offersModel = app.getOffersModel();

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

    var addOfferButton = findViewById(R.id.addOfferAddOfferButton);
    addOfferButton.setOnClickListener(view -> addOffer());

    var compareOffersButton = findViewById(R.id.addOfferCompareOffersButton);
    compareOffersButton.setOnClickListener(view -> compareOffers());
    var job = userModel.getUser().getJob();
    var offers = offersModel.getOffers();
    if (job != null && offers.size() >= 1) {
      compareOffersButton.setEnabled(true);
    }

    var saveButton = findViewById(R.id.addOfferSaveButton);
    saveButton.setOnClickListener(view -> save());

    var cancelButton = findViewById(R.id.addOfferCancelButton);
    cancelButton.setOnClickListener(view -> cancel());
  }

  private void addOffer() {
    if (validateFields()) {
      Job offer = parseOffer();
      offersModel.addOffer(offer);
      clearFields();
    }
  }

  private void compareOffers() {
    if (validateFields()) {
      Intent intent = new Intent(this, CompareOffersActivity.class);

      Job left = userModel.getUser().getJob();
      intent.putExtra("left", (Parcelable) left);

      Job right = parseOffer();
      offersModel.addOffer(right);
      intent.putExtra("right", (Parcelable) right);

      startActivity(intent);
      finish();
    }
  }

  private void save() {
    if (validateFields()) {
      offersModel.addOffer(parseOffer());
      finish();
    }
  }

  private void cancel() {
    finish();
  }

  private Job parseOffer() {
    return new Job(
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
  }

  private boolean validateFields() {
    boolean isValid = true;

    if (jobTitle.getText().toString().isEmpty()) {
      showToast("Please enter job title.", jobTitle);
      isValid = false;
    }
    if (company.getText().toString().isEmpty()) {
      showToast("Please enter company.", company);
      isValid = false;
    }
    if (city.getText().toString().isEmpty()) {
      showToast("Please enter city.", city);
      isValid = false;
    } else if (!isValidCityStateFormat(city.getText().toString())) {
      showToast("City should only contain letters.", city);
      isValid = false;
    }
    if (state.getText().toString().isEmpty()) {
      showToast("Please enter state.", state);
      isValid = false;
    } else if (!isValidCityStateFormat(state.getText().toString())) {
      showToast("State should only contain letters.", state);
      isValid = false;
    }
    if (costOfLiving.getText().toString().isEmpty()) {
      showToast("Please enter cost of living.", costOfLiving);
      isValid = false;
    }
    if (yearlySalary.getText().toString().isEmpty()) {
      showToast("Please enter yearly salary.", yearlySalary);
      isValid = false;
    }
    if (yearlyBonus.getText().toString().isEmpty()) {
      showToast("Please enter yearly bonus.", yearlyBonus);
      isValid = false;
    }
    if (trainingFund.getText().toString().isEmpty()) {
      showToast("Please enter training fund.", trainingFund);
      isValid = false;
    }
    if (leaveTime.getText().toString().isEmpty()) {
      showToast("Please enter leave time.", leaveTime);
      isValid = false;
    } else {
      int leaveDays = Integer.parseInt(leaveTime.getText().toString());
      if (leaveDays < 0 || leaveDays > 366) {
        showToast("Leave time must be between 0 and 366 days.", leaveTime);
        isValid = false;
      }
    }
    if (teleworkDays.getText().toString().isEmpty()) {
      showToast("Please enter telework days.", teleworkDays);
      isValid = false;
    } else {
      int teleworkDaysValue = Integer.parseInt(teleworkDays.getText().toString());
      if (teleworkDaysValue < 0 || teleworkDaysValue > 7) {
        showToast("Telework days must be between 0 and 7 days.", teleworkDays);
        isValid = false;
      }
    }

    return isValid;
  }

  private void showToast(String message, EditText editText) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    editText.requestFocus();
  }

  private void clearFields() {
    jobTitle.setText("");
    company.setText("");
    city.setText("");
    state.setText("");
    costOfLiving.setText("");
    yearlySalary.setText("");
    yearlyBonus.setText("");
    trainingFund.setText("");
    leaveTime.setText("");
    teleworkDays.setText("");
  }

  private boolean isValidCityStateFormat(String input) {
    // Regular expression to check if the input contains only letters
    String regex = "^[a-zA-Z]+$";
    return input.matches(regex);
  }
}
