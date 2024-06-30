package edu.gatech.seclass.jobcompare6300.bridge;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.data.Job;

public class OffersModel extends AndroidViewModel {
    private List<Job> offers;

    public OffersModel(@NonNull Application application) {
        super(application);
        offers = new ArrayList<>();
    }

    public List<Job> getOffers() {
        return offers;
    }

    public void addOffer(Job job) {
        offers.add(job);
    }

}
