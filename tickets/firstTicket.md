# Build Sprint 1

To begin work on this ticket, make sure you have: 
1. Finished getting locally setup. 
2. Completed the `Onboarding Module` in your course. 
3. Reviewed the [composition document](../documents/composition_document.md). 

# Objective

Deliver the following Domain Objects (Entities / DTO / ENUM):

## User
- id : Long
- cohortStartDate: Date
- username: String
- password: String
- authorities: List<Authority>

## Authority
- id: Long
- authority: String
- user: User

## Assignment
- id: Long
- status: String
- number: Integer
- githubUrl: String
- branch: String
- reviewVideoUrl: String
- user: User
- codeReviewer: User

## DTOs
- AssignemntResponseDto
- AuthCredentialRequest

## Enums
- AssignmentEnum
- AssignmentStatusEnum
- AuthorityEnum

# Guidance

Your job is to begin work on the LMS by setting up the domain objects shown above. 

## Subtasks

### Add User and Assignment Entities

#### Assignment - Stage 1
- id: Long
- status: String
- number: Integer
- githubUrl: String
- branch: String
- reviewVideoUrl: String
- user: User
 create a no args constructor and an all args except id constructor.

#### User - Stage 1
- id : Long
- cohortStartDate: LocalDate
- username: String
- password: String
  create a no args constructor and an all args except id constructor.

### Add Spring Security and create a Security Config

#### Uncomment the spring security dependencies inside the build.gradle file

#### Uncomment the CustomPasswordEncoder and the UserDetailsServiceImpl

- UserDetaiServiceImpl phase 1
```Java
package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    CustomPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.getPasswordEncoder().encode("asdfasdf"));
        return user;
    }
}
```

#### Create a config package and a file inside the package called SecurityConfig.java

- SecurityConfig  phase 1
```java
package com.hcc.config;

import com.hcc.services.UserDetailServiceImpl;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

}
```

#### Create the Authority Entity and Update the User Entity to implement UserDetails adding some overrides

##### Authority - Phase 1
- id: Long
- authority: String
- user: User (Many to one annotation)

##### User
Overrides
```Java
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new Authority("role_student"));
        return roles;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
            return password;
            }
```

#### Create the Enums


##### Example AssignmentEnum.java
```Java
package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
    ASSIGNMENT_1(1, "Spring Boot Service"),
    ASSIGNMENT_2(2, "Spring Boot Data JPA"),
    ASSIGNMENT_3(3, "Spring Boot Postgresql"),
    ASSIGNMENT_4(4, "Docker Compose Setup"),
    ASSIGNMENT_5(5, "React Frontend Hooks"),
    ASSIGNMENT_6(6, "Python Problems"),
    ASSIGNMENT_7(7, "Assembly Boot Sector Hello World"),
    ASSIGNMENT_8(8, "CTF Buffer Overflow"),
    ASSIGNMENT_9(9, "Docker Build"),
    ASSIGNMENT_10(10, "aws buckets"),
    ASSIGNMENT_11(11, "hashmaps and sets"),
    ASSIGNMENT_12(12, "computational counting"),
    ASSIGNMENT_13(13, "data driven websites"),
    ASSIGNMENT_14(14, "SQL Reporting");

    private int assignmentNumber;
    private String assignmentName;

    AssignmentEnum (int assignmentNumber, String assignmentName) {
        this.assignmentNumber = assignmentNumber;
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }
}
```

##### Example AssignmentStatusEnum.java
```Java
package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    PENDING_SUBMISSION("Pending Submission", 1),
    SUBMITTED("Submitted", 2),
    IN_REVIEW("In Review", 3),
    NEEDS_UPDATE("Needs Update", 4),
    COMPLETED("Completed", 5),
    RESUBMITTED("Resubmitted", 6);

    private String status;
    private Integer step;
    AssignmentStatusEnum(String status, Integer step) {
        this.status = status;
        this.step = step;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStep() {
        return step;
    }
}
```

##### Example AuthorityEnum.java
```Java
package com.hcc.enums;

public enum AuthorityEnum {
    ROLE_LEARNER,
    ROLE_REVIEWER,
    ROLE_ADMIN;
}
```

#### Create the DTOs

##### Example Assignment Response DTO
```Java
package com.hcc.dto;

import com.hcc.entities.Assignment;
import com.hcc.enums.AssignmentEnum;
import com.hcc.enums.AssignmentStatusEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentResponseDto {
    private Assignment assignment;
    private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();
    private AssignmentStatusEnum[] statusEnums = AssignmentStatusEnum.values();

    public AssignmentResponseDto(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentEnum[] getAssignmentEnums() {
        return assignmentEnums;
    }

    public AssignmentStatusEnum[] getAssignmentStatusEnums() {
        return statusEnums;
    }
}
```

##### Example Auth Credential Request

```Java
package com.hcc.dto;

public class AuthCredentialsRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```


You must: 

1. Follow the guidelines set out by the [composition document](../documents/composition_document.md). 

2. Use the tech stack given in that same document.  

# Deliverables 

Submit the following in your course: 

- Link to your forked repo with the added code for the landing page
- Link to a Loom video answering the prompt in the `Submit Your Deliverables` assignment in your course
