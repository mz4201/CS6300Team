package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.bridge.OffersModel;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;
import edu.gatech.seclass.jobcompare6300.data.Job;
import edu.gatech.seclass.jobcompare6300.logic.JobRanker;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RankOffersActivity extends AppCompatActivity {

  private UserModel userModel;
  private OffersModel offersModel;
  private List<Job> offers;
  private List<TableRow> rows;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_rank_offers);

    var compareOffersButton = findViewById(R.id.rankOffersCompareOffersButton);
    compareOffersButton.setOnClickListener(view -> compareOffers());

    var cancelButton = findViewById(R.id.rankOffersCancelButton);
    cancelButton.setOnClickListener(view -> cancel());

    var app = (JobCompareApplication) getApplication().getApplicationContext();
    this.userModel = app.getUserModel();

    var currentRow = (TableRow) findViewById(R.id.currentJobRow);
    var job = userModel.getUser().getJob();
    if (job != null) {
      populate(currentRow, job.getTitle(), job.getCompany());
    }

    this.offersModel = app.getOffersModel();
    this.offers = offersModel.getOffers().stream()
        .sorted(new JobRanker(userModel.getUser()))
        .collect(Collectors.toList());

    this.rows = new ArrayList<TableRow>();
    var table = (TableLayout) findViewById(R.id.rankOffersTable);
    var inflater = (LayoutInflater) getSystemService(
        Context.LAYOUT_INFLATER_SERVICE
    );
    for (var offer : this.offers) {
      var row = (TableRow) inflater.inflate(R.layout.offer_row, null, false);
      populate(row, offer.getTitle(), offer.getCompany());
      this.rows.add(row);
      table.addView(row, -1);
    }
  }

  private boolean isChecked(TableRow row) {
    for (var child = 0; child < row.getChildCount(); child++) {
      var view = row.getChildAt(child);
      if (view instanceof CheckBox) {
        return ((CheckBox) view).isChecked();
      }
    }
    return false;
  }

  private void populate(TableRow row, String title, String company) {
    for (var child = 0; child < row.getChildCount(); child++) {
      var view = row.getChildAt(child);
      if (view instanceof TextView && view.getId() == R.id.offerRowTitle) {
        ((TextView) view).setText(title);
      } else if (view.getId() == R.id.offerRowCompany) {
        ((TextView) view).setText(company);
      }
    }
  }

  private void compareOffers() {
    var checked = new ArrayList<Job>();
    if (isChecked((TableRow) findViewById(R.id.currentJobRow))) {
      checked.add(userModel.getUser().getJob());
    }

    for (var offer = 0; offer < this.offers.size(); offer++) {
      var row = this.rows.get(offer);
      if (isChecked(row)) {
        checked.add(this.offers.get(offer));
      }
    }

    var intent = new Intent(this, CompareOffersActivity.class);
    var left = checked.get(0);
    intent.putExtra("left", (Parcelable) left);
    var right = checked.get(1);
    intent.putExtra("right", (Parcelable) right);

    startActivity(intent);
    finish();
  }

  private void cancel() {
    finish();
  }
}
