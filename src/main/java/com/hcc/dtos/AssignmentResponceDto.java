package com.hcc.dtos;

import com.hcc.entities.Assignment;
import com.hcc.enums.AssignmentEnum;
import com.hcc.enums.AssignmentStatusEnum;

public class AssignmentResponceDto {

    private final Assignment assignmentDetails;

    private final AssignmentStatusEnum status;

    private final AssignmentEnum assignment;

    public AssignmentResponceDto(Assignment assignmentDetails, AssignmentStatusEnum status, AssignmentEnum assignment) {
        this.assignmentDetails = assignmentDetails;
        this.status = status;
        this.assignment = assignment;
    }

    public Assignment getAssignmentDetails() {
        return assignmentDetails;
    }

    public AssignmentStatusEnum getStatus() {
        return status;
    }

    public AssignmentEnum getAssignment() {
        return assignment;
    }
}
