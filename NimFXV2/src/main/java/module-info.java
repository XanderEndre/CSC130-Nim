module io.github.csc130.nimfxv2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.csc130.nimfxv2 to javafx.fxml;
    opens io.github.csc130.nimfxv2.controller;
    opens io.github.csc130.nimfxv2.model;

    exports io.github.csc130.nimfxv2;
    exports io.github.csc130.nimfxv2.controller;
    exports io.github.csc130.nimfxv2.model;
}