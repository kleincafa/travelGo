module com.example.exp.multimvcidemo {
  requires javafx.fxml;

  requires org.kordamp.ikonli.javafx;
  requires com.fasterxml.jackson.dataformat.xml;
  requires com.dlsc.formsfx;
  requires javafx.controls;
  requires com.fasterxml.jackson.databind;
  requires com.ctc.wstx;

  opens com.example.exp.multimvcidemo to javafx.fxml;
    exports com.example.exp.multimvcidemo;
    exports com.example.exp.multimvcidemo.main;
    opens com.example.exp.multimvcidemo.main to javafx.fxml;
  exports com.example.exp.multimvcidemo.databasescreen.backend;
}