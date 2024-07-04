package edu.gatech.seclass.jobcompare6300.data;

import android.app.job.JobInfo;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Parcelable, Serializable {
    private final int id;
    private final Job job;
    private final WeightSettings settings;

    public User(int id, Job job, WeightSettings settings) {
        this.id = id;
        this.job = job;
        this.settings = settings;
    }

    public int getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public WeightSettings getSettings() {
        return settings;
    }

    // Parcelable implementation
    protected User(Parcel in) {
        id = in.readInt();
        job = in.readParcelable(Job.class.getClassLoader());
        settings = in.readParcelable(WeightSettings.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(job, flags);
        dest.writeParcelable(settings, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
