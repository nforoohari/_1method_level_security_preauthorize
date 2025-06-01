package ir.digixo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        var service = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("bita").password("1234").authorities("write").build();
        var u2 = User.withUsername("borna").password("1234").roles("write").build();
        var u3 = User.withUsername("bardia").password("1234").roles("read").build();
        service.createUser(u1);
        service.createUser(u2);
        service.createUser(u3);
        return service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }
}
