package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    IN_PROGRESS,
    SUBMITTED,
    REJECTED,
    COMPLETED
}
