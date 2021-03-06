
package com.webdev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Expose
    @Since(1.0)
    private String username;

    @Expose
    @Since(1.0)
    private String email;

    @Expose
    @Since(1.0)
    private String password;

    @Expose
    @Since(1.0)
    private String phoneNumber;

}