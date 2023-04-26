package com.hcc.config;//package com.hcc.config;
//
//
//import com.hcc.services.UserDetailServiceImpl;
//import com.hcc.utils.CustomPasswordEncoder;
//import com.hcc.utils.JwtFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletResponse;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
////might need authentication manager
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserDetailServiceImpl userDetailsServiceImpl;
//
//    @Autowired
//    CustomPasswordEncoder customPasswordEncoder;
//
//    @Autowired
//    JwtFilter filter;
//
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsServiceImpl)
//                .passwordEncoder(customPasswordEncoder.getPasswordEncoder());
//
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeRequests(auth ->
//                        auth.antMatchers("/api/auth/**")
//                                .permitAll()
//                                .anyRequest()
//                                .authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint((request , response , exception1) -> {
//                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception1.getMessage());
//                        }))
//                .httpBasic(withDefaults())
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeRequests(auth ->
//                        auth.antMatchers("/api/auth/**")
//                                .permitAll()
//                                .anyRequest()
//                                .authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint((request , response , exception1) -> {
//                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception1.getMessage());
//                        }))
//                .httpBasic(withDefaults())
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable(); // do not disable this lot here just for now!!
//
//        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
//
//        http = http.exceptionHandling().authenticationEntryPoint((request, response, exception) -> {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
//        }).and();
//
//        http.authorizeRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api-docs/**").permitAll()
//                .antMatchers("/v3/api-docs/**").permitAll()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/swagger-ui/**").permitAll()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated();
//        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//}

import com.hcc.services.UserDetailServiceImpl;
import com.hcc.utils.CustomPasswordEncoder;
import com.hcc.utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    JwtFilter jwtfilter;

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable(); // do not dissable this lot here just for now!!

        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        http = http.exceptionHandling().authenticationEntryPoint((request, response, exception) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
        }).and();

        http.authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(jwtfilter , UsernamePasswordAuthenticationFilter.class);
    }

}
