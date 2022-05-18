package com.webdev;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
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
        Customer customer = new Customer(1, "johnd", "john@gmail.com", "m38rmF$", "1-570-236-7033", new Date());

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        gsonBuilder.setDateFormat("dd-MM-yyyy");

        // field naming strategy
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                return f.getName().toUpperCase();
            }
        });

        gsonBuilder.setFieldNamingStrategy(FieldNamingPolicy.UPPER_CAMEL_CASE);

        // tranfor filed with new strategy
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                return f.getName().equals("id") ? "customerId" : f.getName();
            }
        });

        // versioning
        gsonBuilder.setVersion(1.0);

        // serialize null
        gsonBuilder.serializeNulls();

        customer = new Customer();

        Gson gson = gsonBuilder.create();

        // read from file
        try {
            File file = new File("src/main/resources/users.json");
            FileReader reader = new FileReader(file);
            gson = new Gson();
            Customer[] customers = gson.fromJson(reader, Customer[].class);

            for (Customer c : customers) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Gson gson = new Gson();

    public static String toJson(Customer customer) {
        return gson.toJson(customer);
    }

    public static Customer fromJson(String json) {
        return gson.fromJson(json, Customer.class);
    }

}
