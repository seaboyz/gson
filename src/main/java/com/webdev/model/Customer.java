
package com.webdev.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Integer id;

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    private Date createdAt;

}