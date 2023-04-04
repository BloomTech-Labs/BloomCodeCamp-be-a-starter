package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
    ASSIGNMENT1(1, "Assignment 1"),
    ASSIGNMENT2(2, "Assignment 2"),
    ASSIGNMENT3(3, "Assignment 3"),
    ASSIGNMENT4(4, "Assignment 4");

    private int assignmentNumber;
    private String assignmentName;

    AssignmentEnum(int assignmentNumber, String assignmentName) {
        this.assignmentNumber = assignmentNumber;
        this.assignmentName = assignmentName;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

    public String getAssignmentName() {
        return assignmentName;
    }
}
