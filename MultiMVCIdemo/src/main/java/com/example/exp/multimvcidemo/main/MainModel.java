package com.example.exp.multimvcidemo.main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;



public class MainModel {
    enum Screens {
        LOGIN,
        DATABASE,
    }
    private final BooleanProperty loginSelected = new SimpleBooleanProperty(true);
    private final BooleanProperty databaseSelected = new SimpleBooleanProperty(false);
    public final BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
    private final ObjectProperty<Screens> screescreenPropertynProperty = new SimpleObjectProperty<Screens>(Screens.LOGIN);
    public BooleanProperty function1SelectedProperty() {
        return loginSelected;
    }
    public BooleanProperty function2SelectedProperty() {
        return databaseSelected;
    }
    Runnable runExample = () -> {
        loginSelected.setValue(false);
        databaseSelected.setValue(true);
    };
}
