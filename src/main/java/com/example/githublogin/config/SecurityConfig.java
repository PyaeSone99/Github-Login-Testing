package com.example.githublogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.oauth2Login();
        http.authorizeHttpRequests().anyRequest().authenticated();
        return http.build();
    }
    @Bean
    public ClientRegistrationRepository clientRepository(){
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }


    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("590d3d9a1452264fd218")
                .clientSecret("21dc3302ed3777c49367899b9f67ab0e18f37b99").build();
    }
}
