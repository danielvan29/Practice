package com.van.pojo;

import org.apache.ibatis.type.Alias;

@Alias("ac")
public class Account {
    private int id;
    private String user;
    private float ball;

    public Account() {
    }

    public Account(int id, String user, float ball) {
        this.id = id;
        this.user = user;
        this.ball = ball;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getball() {
        return ball;
    }

    public void setball(float ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", ball=" + ball +
                '}';
    }
}
