package com.hcc;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Authority.class)
public class AuthorityEntitiesTest {
    @Mock
    private Authority authority;
    private Long id;
    @Mock
    private User user;

    @BeforeEach
    public void setUp() {

        authority = new Authority("12345", user);
        user = new User();

    }

    @Test
    void testUser_getUser_ReturnsNotNull() {
        assertNotNull(authority.getUser());
        User user1 = authority.getUser();
        assertEquals(user1, authority.getUser());
    }

    @Test
    void testId_getId_ReturnsNonNull() {
        Long Id2 = authority.getId();
        assertNotNull(authority.getId());
        assertEquals(authority.getId(), Id2);
    }

    @Test
    void testId_getAuthority_ReturnsNonNullAuthority() {
        String authority1 = authority.getAuthority();
        assertNotNull(authority.getAuthority());
        assertEquals(authority1, authority.getAuthority());
    }
}
