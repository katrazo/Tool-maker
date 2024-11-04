package edu.bsu.cs.toolmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();
    int assignmentsCompleted;
    int achievementsCompleted;

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

}
