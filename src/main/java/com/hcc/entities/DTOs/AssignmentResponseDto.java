package com.hcc.entities.DTOs;

import java.time.LocalDateTime;

public class AssignmentResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private String status;

    public AssignmentResponseDto(Long id , String title , String description , LocalDateTime deadline , String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    protected AssignmentResponseDto(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.deadline = builder.deadline;
        this.status = builder.status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private LocalDateTime deadline;
        private String status;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Builder withDeadline(LocalDateTime deadline) {
            this.deadline = deadline;
            return this;
        }

        Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        AssignmentResponseDto build() {
            return new AssignmentResponseDto(this);
        }
    }
}
