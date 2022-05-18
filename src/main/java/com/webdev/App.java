package com.webdev;

import com.google.gson.Gson;
import com.webdev.model.Customer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("johnd", "john@gmail.com", "m38rmF$", "1-570-236-7033");

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
