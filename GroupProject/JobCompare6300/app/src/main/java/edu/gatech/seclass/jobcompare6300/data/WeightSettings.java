package edu.gatech.seclass.jobcompare6300.data;

import android.os.Parcel;
import android.os.Parcelable;

public class WeightSettings implements Parcelable {
    private final int salary;
    private final int bonus;
    private final int training;
    private final int leave;
    private final int telework;

    public WeightSettings(int salary, int bonus, int training, int leave, int telework) {
        this.salary = salary;
        this.bonus = bonus;
        this.training = training;
        this.leave = leave;
        this.telework = telework;
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