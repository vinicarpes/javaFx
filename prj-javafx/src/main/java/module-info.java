module br.edu.ifsc.fln.prjjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens br.edu.ifsc.fln.prjjavafx to javafx.fxml;
    exports br.edu.ifsc.fln.prjjavafx;
}