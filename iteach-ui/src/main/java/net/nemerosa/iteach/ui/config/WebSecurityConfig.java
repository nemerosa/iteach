package net.nemerosa.iteach.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private APIBasicAuthenticationEntryPoint apiBasicAuthenticationEntryPoint;

    /**
     * By default, all queries are accessible anonymously. Security is enforced at service level.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .httpBasic()
                .authenticationEntryPoint(apiBasicAuthenticationEntryPoint)
                .realmName("iteach")
                .and()
                .logout()
                .logoutUrl("/api/account/logout")
                .logoutSuccessUrl("/api/account/logged-out")
                .and()
                        //.csrf().requireCsrfProtectionMatcher(new CSRFRequestMatcher()).and()
                        // FIXME CSRF protection for a stateless API?
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager);
    }

}
