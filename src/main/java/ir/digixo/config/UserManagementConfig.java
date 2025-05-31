package ir.digixo.config;

//import jakarta.persistence.PreRemove;

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
//Deprecated
//@EnableGlobalMethodSecurity
public class UserManagementConfig {


    @Bean
    public UserDetailsService userDetailsService() {
        var service = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("mahsa").password("1234").roles("read").build();
        var u2 = User.withUsername("ashkan").password("1234").authorities("write").build();

        service.createUser(u1);
        service.createUser(u2);
        return service;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


  /*  @PreRemove
    private void preventUnAuthorizedRemove() {
        String username="sdsd";

        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!name.equals(username)){
            throw new NotAuthorizedException("User can only delete himself ");
        }

    }*/

}
