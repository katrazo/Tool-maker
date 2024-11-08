package edu.bsu.cs.toolmaker;

public class GradeCalculator {
    private static final char[] LETTER_GRADES = {'A', 'B', 'C', 'D', 'F'};

    private char finalExamGrade;
    private char iterationThreeGrade;
    private char projectsLevelsGrade;
    private char midtermGrade;
    private char achievementsGrade;
    private char assignmentsGrade;

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("Grades: ");
        for (char grade : getGradesArray())
            toReturn.append(grade).append(" ");

        return toReturn.toString();
    }
    public char[] getGradesArray() {
        return new char[] {
            assignmentsGrade,
            achievementsGrade,
            midtermGrade,
            projectsLevelsGrade,
            iterationThreeGrade,
            finalExamGrade
        };
    }

    public char calculateOverallGrade(char[] individualGrades) {
        char toReturn = 0;

        for (char individualGrade : individualGrades)
            if (individualGrade > toReturn)
                toReturn = individualGrade;

        return toReturn;
    }
    public char calculateOverallGrade() {
        return calculateOverallGrade(new char[]{
                        finalExamGrade,
                        iterationThreeGrade,
                        projectsLevelsGrade,
                        midtermGrade,
                        achievementsGrade,
                        assignmentsGrade
        });
    }


    public char checkFinalExamGrade(double finalExamPercentage) {
        return finalExamGrade = checkCompletedSpecsAgainstBundle(
                finalExamPercentage,
                new double[]{1.00, 0.90, 0.75, 0.00, 0.00}
        );
    }

    public char checkIterationThreeGrade(String level) {
        double levelRepresentation = switch (level) {
                case "M" -> 3;
                case "P" -> 2;
                case "S" -> 1;
                default -> 0;
        };

        return iterationThreeGrade = checkCompletedSpecsAgainstBundle(
                levelRepresentation,
                new double[]{3, 2, 1, 1, 0}
        );
    }

    public char checkProjectsLevelsGrade(String[] levels) {
        int projectsWithStarterOrHigher = 0;

        for (String projectLevel : levels) {
            if (!projectLevel.equals("Un-assessable"))
                projectsWithStarterOrHigher += 1;
        }

        return projectsLevelsGrade = checkCompletedSpecsAgainstBundle(
                projectsWithStarterOrHigher,
                new double[]{4, 1, 1, 1, 0}
        );
    }

    public char checkMidtermGrade(boolean didCompleteMidterm) {
        return midtermGrade = (didCompleteMidterm) ? 'A' : 'D';
    }

    public char checkAchievementsGrade(int achievementsCompleted) {
        return achievementsGrade = checkCompletedSpecsAgainstBundle(
                achievementsCompleted,
                new double[]{6, 5, 4, 3, 0}
        );
    }

    public char checkAssignmentsGrade(int assignmentsCompleted) {
        return assignmentsGrade = checkCompletedSpecsAgainstBundle(
                assignmentsCompleted,
                new double[]{7, 6, 5, 4, 0}
        );
    }


    private char checkCompletedSpecsAgainstBundle(double completedSpecs, double[] bundleThresholds) {
        for (int i = 0; i < LETTER_GRADES.length; i++)
            if (completedSpecs >= bundleThresholds[i])
                return LETTER_GRADES[i];

        return '#';
    }

}
