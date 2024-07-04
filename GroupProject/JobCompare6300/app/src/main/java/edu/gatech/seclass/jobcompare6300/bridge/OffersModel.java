package edu.gatech.seclass.jobcompare6300.bridge;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import edu.gatech.seclass.jobcompare6300.data.Job;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OffersModel extends AndroidViewModel {
  private Application application;
  private List<Job> offers;

  public OffersModel(Application application) {
    super(application);
    this.application = application;
    this.offers = null;
  }

  public List<Job> getOffers() {
    if (this.offers != null) {
      return this.offers;
    }

    try (
        var file = application.openFileInput("offers.data");
        var stream = new ObjectInputStream(file)
    ) {
      this.offers = (List<Job>) stream.readObject();
    } catch (Exception exception) {
      Log.w("JobCompare", "Could not read stored offers, loading default");
      this.offers = new ArrayList<>();
    }

    return this.offers;
  }

  public void addOffer(Job job) {
    if (this.offers == null) {
      getOffers();
    }

    this.offers.add(job);

    try (
        var file = application.openFileOutput(
            "offers.data", Context.MODE_PRIVATE
        );
        var stream = new ObjectOutputStream(file)
    ) {
      stream.writeObject(this.offers);
    } catch (Exception exception) {
      Log.w("JobCompare", "Could not write updated offers");
    }
  }
}
