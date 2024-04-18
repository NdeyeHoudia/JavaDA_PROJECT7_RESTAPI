package com.nnk.springboot.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private  final  UserDetailsService userDetailsService;
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * PasswordEncoder is Spring Security's interface for encoding and comparing passwords
     * @return an object BCryptPasswordEncoder
     */
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * this method is the inetrface of the authentication entry point.
     * its role is to authenticate the user issuing the request
     * @param httpSecurity
     * @param encoder
     * @return  an object Authentication
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, BCryptPasswordEncoder encoder) throws Exception {
       AuthenticationManagerBuilder managerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
       managerBuilder.userDetailsService(userDetailsService).passwordEncoder(encoder);
       return  managerBuilder.build();
    }

    /**
     * This method defines the security filter chain for the application. The filter chain specifies various security configurations.
     * It configures authorization rules using authorizeHttpRequests()to allow public access to specific endpoints
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }
}