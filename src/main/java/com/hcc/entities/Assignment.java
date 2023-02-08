package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "current_status")
    private String status;
    @Column(name = "assignment_number")
    private int number;
    @Column(name = "github_url")
    private String githubUrl;
    @Column(name = "review_video_url")
    private String reviewVideoUrl;
    @Column(name = "user")
    private User user;
    @Column(name = "code_reviewer")
    private User codeReviewer;

    public Assignment(Long id, String status, int number, String githubUrl, String reviewVideoUrl, User user, User codeReviewer) {
        this.id = id;
        this.status = status;
        this.number = number; //TODO: need to make this auto increment each time a new assignment is created
        this.githubUrl = githubUrl;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }

    public Assignment() {
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
