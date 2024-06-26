package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class AddOfferActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_add_offer);

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
    var intent = new Intent(this, AddOfferActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
  }

  private void compareOffers() {
    startActivity(new Intent(this, CompareOffersActivity.class));
    finish();
  }

  private void save() {
    finish();
  }

  private void cancel() {
    finish();
  }
}
