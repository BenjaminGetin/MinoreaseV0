package fr.v0.minorease.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                .requestMatchers("/api/hotels/search").permitAll()
                .requestMatchers("/api/hotels/all").permitAll()
                .requestMatchers("/api/hotels/**").authenticated()
                .anyRequest().permitAll()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("test@test.com")
                .password(passwordEncoder.encode("Motdepasse@2"))
                .roles("PARENTS")
                .and()
                .withUser("test@test.fr")
                .password(passwordEncoder.encode("Motdepasse@1"))
                .roles("CHILD");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
