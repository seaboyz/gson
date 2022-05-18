package com.webdev;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webdev.model.Customer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // read from file
        try {
            File file = new File("src/main/resources/users.json");
            FileReader reader = new FileReader(file);
            GsonBuilder gsonBuilder = new GsonBuilder();

            // change filed strategy
            gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
                @Override
                public String translateName(Field f) {
                    if (f.getName().equals("phoneNumber")) {
                        return "phone";
                    }
                    return f.getName();
                }
            });

            Gson gson = gsonBuilder.create();

            Customer[] customers = gson.fromJson(reader, Customer[].class);

            for (Customer c : customers) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
