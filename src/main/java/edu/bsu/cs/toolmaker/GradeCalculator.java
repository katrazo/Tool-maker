package edu.bsu.cs.toolmaker;

public class GradeCalculator {
    private final char[] LETTER_GRADES = {'A', 'B', 'C', 'D', 'F'};

    public char checkAssignmentsGrade(int assignmentsCompleted) {
        return checkCompletedSpecsAgainstBundle(
                assignmentsCompleted,
                new int[]{7, 6, 5, 4, 0}
        );
    }
    public char checkAchievementsGrade(int achievementsCompleted) {
        return checkCompletedSpecsAgainstBundle(
                achievementsCompleted,
                new int[]{6, 5, 4, 3, 0}
        );
    }

    private char checkCompletedSpecsAgainstBundle(int completedSpecs, int[] bundleThresholds) {
        for (int i = 0; i < LETTER_GRADES.length; i++)
            if (completedSpecs >= bundleThresholds[i])
                return LETTER_GRADES[i];

        return '#';
    }


}
