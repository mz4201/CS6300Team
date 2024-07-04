package edu.gatech.seclass.jobcompare6300.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.Math;

import java.io.Serializable;

public class WeightSettings implements Parcelable, Serializable {

    private int clamp(int a) {
        int MAX = 9;
        int MIN = 0;
        return (a > MAX) ? MAX : (Math.max(a, MIN));
    }
    private int salary = 5;
    private int bonus = 5;
    private int training = 5;
    private int leave = 5;
    private int telework = 5;

    public WeightSettings() {
        // Default values are already set in field declarations
    }

    // Getters
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

    // Setters
    public void setSalary(int salary) {
        this.salary = clamp(salary);
    }

    public void setBonus(int bonus) {
        this.bonus = clamp(bonus);
    }

    public void setTraining(int training) {
        this.training = clamp(training);
    }

    public void setLeave(int leave) {
        this.leave = clamp(leave);
    }

    public void setTelework(int telework) {
        this.telework = clamp(telework);
    }

    // Parcelable implementation
    protected WeightSettings(Parcel in) {
        salary = in.readInt();
        bonus = in.readInt();
        training = in.readInt();
        leave = in.readInt();
        telework = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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

    public static final Creator<WeightSettings> CREATOR = new Creator<WeightSettings>() {
        @Override
        public WeightSettings createFromParcel(Parcel in) {
            return new WeightSettings(in);
        }

        @Override
        public WeightSettings[] newArray(int size) {
            return new WeightSettings[size];
        }
    };
}
