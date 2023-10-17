package com.hcc.dto;

import com.hcc.entities.Assignment;

public class updateAssignmentResponse {
    private Assignment assignment;

    public updateAssignmentResponse (Assignment assignment) {
        this.assignment = assignment;
    }
    public updateAssignmentResponse() {

    }
    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public updateAssignmentResponse(Builder builder) {
        this.assignment = builder.assignment;
    }
    public static Builder builder() { return new Builder();}

    public static final class Builder {
        private Assignment assignment;

        private Builder() {}

        public Builder withAssignment(Assignment assignmentToUse) {
            this.assignment = assignmentToUse;
            return this;
        }

        public updateAssignmentResponse build() {return new updateAssignmentResponse(this);}
    }
}
