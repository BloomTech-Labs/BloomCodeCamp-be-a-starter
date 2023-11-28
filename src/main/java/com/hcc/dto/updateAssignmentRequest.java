package com.hcc.dto;

import com.hcc.entities.User;

public class updateAssignmentRequest {

    private String status;
    private int number;
    private String githubUrl;
    private String branch;
    private String reviewVideoUrl;
    private User user;
    private User codeReviewer;

    public updateAssignmentRequest( String status, int number, String githubUrl, String branch, String reviewVideoUrl, User user, User codeReviewer) {

        this.status = status;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }
    public updateAssignmentRequest() {}


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }

    public updateAssignmentRequest(Builder builder) {

        this.status = builder.status;
        this.number = builder.number;
        this.githubUrl = builder.githubUrl;
        this.branch = builder.branch;
        this.codeReviewer = builder.codeReviewer;
        this.user = builder.user;
        this.reviewVideoUrl = builder.reviewVideoUrl;
    }
    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String status;
        private int number;
        private String githubUrl;
        private String branch;
        private String reviewVideoUrl;
        private User user;
        private User codeReviewer;

        private Builder() {}

        public  Builder withId(Long idToUse) {
            return this;
        }
        public Builder withStatus(String statusToUse) {
            this.status = statusToUse;
            return this;
        }
        public Builder withNumber (int numberToUse) {
            this.number = numberToUse;
            return this;
        }
        public Builder withGithubUrl(String githubUrlToUse) {
            this.githubUrl = githubUrlToUse;
            return this;
        }
        public Builder withBranch(String branchToUse) {
            this.branch = branchToUse;
            return this;
        }
        public Builder withReviewVideoUrl(String reviewVideoUrlToUse) {
            this.reviewVideoUrl = reviewVideoUrlToUse;
            return this;
        }
        public Builder withCodeReviewer(User codeReviewerToUse) {
            this.codeReviewer = codeReviewerToUse;
            return this;
        }
        public Builder withUser(User userToUse) {
            this.user = userToUse;
            return this;
        }
        public updateAssignmentRequest build() {return new updateAssignmentRequest(this);}
    }
}
