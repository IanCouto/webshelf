package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Getter @Setter
public class LoginModel {
    private String email;
    private String senha;
}
