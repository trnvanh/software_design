module fi.tuni.progthree.weatherapp {
    requires spring.core;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires javafx.controls;
    requires javafx.fxml;
    requires net.rgielen.fxweaver.core;
    requires org.slf4j;
    requires spring.webflux;
    requires spring.web;
    requires lombok;
    requires com.google.gson;
    requires org.apache.commons.lang3;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires java.persistence;
    requires io.hypersistence.utils.hibernate.type;
    requires reactor.core;
    requires java.annotation;
    requires java.management;
//    requires TrayNotification;
    requires java.prefs;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires micrometer.core;
    requires modelmapper;
    requires spring.security.crypto;

    opens fi.tuni.prog3.weatherapp to spring.core, spring.beans, spring.context;
    opens fi.tuni.prog3.weatherapp.controller to spring.core, spring.beans, javafx.fxml;
    opens fi.tuni.prog3.weatherapp.config to spring.core, spring.beans;
//    opens fi.tuni.prog3.weatherapp.service to spring.core, spring.beans;

    exports fi.tuni.prog3.weatherapp;
    exports fi.tuni.prog3.weatherapp.controller;
    exports fi.tuni.prog3.weatherapp.config;
    exports fi.tuni.prog3.weatherapp.service;
    exports fi.tuni.prog3.weatherapp.service.impl;
    exports fi.tuni.prog3.weatherapp.dto.airdtos;
    opens fi.tuni.prog3.weatherapp.dto.airdtos;
    exports fi.tuni.prog3.weatherapp.dto.favoritedtos;
    opens fi.tuni.prog3.weatherapp.dto.favoritedtos;

    exports fi.tuni.prog3.weatherapp.dto.weatherdtos;
    opens fi.tuni.prog3.weatherapp.dto.weatherdtos;
    exports fi.tuni.prog3.weatherapp.templatemethoddesign;
    exports fi.tuni.prog3.weatherapp.facededesign;
    exports fi.tuni.prog3.weatherapp.controller.support;
    opens fi.tuni.prog3.weatherapp.controller.support to javafx.fxml, spring.beans, spring.core;
    exports fi.tuni.prog3.weatherapp.builderpattern;
    opens fi.tuni.prog3.weatherapp.builderpattern;
    exports fi.tuni.prog3.weatherapp.entity;
    opens fi.tuni.prog3.weatherapp.entity;
    exports fi.tuni.prog3.weatherapp.repository;
    opens fi.tuni.prog3.weatherapp.repository;
    exports fi.tuni.prog3.weatherapp.util;
    opens fi.tuni.prog3.weatherapp.util;
    exports fi.tuni.prog3.weatherapp.dto.historydtos;
    opens fi.tuni.prog3.weatherapp.dto.historydtos;
    exports fi.tuni.prog3.weatherapp.dto.userdtos;
    opens fi.tuni.prog3.weatherapp.dto.userdtos;
    exports fi.tuni.prog3.weatherapp.datainitializer;
    opens fi.tuni.prog3.weatherapp.datainitializer to spring.core;

}