package com.hcc.entities.DTOs;

public class AssignmentResponseDto {
    private String status;
    private Integer number;
    private String githubUrl;
    private String branch;
    private String reviewVideoUrl;

    public AssignmentResponseDto(String status ,
                                 Integer number , String githubUrl ,
                                 String branch , String reviewVideoUrl) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public AssignmentResponseDto(Builder builder) {
        this.status = builder.status;
        this.number = builder.number;
        this.githubUrl = builder.githubUrl;
        this.branch = builder.branch;
        this.reviewVideoUrl = builder.reviewVideoUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String status;
        private Integer number;
        private String githubUrl;
        private String branch;
        private String reviewVideoUrl;

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public Builder withGithubUrl(String githubUrl) {
            this.githubUrl = githubUrl;
            return this;
        }

        public Builder withBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder withReviewVideoUrl(String reviewVideoUrl) {
            this.reviewVideoUrl = reviewVideoUrl;
            return this;
        }

        public AssignmentResponseDto build() {
            return new AssignmentResponseDto(this);
        }
    }
}
