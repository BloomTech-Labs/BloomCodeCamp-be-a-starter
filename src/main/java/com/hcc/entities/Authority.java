package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Authority(Long id , String authority , User user) {
        this.id = id;
        this.authority = authority;
        this.user = user;
    }

    private Authority(Builder builder) {
        id = builder.id;
        authority = builder.authority;
        user = builder.user;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String authority;
        private User user;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

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
