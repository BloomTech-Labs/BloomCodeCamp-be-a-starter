package com.hcc.entities;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "user")
    private User user;

    public Authority(Long id, String authority, User user) {
        this.id = id;
        this.authority = authority;
        this.user = user;
    }

    public Authority() {
    }

    public Long getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    public User getUser() {
        return user;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
