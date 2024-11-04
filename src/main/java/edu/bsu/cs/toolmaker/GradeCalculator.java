package edu.bsu.cs.toolmaker;

public class GradeCalculator {

    public char checkAssignmentsGrade(int assignmentsCompleted) {
        if (assignmentsCompleted >= 7)
            return 'A';
        else if (assignmentsCompleted == 6)
            return 'B';
        else if (assignmentsCompleted == 5)
            return 'C';
        else if (assignmentsCompleted == 4)
            return 'D';
        else
            return 'F';
    }
}
