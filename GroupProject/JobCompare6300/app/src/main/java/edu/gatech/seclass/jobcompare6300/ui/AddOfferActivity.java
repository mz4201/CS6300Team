package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import edu.gatech.seclass.jobcompare6300.data.Job;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;
import edu.gatech.seclass.jobcompare6300.bridge.OffersModel;

public class AddOfferActivity extends AppCompatActivity {
  private EditText jobTitle, company, city, state, costOfLiving, yearlySalary, yearlyBonus, trainingFund, leaveTime, teleworkDays;
  private UserModel userModel;
  private OffersModel offersModel;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
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

    var saveButton = findViewById(R.id.addOfferSaveButton);
    saveButton.setOnClickListener(view -> save());

    var cancelButton = findViewById(R.id.addOfferCancelButton);
    cancelButton.setOnClickListener(view -> cancel());
  }

  private void addOffer() {
    var offer = parseOffer();
    offersModel.addOffer(offer);
    var intent = new Intent(this, AddOfferActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
  }

  private void compareOffers() {
    var intent = new Intent(this, CompareOffersActivity.class);

    var left = userModel.getUser().getJob();
    intent.putExtra("left", (Parcelable) left);

    var right = parseOffer();
    offersModel.addOffer(right);
    intent.putExtra("right", (Parcelable) right);

    startActivity(intent);
    finish();
  }

  private void save() {
    offersModel.addOffer(parseOffer());
    finish();
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
}
