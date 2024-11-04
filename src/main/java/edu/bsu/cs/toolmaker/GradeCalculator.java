package edu.bsu.cs.toolmaker;

public class GradeCalculator {
    private final char[] LETTER_GRADES = {'A', 'B', 'C', 'D', 'F'};

    public char checkProjectsLevelsGrade(String[] levels) {
        int projectsWithStarterOrHigher = 0;

        for (String projectLevel : levels) {
            if (!projectLevel.equals("Un-assessable"))
                projectsWithStarterOrHigher += 1;
        }

        if (projectsWithStarterOrHigher == 4)
            return 'A';
        else if (projectsWithStarterOrHigher > 0)
            return 'B';
        else
            return 'F';
    }

    public char checkMidtermGrade(boolean didCompleteMidterm) {
        return (didCompleteMidterm) ? 'A' : 'D';
    }


    public char checkFinalExamGrade(double finalExamPercentage) {
        return checkCompletedSpecsAgainstBundle(
                finalExamPercentage,
                new double[]{1.00, 0.90, 0.75, 0.00, 0.00}
        );
    }

    public char checkIterationThreeGrade(String level) {
        double levelRepresentation =
                switch (level) {
                    case "Master" -> 3;
                    case "Proficient" -> 2;
                    case "Starter" -> 1;
                    default -> 0;
                };

        return checkCompletedSpecsAgainstBundle(
                levelRepresentation,
                new double[]{3, 2, 1, 1, 0}
        );
    }

    public char checkAssignmentsGrade(int assignmentsCompleted) {
        return checkCompletedSpecsAgainstBundle(
                assignmentsCompleted,
                new double[]{7, 6, 5, 4, 0}
        );
    }

    public char checkAchievementsGrade(int achievementsCompleted) {
        return checkCompletedSpecsAgainstBundle(
                achievementsCompleted,
                new double[]{6, 5, 4, 3, 0}
        );
    }


    private char checkCompletedSpecsAgainstBundle(double completedSpecs, double[] bundleThresholds) {
        for (int i = 0; i < LETTER_GRADES.length; i++)
            if (completedSpecs >= bundleThresholds[i])
                return LETTER_GRADES[i];

        return '#';
    }

}
