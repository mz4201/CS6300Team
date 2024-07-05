package edu.gatech.seclass.jobcompare6300.logic;

import java.util.Comparator;
import edu.gatech.seclass.jobcompare6300.data.Job;

public class JobRanker implements Comparator<Job> {

    private final edu.gatech.seclass.jobcompare6300.data.User user;

    public JobRanker(edu.gatech.seclass.jobcompare6300.data.User user) {
        this.user = user;
    }

    @Override
    public int compare(edu.gatech.seclass.jobcompare6300.data.Job left, edu.gatech.seclass.jobcompare6300.data.Job right) {
        double leftScore = calculateScore(left);
        double rightScore = calculateScore(right);

        if (leftScore > rightScore) {
            return -1; // Left job is better
        } else if (leftScore < rightScore) {
            return 1; // Right job is better
        } else {
            return 0; // Jobs are equal
        }
    }

    private double calculateScore(edu.gatech.seclass.jobcompare6300.data.Job job) {
        /*
        When ranking jobs, a job’s score is computed as the weighted average of:
        AYS + AYB + TDF + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8))
        where:
        AYS = Yearly Salary Adjusted for cost of living
        AYB = Yearly Bonus Adjusted for cost of living
        TDF = Training and Development Fund  ($0 to $18000 inclusive annually)
        LT = Leave Time  (0-100 whole number days inclusive)
        RWT = Telework Days per Week
        */
        double colAdjSalary = job.getSalary()*100/((double)job.getCol());
        double colAdjBonus = job.getBonus()*100/((double)job.getCol());
        double colAdjTraining = job.getTraining()*100/((double)job.getCol()); // not needed for now, but could be useful.

        return (
                (double) (user.getSettings().getSalary() * colAdjSalary) /8 +
                        (double)(user.getSettings().getBonus() * colAdjBonus)/8 +
                        (double)(user.getSettings().getTraining() * job.getTraining())/8 +
                        (double)(user.getSettings().getLeave() * job.getLeave() * colAdjSalary/260)/8 -
                        (double)(user.getSettings().getTelework() * (260 - 52 * job.getTelework()) * colAdjSalary/260) / 8);
    }
}