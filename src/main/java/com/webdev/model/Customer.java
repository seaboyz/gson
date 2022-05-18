
package com.webdev.model;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Since(1.0)
    private Integer id;

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

    @Since(1.1)
    private Date createdAt;
}