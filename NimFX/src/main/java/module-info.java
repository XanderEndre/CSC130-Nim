module io.github.csc130.nimfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens io.github.csc130.nimfx to javafx.fxml;
    exports io.github.csc130.nimfx;
}