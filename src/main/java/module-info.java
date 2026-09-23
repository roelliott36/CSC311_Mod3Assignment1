module org.example.csc311_mod3assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_mod3assignment1 to javafx.fxml;
    exports org.example.csc311_mod3assignment1;
}