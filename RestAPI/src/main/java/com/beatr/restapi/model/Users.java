package com.beatr.restapi.model;

import java.util.List;

public class Users {
    private List<User> usersList;

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
