package edu.bsu.cs.toolmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();
    int assignmentsCompleted;

    @Test public void test_checkAssignmentsGrade_A() {
        assignmentsCompleted = 7;

        char expectedAssignmentsGrade = 'A';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }
    @Test public void test_checkAssignmentsGrade_B() {
        assignmentsCompleted = 6;

        char expectedAssignmentsGrade = 'B';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }
    @Test public void test_checkAssignmentsGrade_C() {
        assignmentsCompleted = 5;

        char expectedAssignmentsGrade = 'C';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }
    @Test public void test_checkAssignmentsGrade_D() {
        assignmentsCompleted = 4;

        char expectedAssignmentsGrade = 'D';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }
    @Test public void test_checkAssignmentsGrade_F() {
        assignmentsCompleted = 3;

        char expectedAssignmentsGrade = 'F';
        char actualAssignmentsGrade = gradeCalculator.checkAssignmentsGrade(assignmentsCompleted);

        Assertions.assertEquals(expectedAssignmentsGrade, actualAssignmentsGrade);
    }

}
