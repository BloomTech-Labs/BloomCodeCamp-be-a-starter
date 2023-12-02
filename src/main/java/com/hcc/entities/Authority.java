package com.hcc.entities;

public class Authority {
    private Long id;
    private String authority;
    private User user;

    public Authority() {
    }
    public Authority(String authority) {
        this.authority = authority;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
