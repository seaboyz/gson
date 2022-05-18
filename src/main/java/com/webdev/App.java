package com.webdev;

import java.util.Date;

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

        Gson gson = gsonBuilder.create();

        System.out.println(gson.toJson(customer));

        System.out.println(toJson(customer));
    }

    public static Gson gson = new Gson();

    public static String toJson(Customer customer) {
        return gson.toJson(customer);
    }

    public static Customer fromJson(String json) {
        return gson.fromJson(json, Customer.class);
    }

}
