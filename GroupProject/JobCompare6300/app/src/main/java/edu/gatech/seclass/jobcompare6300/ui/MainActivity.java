package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_main);

    var addJobButton = findViewById(R.id.mainAddJobButton);
    addJobButton.setOnClickListener(view -> addJob());

    var addOfferButton = findViewById(R.id.mainAddOfferButton);
    addOfferButton.setOnClickListener(view -> addOffer());

    var editSettingsButton = findViewById(R.id.mainEditSettingsButton);
    editSettingsButton.setOnClickListener(view -> editSettings());

    var rankOffersButton = findViewById(R.id.mainRankOffersButton);
    rankOffersButton.setOnClickListener(view -> rankOffers());
  }

  @Override
  protected void onResume() {
    super.onResume();
    var app = (JobCompareApplication) getApplication().getApplicationContext();
    var job = app.getUserModel().getUser().getJob();
    var offers = app.getOffersModel().getOffers();
    var rankOffersButton = findViewById(R.id.mainRankOffersButton);
    if ((job != null && offers.size() >= 1) || offers.size() >= 2) {
      rankOffersButton.setEnabled(true);
    }
  }

  private void addJob() {
    startActivity(new Intent(this, AddJobActivity.class));
  }

  private void addOffer() {
    startActivity(new Intent(this, AddOfferActivity.class));
  }

  private void editSettings() {
    startActivity(new Intent(this, EditSettingsActivity.class));
  }

  private void rankOffers() {
    startActivity(new Intent(this, RankOffersActivity.class));
  }
}
