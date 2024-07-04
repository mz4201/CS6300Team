package edu.gatech.seclass.jobcompare6300.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Job implements Parcelable, Serializable {
    private final String title;
    private final String company;
    private final String city;
    private final String state;
    private final int col;
    private final int salary;
    private final int bonus;
    private final int training;
    private final int leave;
    private final int telework;

    public Job(String title, String company, String city, String state, int col, int salary, int bonus, int training, int leave, int telework) {
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.col = col;
        this.salary = salary;
        this.bonus = bonus;
        this.training = training;
        this.leave = leave;
        this.telework = telework;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCol() {
        return col;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }

    public int getTraining() {
        return training;
    }

    public int getLeave() {
        return leave;
    }

    public int getTelework() {
        return telework;
    }

    // Parcelable implementation
    protected Job(Parcel in) {
        title = in.readString();
        company = in.readString();
        city = in.readString();
        state = in.readString();
        col = in.readInt();
        salary = in.readInt();
        bonus = in.readInt();
        training = in.readInt();
        leave = in.readInt();
        telework = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(company);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeInt(col);
        dest.writeInt(salary);
        dest.writeInt(bonus);
        dest.writeInt(training);
        dest.writeInt(leave);
        dest.writeInt(telework);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Job> CREATOR = new Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };
}
