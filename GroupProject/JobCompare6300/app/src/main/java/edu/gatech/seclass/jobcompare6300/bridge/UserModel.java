package edu.gatech.seclass.jobcompare6300.bridge;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import edu.gatech.seclass.jobcompare6300.data.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserModel extends AndroidViewModel {
  private Application application;
  private User user;

  public UserModel(Application application) {
    super(application);
    this.application = application;
    this.user = null;
  }

  public User getUser() {
    if (this.user != null) {
      return this.user;
    }

    try (
        var file = application.openFileInput("user.data");
        var stream = new ObjectInputStream(file)
    ) {
      this.user = (User) stream.readObject();
    } catch (Exception exception) {
      Log.w("JobCompare", "Could not read stored user, loading default");
      this.user = new User(1, null, null);
    }

    return this.user;
  }

  public void setUser(User user) {
    this.user = user;

    try (
        var file = application.openFileOutput(
            "user.data", Context.MODE_PRIVATE
        );
        var stream = new ObjectOutputStream(file)
    ) {
      stream.writeObject(this.user);
    } catch (Exception exception) {
      Log.w("JobCompare", "Could not write updated offers");
    }
  }
}
