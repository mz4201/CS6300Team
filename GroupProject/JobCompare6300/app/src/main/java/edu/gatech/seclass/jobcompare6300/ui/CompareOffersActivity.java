package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
