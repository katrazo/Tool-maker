package edu.bsu.cs.toolmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    final GradeCalculator gradeCalculator = new GradeCalculator();
    int assignmentsCompleted;
    int achievementsCompleted;
    double finalExamPercentage;
    String[] projectLevels;
    char[] individualGrades;

    @Test public void test_checkAssignmentsGrade_A() {
        assignmentsCompleted = 7;

        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAssignmentsGrade_B() {
        assignmentsCompleted = 6;

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAssignmentsGrade_C() {
        assignmentsCompleted = 5;

        char expectedGrade = 'C';
        char actualGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAssignmentsGrade_D() {
        assignmentsCompleted = 4;

        char expectedGrade = 'D';
        char actualGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAssignmentsGrade_F() {
        assignmentsCompleted = 3;

        char expectedAssignmentsGrade = 'F';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }

    @Test public void test_checkAchievementsGrade_A() {
        achievementsCompleted = 6;

        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkAchievementsGrade(achievementsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAchievementsGrade_B() {
        achievementsCompleted = 5;

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkAchievementsGrade(achievementsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAchievementsGrade_C() {
        achievementsCompleted = 4;

        char expectedGrade = 'C';
        char actualGrade = gradeCalculator.checkAchievementsGrade(achievementsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAchievementsGrade_D() {
        achievementsCompleted = 3;

        char expectedGrade = 'D';
        char actualGrade = gradeCalculator.checkAchievementsGrade(achievementsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkAchievementsGrade_F() {
        achievementsCompleted = 2;

        char expectedGrade = 'F';
        char actualGrade = gradeCalculator.checkAchievementsGrade(achievementsCompleted);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

    @Test public void test_checkMidtermGrade_true() {
        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkMidtermGrade(true);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkMidtermGrade_false() {
        char expectedGrade = 'D';
        char actualGrade = gradeCalculator.checkMidtermGrade(false);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

    @Test public void test_checkProjectsGrade_A() {
        projectLevels = new String[]{"Proficient", "Proficient", "Starter", "Proficient"};

        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkProjectsLevelsGrade(projectLevels);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkProjectsGrade_B_1U() {
        projectLevels = new String[]{"Master", "Master", "Master", "Un-assessable"};

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkProjectsLevelsGrade(projectLevels);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkProjectsGrade_B_2U() {
        projectLevels = new String[]{"Master", "Master", "Un-assessable", "Un-assessable"};

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkProjectsLevelsGrade(projectLevels);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkProjectsGrade_B_3U() {
        projectLevels = new String[]{"Master", "Un-assessable", "Un-assessable", "Un-assessable"};

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkProjectsLevelsGrade(projectLevels);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkProjectsGrade_F() {
        projectLevels = new String[]{"Un-assessable", "Un-assessable", "Un-assessable", "Un-assessable"};

        char expectedGrade = 'F';
        char actualGrade = gradeCalculator.checkProjectsLevelsGrade(projectLevels);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

    @Test public void test_checkIterationThreeGrade_M() {
        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkIterationThreeGrade("M");

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkIterationThreeGrade_P() {
        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkIterationThreeGrade("P");

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkIterationThreeGrade_S() {
        char expectedGrade = 'C';
        char actualGrade = gradeCalculator.checkIterationThreeGrade("S");

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkIterationThreeGrade_U() {
        char expectedGrade = 'F';
        char actualGrade = gradeCalculator.checkIterationThreeGrade("U");

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

    @Test public void test_checkFinalExamGrade_A() {
        finalExamPercentage = 1.0;

        char expectedGrade = 'A';
        char actualGrade = gradeCalculator.checkFinalExamGrade(finalExamPercentage);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkFinalExamGrade_B() {
        finalExamPercentage = 0.95;

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.checkFinalExamGrade(finalExamPercentage);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkFinalExamGrade_C() {
        finalExamPercentage = 0.76;

        char expectedGrade = 'C';
        char actualGrade = gradeCalculator.checkFinalExamGrade(finalExamPercentage);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test public void test_checkFinalExamGrade_D() {
        finalExamPercentage = 0.50;

        char expectedGrade = 'D';
        char actualGrade = gradeCalculator.checkFinalExamGrade(finalExamPercentage);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

    @Test public void test_calculateOverallGrade_A() {
        individualGrades = new char[]{'A', 'A', 'A', 'A', 'A', 'A'};

        char expectedOverallGrade = 'A';
        char actualOverallGrade = gradeCalculator.calculateOverallGrade(individualGrades);

        Assertions.assertEquals(expectedOverallGrade, actualOverallGrade);
    }
    @Test public void test_calculateOverallGrade_B() {
        individualGrades = new char[]{'A', 'A', 'A', 'A', 'A', 'B'};

        char expectedOverallGrade = 'B';
        char actualOverallGrade = gradeCalculator.calculateOverallGrade(individualGrades);

        Assertions.assertEquals(expectedOverallGrade, actualOverallGrade);
    }
    @Test public void test_calculateOverallGrade_C() {
        individualGrades = new char[]{'A', 'C', 'A', 'A', 'A', 'B'};

        char expectedOverallGrade = 'C';
        char actualOverallGrade = gradeCalculator.calculateOverallGrade(individualGrades);

        Assertions.assertEquals(expectedOverallGrade, actualOverallGrade);
    }
    @Test public void test_calculateOverallGrade_D() {
        individualGrades = new char[]{'A', 'C', 'B', 'D', 'A', 'B'};

        char expectedOverallGrade = 'D';
        char actualOverallGrade = gradeCalculator.calculateOverallGrade(individualGrades);

        Assertions.assertEquals(expectedOverallGrade, actualOverallGrade);
    }
    @Test public void test_calculateOverallGrade_F() {
        individualGrades = new char[]{'F', 'C', 'B', 'D', 'A', 'B'};

        char expectedOverallGrade = 'F';
        char actualOverallGrade = gradeCalculator.calculateOverallGrade(individualGrades);

        Assertions.assertEquals(expectedOverallGrade, actualOverallGrade);
    }

    @Test public void test_calculateOverallGrade_noArgs() {
        gradeCalculator.checkAssignmentsGrade(7);
        gradeCalculator.checkAchievementsGrade(6);
        gradeCalculator.checkMidtermGrade(true);
        gradeCalculator.checkProjectsLevelsGrade(new String[]{"M", "M", "M", "P"});
        gradeCalculator.checkIterationThreeGrade("P");
        gradeCalculator.checkFinalExamGrade(1.00);

        char expectedGrade = 'B';
        char actualGrade = gradeCalculator.calculateOverallGrade();

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
}
