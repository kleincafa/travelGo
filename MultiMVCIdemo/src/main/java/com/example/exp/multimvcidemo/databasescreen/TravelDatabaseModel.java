package com.example.exp.multimvcidemo.databasescreen;

import com.example.exp.multimvcidemo.databasescreen.backend.TravelPackage;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class TravelDatabaseModel {

    private final ListProperty<TravelPackage> travelPackageList = new SimpleListProperty<>();

    public ObservableList<TravelPackage> getTravelPackageList(){
        return travelPackageList.get();
    }

    public final BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);

    public final void setTravelPackageList(ObservableList<TravelPackage> value){travelPackageList.set(value);}

    public ListProperty<TravelPackage> travelPackageListProperty(){
        return travelPackageList;
    }

    private final IntegerProperty selectedItem = new SimpleIntegerProperty();

    public IntegerProperty getSelectedItemProperty(){
        return selectedItem;
    }

    public final void setSelectedItemProperty(Integer value){selectedItem.set(value);}
}
