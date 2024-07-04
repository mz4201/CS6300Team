package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.data.Job;
import edu.gatech.seclass.jobcompare6300.R;

public class CompareOffersActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_compare_offers);

    var rankOffersButton = findViewById(
        R.id.compareOffersRankOffersButton
    );
    rankOffersButton.setOnClickListener(view -> rankOffers());

    var cancelButton = findViewById(R.id.compareOffersCancelButton);
    cancelButton.setOnClickListener(view -> cancel());

    var left = getIntent().getParcelableExtra("left", Job.class);

    var leftTitle = (TextView) findViewById(R.id.compareOffersLeftTitle);
    var leftCompany = (TextView) findViewById(R.id.compareOffersLeftCompany);
    var leftLocation = (TextView) findViewById(R.id.compareOffersLeftLocation);
    var leftSalary = (TextView) findViewById(R.id.compareOffersLeftSalary);
    var leftBonus = (TextView) findViewById(R.id.compareOffersLeftBonus);
    var leftTraining = (TextView) findViewById(R.id.compareOffersLeftTraining);
    var leftLeave = (TextView) findViewById(R.id.compareOffersLeftLeave);
    var leftTelework = (TextView) findViewById(R.id.compareOffersLeftTelework);

    leftTitle.setText(left.getTitle());
    leftCompany.setText(left.getCompany());
    leftLocation.setText(left.getCity() + ", " + left.getState());
    leftSalary.setText(String.valueOf(left.getSalary()));
    leftBonus.setText(String.valueOf(left.getBonus()));
    leftTraining.setText(String.valueOf(left.getTraining()));
    leftLeave.setText(String.valueOf(left.getLeave()));
    leftTelework.setText(String.valueOf(left.getTelework()));

    var right = getIntent().getParcelableExtra("right", Job.class);

    var rightTitle = (TextView) findViewById(R.id.compareOffersRightTitle);
    var rightCompany = (TextView) findViewById(R.id.compareOffersRightCompany);
    var rightLocation = (TextView) findViewById(R.id.compareOffersRightLocation);
    var rightSalary = (TextView) findViewById(R.id.compareOffersRightSalary);
    var rightBonus = (TextView) findViewById(R.id.compareOffersRightBonus);
    var rightTraining = (TextView) findViewById(R.id.compareOffersRightTraining);
    var rightLeave = (TextView) findViewById(R.id.compareOffersRightLeave);
    var rightTelework = (TextView) findViewById(R.id.compareOffersRightTelework);

    rightTitle.setText(right.getTitle());
    rightCompany.setText(right.getCompany());
    rightLocation.setText(right.getCity() + ", " + right.getState());
    rightSalary.setText(String.valueOf(right.getSalary()));
    rightBonus.setText(String.valueOf(right.getBonus()));
    rightTraining.setText(String.valueOf(right.getTraining()));
    rightLeave.setText(String.valueOf(right.getLeave()));
    rightTelework.setText(String.valueOf(right.getTelework()));
  }

  private void rankOffers() {
    var intent = new Intent(this, RankOffersActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
    finish();
  }

  private void cancel() {
    finish();
  }
}
