package com.cashfinance.cashfinancesf.model;

public class User {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String type;

    public User(){

    }

    public User(String email){
        this.setEmail(email);

    }

    // constructor to do register
    public User(String name, String email, String phone, String password, String type){
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);
        this.setType(type);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
