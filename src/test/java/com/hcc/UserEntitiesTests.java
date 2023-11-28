package com.hcc;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest(classes = User.class)
public class UserEntitiesTests {

    @Mock
    private User user;
    private List<Authority> list;
    private Authority authority;
    private Date date;
    @BeforeEach
    public void setUp() {
        date = new Date(12-24-2012);
        list = new ArrayList<>();
        authority = new Authority("13579", user);
        list.add(authority);
        user = new User(date,"tom", "12343", list);
    }
    @Test
    void testUsername_getUsername_NonNullValue() {
        Assertions.assertNotNull(user.getUsername());
        assertEquals("tom", user.getUsername());
    }
    @Test
    void testUserDate() {
        assertNotNull(user.getCohortStartDate());
        assertEquals(date, user.getCohortStartDate());
    }
    @Test
    void testPassword_getPassword_returnsNonNullValue() {
        assertNotNull(user.getPassword());
        assertEquals("12343", user.getPassword());
    }
    @Test
    void checkauthorities_getAuthorities_returnsAuthority() {
        User user2 = new User();
        Authority authority1 = new Authority("13579", list.get(0).getUser());
        User user1 = list.get(0).getUser();

        assertNotNull(user.getAuthorities());
        assertEquals(authority1.getUser(), user1);
        assertNotNull(list.get(0).getAuthority());
        assertNotNull(list.get(0).getUser());
        assertNotNull(list.get(0).getId());
    }
}
