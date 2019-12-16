package com.PayToPay.migrateXMLtoSQL.view;

import com.PayToPay.migrateXMLtoSQL.data.migrationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.PayToPay.migrateXMLtoSQL.controller.controller.*;
import static com.PayToPay.migrateXMLtoSQL.data.migrationData.xmlFile;
import static com.PayToPay.migrateXMLtoSQL.data.migrationData.xsdFile;
import static com.PayToPay.xsdValidator.XSDValidation.validateXMLSchema;

public class view {
    public static void loopMenu() throws IOException, ClassNotFoundException {
        boolean flag = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        migrationData.menuTree arg = null;

        while (flag) {
            boolean inFlag = true;
            while (inFlag) {
                System.out.println("What do you want to do?\n" +
                        "1 - Validate XML;\n" +
                        "2 - Connect to MySQL DB\n" +
                        "3 - Migrate data from xml to DB\n" +
                        "4 - Close connection and close util");

                String answer = in.readLine();

                switch (answer) {
                    case "1":
                        arg = migrationData.menuTree.VALIDATE;
                        inFlag = false;
                        break;
                    case "2":
                        arg = migrationData.menuTree.CONNECT;
                        inFlag = false;
                        break;
                    case "3":
                        arg = migrationData.menuTree.MIGRATE;
                        inFlag = false;
                        break;
                    case "4":
                        arg = migrationData.menuTree.CLOSE;
                        inFlag = false;
                        break;
                    default:
                        System.out.println("Incorrect answer, retype please!");
                        break;
                }
            }
            switch (arg) {
                case VALIDATE:
                    System.out.println(validateXMLSchema(xsdFile, xmlFile));
                    break;
                case CONNECT:
                    System.out.println("User: ");
                    String user = in.readLine();
                    System.out.println("Password: ");
                    String pass = in.readLine();

                    if (createConnection(user, pass)) {
                        System.out.println("Connected");
                    } else {
                        System.out.println("No connection");
                    }
                    break;
                case MIGRATE:
                    migrateXMLtoDB();
                    break;
                case CLOSE:
                    closeConnection();
                    flag = false;
                    break;
            }
        }
    }
}
