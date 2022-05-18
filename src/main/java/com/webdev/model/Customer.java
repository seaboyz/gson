
package com.webdev.model;

import java.util.Date;

import com.google.gson.annotations.Since;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    @Since(1.0)
    private Integer id;

    @Since(1.0)
    private String username;

    @Since(1.0)
    private String email;

    @Since(1.0)
    private String password;

    @Since(1.0)
    private String phoneNumber;

    @Since(1.1)
    private Date createdAt;

}