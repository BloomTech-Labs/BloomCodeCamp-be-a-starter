package com.hcc.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date cohortStartDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "authorities")
    private List<Authority> authorities;

    protected User(Long id , Date cohortStartDate , String username,
                String password , List<Authority> authorities) {
        this.id = id;
        this.cohortStartDate = cohortStartDate;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.cohortStartDate = builder.cohortStartDate;
        this.username = builder.username;
        this.password = builder.password;
        this.authorities = builder.authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(Date cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Date cohortStartDate;
        private String username;
        private String password;
        private List<Authority> authorities;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCohortStartDate(Date cohortStartDate) {
            this.cohortStartDate = cohortStartDate;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withAuthorities(List<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
