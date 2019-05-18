package com.jsf;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.jsf.helper.SessionUtils;
import com.jsf.service.LoginService;
import com.jsf.service.LoginServiceImpl;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String pwd;
    private String msg;
    private String user;

    public String validateUsernamePassword()
    {
        boolean valid = loginService.login(user, pwd);
        if (valid)
        {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "welcome";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    public String moveToRegisterPage()
    {
        return "registration";
    }

    public String logout()
    {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }


    private static final long serialVersionUID = 1094801825228386363L;
    LoginService loginService = new LoginServiceImpl();

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserName()
    {
        if(user == null || user.isEmpty())
        {
            HttpSession session = SessionUtils.getSession();
            return user = session.getAttribute("username").toString();
        }
        return user;
    }
    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}