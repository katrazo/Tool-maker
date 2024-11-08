package edu.bsu.cs.toolmaker.application;

import javafx.beans.property.SimpleStringProperty;

public class GradeTableRow {
    private final SimpleStringProperty item = new SimpleStringProperty("");
    private final SimpleStringProperty yourGrade = new SimpleStringProperty("");
    private final SimpleStringProperty neededForDesiredGrade = new SimpleStringProperty("");

    public GradeTableRow(String item, String yourGrade, String neededForDesiredGrade) {
        setItem(item);
        setYourGrade(yourGrade);
        setNeededForDesiredGrade(neededForDesiredGrade);
    }

    public static GradeTableRow[] getRows(String[] userInputs, char desiredLetterGrade) {
        GradeTableRow[] toReturn = new GradeTableRow[6];

        String[] items = {"Assignments", "Achievements", "Mid. Assess.", "Projects", "Final Iter. 3", "Final Exam"};
        String[] neededCompletions = getBundle(desiredLetterGrade);

        for (int i = 0; i < items.length; i++)
            toReturn[i] = new GradeTableRow(items[i], userInputs[i], neededCompletions[i]);

        return toReturn;
    }
    private static String[] getBundle(char desiredLetterGrade) {
        return switch (desiredLetterGrade) {
            case 'A' -> new String[]{"7", "6", "Yes", "S (All)", "M", "1.00"};
            case 'B' -> new String[]{"6", "5", "Yes", "S (1+)", "P", "0.90"};
            case 'C' -> new String[]{"5", "4", "Yes", "S (1+)", "S", "0.75"};
            case 'D' -> new String[]{"4", "3", "No", "S (1+)", "S", "0.00"};
            case 'F' -> new String[]{"0", "0", "No", "U (All)", "U", "0.00"};
            default -> new String[]{"#", "#", "#", "#", "#", "#"};
        };
    }

    public String getItem() {
        return item.get();
    }
    public void setItem(String it) {
        item.set(it);
    }

    public String getYourGrade() {
        return yourGrade.get();
    }
    public void setYourGrade(String grade) {
        yourGrade.set(grade);
    }

    public String getNeededForDesiredGrade() {
        return neededForDesiredGrade.get();
    }
    public void setNeededForDesiredGrade(String needed) {
        neededForDesiredGrade.set(needed);
    }

}
