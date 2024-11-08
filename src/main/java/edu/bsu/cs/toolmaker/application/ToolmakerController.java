package edu.bsu.cs.toolmaker.application;

import edu.bsu.cs.toolmaker.GradeCalculator;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class ToolmakerController {
    GradeCalculator gradeCalculator = new GradeCalculator();
    Object[] userInputs = new Object[6];

    @FXML private Spinner<Integer> assignmentsSpinner;
    @FXML private Spinner<Integer> achievementsSpinner;
    @FXML private CheckBox selfAssessmentCheckbox;
    @FXML private Slider finalExamSlider;

    @FXML private ChoiceBox<String> firstProjectChoice;
    @FXML private ChoiceBox<String> firstProjGuiChoice;
    @FXML private ChoiceBox<String> iterationOneChoice;
    @FXML private ChoiceBox<String> iterationTwoChoice;
    @FXML private ChoiceBox<String> iterationThreeChoice;

    @FXML private Label gradeLabel;
    @FXML private ToggleGroup desiredGradeGroup;

    @FXML private TableView<GradeTableRow> gradeTable = new TableView<>();
    @FXML private TableColumn<GradeTableRow, String> gradeItemColumn = new TableColumn<>("Item");
    @FXML private TableColumn<GradeTableRow, String> yourGradeColumn = new TableColumn<>("You");
    @FXML private TableColumn<GradeTableRow, String> neededColumn = new TableColumn<>("#");
    private ObservableList<GradeTableRow> tableRows;

    public void initialize() {
        tableRows = FXCollections.observableList(new ArrayList<>());
        gradeTable.setItems(tableRows);

        gradeItemColumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getItem()));
        yourGradeColumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getYourGrade()));
        neededColumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().getNeededForDesiredGrade()));
    }

    @FXML private void updateMyGrade() {
        char grade = fetchMyGrade();
        gradeLabel.setText(String.valueOf(grade));

        updateTableContents();
    }
    char fetchMyGrade() {
        try {
            userInputs[0] = assignmentsSpinner.getValue();
            userInputs[1] = achievementsSpinner.getValue();
            userInputs[2] = (selfAssessmentCheckbox.isSelected()) ? "Yes" : "No";
            userInputs[3] = parseProjectChoices();
            userInputs[4] = iterationThreeChoice.getValue().charAt(0);
            userInputs[5] = finalExamSlider.getValue() / 100;

            gradeCalculator.checkAssignmentsGrade((Integer) userInputs[0]);
            gradeCalculator.checkAchievementsGrade((Integer) userInputs[1]);
            gradeCalculator.checkMidtermGrade(selfAssessmentCheckbox.isSelected());

            gradeCalculator.checkProjectsLevelsGrade(new String[]{
                    firstProjectChoice.getValue(),
                    firstProjGuiChoice.getValue(),
                    iterationOneChoice.getValue(),
                    iterationTwoChoice.getValue()
            });
            gradeCalculator.checkIterationThreeGrade(String.valueOf(userInputs[4]));
            gradeCalculator.checkFinalExamGrade((Double) userInputs[5]);

            System.out.println(gradeCalculator);
            gradeLabel.setDisable(false);
            return gradeCalculator.calculateOverallGrade();
        }
        catch (NullPointerException e) {
            showBlockingAlert(new NullPointerException("You have left an input blank."));
            gradeLabel.setDisable(true);
            return '#';
        }
    }
    private String parseProjectChoices() {
        int numOfChoicesStarterOrBetter = 0;
        String[] choices = {
                firstProjectChoice.getValue(),
                firstProjGuiChoice.getValue(),
                iterationOneChoice.getValue(),
                iterationTwoChoice.getValue()
        };

        for (String choice : choices)
            if (!choice.equals("Un-assessable"))
                numOfChoicesStarterOrBetter++;

        if (numOfChoicesStarterOrBetter == 4) return "S (All)";
        else if (numOfChoicesStarterOrBetter > 0) return "S [1+]";
        else return "U";
    }

    @FXML private void updateTableContents() {
        String[] userInputsAsStrings = new String[6];
        for (int i = 0; i < 6; i++)
            userInputsAsStrings[i] = String.valueOf(userInputs[i]);

        tableRows.clear();
        tableRows.setAll(GradeTableRow.getRows(userInputsAsStrings, getSelectedDesiredGrade()));
        gradeTable.setItems(tableRows);
        neededColumn.setText(String.valueOf(getSelectedDesiredGrade()));
    }
    private char getSelectedDesiredGrade() {
        return (desiredGradeGroup.getSelectedToggle() != null)
                ? ((ToggleButton) desiredGradeGroup.getSelectedToggle()).getText().charAt(0)
                : '#';
    }

    private void showBlockingAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Whoops!");
        alert.setHeaderText(e.getClass().getSimpleName());
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }
}
