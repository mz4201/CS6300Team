package edu.gatech.seclass.jobcompare6300.ui;

import android.app.Application;
import edu.gatech.seclass.jobcompare6300.bridge.OffersModel;
import edu.gatech.seclass.jobcompare6300.bridge.UserModel;

public class JobCompareApplication extends Application {
  private UserModel userModel;
  private OffersModel offersModel;

  public void onCreate() {
    super.onCreate();
    userModel = new UserModel(this);
    offersModel = new OffersModel(this);
  }

  public UserModel getUserModel() {
    return this.userModel;
  }

  public OffersModel getOffersModel() {
    return this.offersModel;
  }
}
