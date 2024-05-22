package com.hcc.entities;

import java.util.Objects;

public class Assignment {
    private long id;
    private String status;
    private int number;
    private String githubUrl;
    private String branch;
    private String reviewVideoUrl;
    private User user;
    private User codeReviewer;

    public Assignment(String status, int number, String githubUrl, String branch, String reviewVideoUrl, User user) {
        // this.id = id;
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
    }

    public Assignment() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id == that.id && number == that.number && Objects.equals(status, that.status) && Objects.equals(githubUrl, that.githubUrl) && Objects.equals(branch, that.branch) && Objects.equals(reviewVideoUrl, that.reviewVideoUrl) && Objects.equals(user, that.user) && Objects.equals(codeReviewer, that.codeReviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, number, githubUrl, branch, reviewVideoUrl, user, codeReviewer);
    }
}
