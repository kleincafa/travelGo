package com.example.exp.multimvcidemo.databasescreen;

import static com.example.exp.multimvcidemo.databasescreen.components.TravelPackageDialogs.AddTravelPackageDialog;
import static com.example.exp.multimvcidemo.databasescreen.components.TravelPackageDialogs.UpdateTravelPackageDialog;

import com.example.exp.multimvcidemo.databasescreen.backend.TravelPackage;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class TravelDatabaseViewBuilder implements Builder<Region> {
    private final TravelDatabaseModel model;
    private final Runnable onSave;
    public TravelDatabaseViewBuilder(TravelDatabaseModel model,Runnable onSave) {
        this.model = model;
        this.onSave = onSave;
    }

    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        Node adminBar = adminBar();
        adminBar.visibleProperty().bind(model.isLoggedIn);
        adminBar.managedProperty().bind(model.isLoggedIn);
        borderPane.setTop(adminBar);
        borderPane.setCenter(createCentre());
        return borderPane;
    }
    private Node adminBar(){
        Button removeButton = new Button("Remove Selected Travel Package");
        removeButton.setOnAction(_ ->
                model.travelPackageListProperty().remove(model.getSelectedItemProperty().get())
        );
        Button addButton = new Button("Add Travel Package");
        addButton.setOnAction(
                _ ->
                        AddTravelPackageDialog().showAndWait().ifPresent(
                                travelPackage -> model.travelPackageListProperty().add(travelPackage)
                        )
        );
        Button updateButton = new Button("Update Travel Package");
        updateButton.setOnAction(
                _ ->{
                    int selectedPackage = model.getSelectedItemProperty().get();
                    UpdateTravelPackageDialog(model.travelPackageListProperty()
                            .get(selectedPackage)).showAndWait().ifPresent(
                            travelPackage -> {
                                model.travelPackageListProperty().set(selectedPackage,travelPackage);
                            }
                    );
                }
        );
        Button saveButton = new Button("Save Travel Packages");
        saveButton.setOnAction(
                _-> onSave.run()
        );
        Label loggedInLabel = new Label();
        loggedInLabel.textProperty().bind(
            model.isLoggedIn.map(it ->{
                if (it) {
                    return "true";
                }
                else {
                    return "false";
                }
            })
        );
        HBox hBox = new HBox(
                addButton,
                removeButton,
                updateButton,
                saveButton,
            loggedInLabel
        );
        hBox.setPadding(new Insets(5));
        hBox.setSpacing(25);
        return hBox;
    }

    private Node createCentre() {
        return travelPackagesBox();
    }

    private Node travelPackagesBox(){
        ListView<TravelPackage> list = new ListView<>();
        list.setCellFactory(travelPackage -> createCell());
        list.itemsProperty().bind(model.travelPackageListProperty());
        list.getSelectionModel().getSelectedIndices().addListener((ListChangeListener<Integer>) change -> model.setSelectedItemProperty(change.getList().getFirst()));
        return list;
    }
    //Custom ListCell for TravelPackages For Later
    private ListCell<TravelPackage> createCell() {
        return new ListCell<TravelPackage>() {
            private Region layout;
            @Override
            public void updateItem(TravelPackage item, boolean isEmpty) {
                super.updateItem(item, isEmpty);
                if (!isEmpty && (item != null)) {
                    setGraphic(new VBox(
                            new Label(item.getName()),
                            new Label(item.getDescription()),
                            new Label("Stock: "+ item.getStock()),
                            new Label("Price: "+ item.getPrice()),
                            new Label("Location:" + item.getLocation()),
                            new Label("Travel Type:" + item.getTravelType()),
                            new Label("Continent:" + item.getContinent())
                    ));
                } else {
                    setGraphic(null);
                    setText(null);
                }
            }
        };
    }
}
