package com.PayToPay.migrateXMLtoSQL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

import static com.PayToPay.migrateXMLtoSQL.view.view.loopMenu;

public class MigrationMain {
    public static Logger logger;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Starting");

        PropertyConfigurator.configure("log4j.properties");
        logger = Logger.getLogger(MigrationMain.class);

        loopMenu();
    }
}
