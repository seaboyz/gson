
package com.webdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

}