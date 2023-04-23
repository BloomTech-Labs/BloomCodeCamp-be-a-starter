package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AuthorityEnum {
    REVIEWER("REVIEWER"),
    LEARNER("LEARNER");

    private String authority;

    AuthorityEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
