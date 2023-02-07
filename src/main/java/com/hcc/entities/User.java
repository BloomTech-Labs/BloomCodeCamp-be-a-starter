package com.hcc.entities;

import java.util.Date;
import java.util.List;

public class User {
    private Long id;

    private Date cohortStartDate;
    private String username;
    private String password;
    private List<Authority> authorities;


}
