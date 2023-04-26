package com.hcc.utils;

import com.hcc.repositories.UserRepository;:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWtUtils jwtUtils;
    @Autowired
    private UserRepository userRepo;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    // Get Authorization header and validate
    final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (!StringUtils.hasText(header) || (StringUtils.hasText(header) && !header.startsWith("Bearer "))) {
        filterChain.doFilter(request,response);
        System.out.println("broken header!");
        return;
    }

    // Get Jwt Token
    final String token = header.split(" ")[1].trim();
    System.out.println(token);
    // Get user identity
    UserDetails userDetails = userRepo.findByUsername(jwtUtils.getUsernameFromToken(token)).orElse(null);

    if (!jwtUtils.validateToken(token, userDetails)) {
        filterChain.doFilter(request,response);
        return;
    }

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            userDetails, null,
            userDetails == null ?
                    List.of() : userDetails.getAuthorities()
    );

    authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request,response);

}
}