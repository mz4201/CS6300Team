package edu.gatech.seclass.jobcompare6300.bridge;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import edu.gatech.seclass.jobcompare6300.data.User;

public class UserModel extends AndroidViewModel {
    private User user;

    public UserModel(@NonNull Application application) {
        super(application);
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}
