package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class RankOffersActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_rank_offers);

    var compareOffersButton = findViewById(R.id.rankOffersCompareOffersButton);
    compareOffersButton.setOnClickListener(view -> compareOffers());

    var cancelButton = findViewById(R.id.rankOffersCancelButton);
    cancelButton.setOnClickListener(view -> cancel());



  }

  private void compareOffers() {
    startActivity(new Intent(this, CompareOffersActivity.class));
    finish();
  }

  private void cancel() {
    finish();
  }



}
