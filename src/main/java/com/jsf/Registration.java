package com.jsf;

import com.jsf.helper.SessionUtils;
import com.jsf.helper.UserHelper;
import com.jsf.model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@SessionScoped
public class Registration implements Serializable
{
    private String login;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String birthCity;
    private String birthCountry;
    private String password;
    private String confirmPassword;

    public String validateRegistration()
    {

        if(getPassword().equals(getConfirmPassword()))
        {
            UserHelper.addToList(new User(1L, login, firstName, lastName, birthDate, birthCity, birthCountry, password));
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", login);
            return "welcome";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Passwords are not the same",
                            "Please enter correct username and Password"));
            return "registration";
        }

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
