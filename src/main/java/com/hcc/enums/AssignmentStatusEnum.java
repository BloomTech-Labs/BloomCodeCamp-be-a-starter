package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private String status;

    AssignmentStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
