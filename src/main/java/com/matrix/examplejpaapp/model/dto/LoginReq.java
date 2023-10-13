package com.matrix.examplejpaapp.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginReq {
    private String username;
    private String password;
}
