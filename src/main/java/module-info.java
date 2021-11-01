module JosephEscribanoAPIS {
    //needed for JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;
    requires lombok;
    requires java.logging;
    requires io.vavr;
    requires retrofit2;
    requires okhttp3;
    requires retrofit2.adapter.rxjava2;
    requires retrofit2.converter.gson;
    requires com.google.gson;
    requires modelmapper;
    requires org.apache.logging.log4j;
    requires javafx.graphics;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;


    //requires javafx.swing;

    //needed for HTTP
    // requires unirest.java;

    //needed for JSON
//    requires gson;
//    requires java.sql;

    //needed for JavaFX
    //opens gui.controllers to javafx.fxml;

    // yaml
    //opens config to org.yaml.snakeyaml.Yaml;

//    //needed for JSON
//    opens com.edencoding.models.openVision to gson;
//    opens com.edencoding.models.dogs to gson;

    opens config;
    opens utils;
    opens gui;
    opens gui.controllers;
    opens dao.modeloPropio;
    opens dao.modelos.generationData;
    opens dao.modelos.generationNames;
    opens dao.modelos.pokemons;
    opens dao.modelos.types;


    exports gui;
    exports gui.controllers;
    exports config;

    exports dao;
    exports dao.modelos.generationData;
    exports dao.modelos.generationNames;
    exports dao.modelos.pokemons;
    exports dao.modelos.types;
    exports dao.modelos.stats;
    exports dao.modelos.versions;
    exports dao.retrofit;
    exports dao.modeloPropio;



    exports servicios;
    exports utils;

}