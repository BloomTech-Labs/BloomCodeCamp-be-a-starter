package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum AssignmentStatusEnum {
    STATUS1("Submitted"),
    STATUS2("Rejected"),
    STATUS3("passed");
    private String Status;

    AssignmentStatusEnum(String Status) {
        this.Status = Status;
    }
}
