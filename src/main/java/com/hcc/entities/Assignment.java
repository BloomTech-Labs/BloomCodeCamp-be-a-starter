package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "assignments" )
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    private String status;

    @Column(name = "number")
    private Integer number;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "branch")
    private String branch;

    @Column(name = "review_video_url")
    private String reviewVideoUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "code_reviewer")
    private User codeReviewer;

    protected Assignment(long id , String status , Integer number , String githubUrl,
                      String branch , String reviewVideoUrl , User user , User codeReviewer) {
        this.id = id;
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }

    private Assignment(Builder builder) {
        this.id = builder.id;
        this.status = builder.status;
        this.number = builder.number;
        this.githubUrl = builder.githubUrl;
        this.branch = builder.branch;
        this.reviewVideoUrl = builder.reviewVideoUrl;
        this.user = builder.user;
        this.codeReviewer = builder.codeReviewer;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String status;
        private Integer number;
        private String githubUrl;
        private String branch;
        private String reviewVideoUrl;
        private User user;
        private User codeReviewer;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

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

        public Builder withUser(User user) {
            this.user = user;
            return this;
        }

        public Builder withCodeReviewer(User codeReviewer) {
            this.codeReviewer = codeReviewer;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }

}
