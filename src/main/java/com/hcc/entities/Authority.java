package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    @ManyToOne(optional=false)
    private User user;


    public Authority() { }

    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    private Authority(Builder builder) {
        this.authority = builder.authority;
        this.user = builder.user;
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

    @Override
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String authority;
        private User user;

        public Builder withAuthority(String authority) {
            this.authority = authority;
            return this;
        }

        public Builder withUser(User user) {
            this.user = user;
            return this;
        }

        public Authority build() {
            return new Authority(this);
        }
    }
}
