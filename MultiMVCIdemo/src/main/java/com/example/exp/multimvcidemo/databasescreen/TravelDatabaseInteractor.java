package com.example.exp.multimvcidemo.databasescreen;

import com.example.exp.multimvcidemo.databasescreen.backend.TravelDatabase;
import com.example.exp.multimvcidemo.databasescreen.backend.TravelPackage;
import com.example.exp.multimvcidemo.databasescreen.backend.TravelPackageList;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TravelDatabaseInteractor {
    private final TravelDatabaseModel model;
    private final TravelDatabase database = new TravelDatabase();
    public TravelDatabaseInteractor(TravelDatabaseModel model) {
        this.model = model;
        loadTravelPackagesFromDB();
    }
    public void loadTravelPackagesFromDB() {
        ObservableList<TravelPackage> list1;
        try {
            list1 = FXCollections.observableArrayList(database.loadPackages().getPackages());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.setTravelPackageList(list1);
    }
    public void writeTravelPackagesToDB(){
        TravelPackageList travelPackageList = new TravelPackageList();
        travelPackageList.setPackages(model.getTravelPackageList());
        try {
            database.savePackages(travelPackageList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
