package com.webdev;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // read from file
        try {
            JsonObject obj = new JsonObject();
            obj.addProperty("id", 101);
            obj.addProperty("username", "seaboyz");
            obj.addProperty("password", "123456");
            obj.addProperty("email", "example@example.com");

            GsonBuilder builder = new GsonBuilder();

            builder.setPrettyPrinting();

            Gson gson = builder.create();

            String json = gson.toJson(obj);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
