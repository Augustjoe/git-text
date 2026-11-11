package com.webDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    private int id;
    private String username;
    private String name;
    private String token;

}
