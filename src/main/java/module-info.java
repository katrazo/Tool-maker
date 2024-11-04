module edu.bsu.cs.toolmaker {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.bsu.cs.toolmaker to javafx.fxml;
    exports edu.bsu.cs.toolmaker;
    exports edu.bsu.cs.toolmaker.application;
    opens edu.bsu.cs.toolmaker.application to javafx.fxml;
}