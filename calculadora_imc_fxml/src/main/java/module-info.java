module br.ifsc.edu.fln.calculadoraimcfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.ifsc.edu.fln.calculadoraimcfxml to javafx.fxml;
    exports br.ifsc.edu.fln.calculadoraimcfxml;
}