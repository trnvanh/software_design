module fi.tuni.progthree.weatherapp {
    requires spring.core;
    requires spring.beans;
    requires java.sql;
    requires lombok;
    requires javafx.controls;
    requires com.google.gson;
    requires spring.boot.autoconfigure;
    requires net.rgielen.fxweaver.core;
    requires org.slf4j;
    requires spring.boot;
    requires spring.context;
    requires javafx.fxml;
    requires spring.webflux;
    requires spring.web;
    requires org.apache.commons.lang3;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires java.persistence;
    requires io.hypersistence.utils.hibernate.type;
    requires reactor.core;
    requires java.annotation;
    exports fi.tuni.prog3.weatherapp;
    exports fi.tuni.prog3.weatherapp.controller;
    exports fi.tuni.prog3.weatherapp.config;
//    exports fi.tuni.prog3.weatherapp.util;
    exports fi.tuni.prog3.weatherapp.weatherapi;
    exports fi.tuni.prog3.weatherapp.airapi;
//    exports fi.tuni.prog3.weatherapp.service;
    opens fi.tuni.prog3.weatherapp.controller;
    opens fi.tuni.prog3.weatherapp;
//    opens fi.tuni.prog3.weatherapp.service;
//    opens fi.tuni.prog3.weatherapp.entity;
    opens fi.tuni.prog3.weatherapp.config;
    exports fi.tuni.prog3.weatherapp.service;
    opens fi.tuni.prog3.weatherapp.service;

//    exports fi.tuni.prog3.weatherapp.repository;
//    opens fi.tuni.prog3.weatherapp.dto;
    exports fi.tuni.prog3.weatherapp.dto.airdtos;
    opens fi.tuni.prog3.weatherapp.dto.airdtos;
    opens fi.tuni.prog3.weatherapp.dto.weatherdtos;
    exports fi.tuni.prog3.weatherapp.dto.weatherdtos;
}
