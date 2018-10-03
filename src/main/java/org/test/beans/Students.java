package org.test.beans;

public class Students {
    private  int age ;
    private  String id;

    public Students(){

    }

    @Override
    public String toString() {
        return "You'r "+this.id+" age is "+this.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
