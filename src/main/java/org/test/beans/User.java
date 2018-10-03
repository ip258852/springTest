package org.test.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String uid;
    private String name;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
