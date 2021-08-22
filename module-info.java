module Project {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.media;
	requires java.logging;
	opens Controllers to javafx.graphics, javafx.fxml;
	opens Database to javafx.graphics, javafx.base, javafx.controls;
}