package com.example.exp.multimvcidemo.main;

import com.example.exp.multimvcidemo.databasescreen.TravelDatabaseController;
import com.example.exp.multimvcidemo.login.LoginController;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class MainController {
    private final Builder<Region> viewBuilder;

    public MainController() {
        MainModel model = new MainModel();
        viewBuilder = new MainViewBuilder(model,
                new LoginController(model.runExample,model.isLoggedIn).getView(),
                new TravelDatabaseController(model.isLoggedIn).getView()
        );
    }

    public Region getView() {
        return viewBuilder.build();
    }
}