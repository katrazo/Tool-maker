package edu.bsu.cs.toolmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GradeCalculatorTest {
    @Test
    public void test_getGradeSet() {
        GradeCalculator gradeCalculator = new GradeCalculator();

        char[] expectedGradeSet = {'A', 'B', 'C', 'D', 'F'};
        char[] actualGradeSet = gradeCalculator.getGradeSet();

        Assertions.assertEquals(Arrays.toString(expectedGradeSet), Arrays.toString(actualGradeSet));
    }
}
