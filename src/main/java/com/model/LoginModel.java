package com.model;

import com.Utils.Util;
import com.dao.LoginDao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginBean")
@SessionScoped
@Getter
@Setter
public class LoginModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;

    public LoginModel() {
        this.password = "";
        this.uname = "";
    }

    public String loginProject() {
        System.out.println("Email: " + this.uname + "\n"
                + "Senha: " + this.password + "\n");
        boolean result = LoginDao.login(uname, password);
        if (result) {

            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));

            // invalidate session, and redirect to other pages
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "login";
    }
}