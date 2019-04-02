package com.jsf.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class User
{
    private long id;
    private String login;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String birthCity;
    private String birthCountry;
    private String password;
    private boolean canEdit;

    public User(long id, String login, String firstName, String lastName, Date birthDate, String birthCity, String birthCountry, String password) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
        this.password = password;
        canEdit = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setBirthDate(Object birthDate) {
        this.birthDate = (Date) birthDate;
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

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }
}