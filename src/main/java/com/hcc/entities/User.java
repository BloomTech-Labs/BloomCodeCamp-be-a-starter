package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 *  Each User account stories the
 */
public class User implements UserDetails {
    private long id;
    private Date cohortStartDate;
    private String username;
    private String password;
    private List<Authority> authorities;

    public User() {}

    public User (LocalDate cohortStartDate, String username, String password) {
        // this.id = id // ask about id requirements
        this.cohortStartDate = Date.from(cohortStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(Date cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<Authority> getAuthorities() {
        List<Authority> roles = new ArrayList<>(authorities);
        return roles;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(cohortStartDate, user.cohortStartDate)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cohortStartDate, username, password, authorities);
    }
}
