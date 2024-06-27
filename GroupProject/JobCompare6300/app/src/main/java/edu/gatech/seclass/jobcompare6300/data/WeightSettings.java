package edu.gatech.seclass.jobcompare6300.data;

import android.os.Parcel;
import android.os.Parcelable;

public class WeightSettings implements Parcelable {
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
        this.salary = salary;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setTraining(int training) {
        this.training = training;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public void setTelework(int telework) {
        this.telework = telework;
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