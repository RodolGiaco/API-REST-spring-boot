package com.kube.rodo.domain;


public class Client {
    private String username;
    private String password;
    private String name;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
