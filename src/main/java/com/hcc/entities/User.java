package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cohort_start_date")
    private Date cohortStartDate;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
//    @Column(name = "List_of_Authorities")
//    private List<Authority> authorities;

    public User(Date cohortStartDate, String username, String password) { // List<Authority> authorities
        this.cohortStartDate = cohortStartDate;
        this.username = username;
        this.password = password;
//        this.authorities = authorities;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public Date getCohortStartDate() {
        return cohortStartDate;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new Authority("ROLE_LEARNER"));
        return roles;
    }

    public String getPassword() {
        return password;
    }

//    public List<Authority> getAuthorities() {
//        return authorities;
//    }

    public void setCohortStartDate(Date cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setAuthorities(List<Authority> authorities) {
//        this.authorities = authorities;
//    }
}
