package spm.bjmh.SPM2020BJMH.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spm.bjmh.SPM2020BJMH.services.MongoUserDetailsService;

@Configuration
@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    MongoUserDetailsService userDetailsService;

    //  encoding and comparing password hashes
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
        //authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    // tells Spring Security how we configure CORS
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity disable = http
                //Disables CSRF Protection because it is not needed for the API
                .csrf().disable()
                // Declares that all requests to any endpoint must be authorized, otherwise they must be rejected.
                .authorizeRequests()
                .anyRequest().authenticated()
                // so that it expects basic HTTP authentication
                .and().httpBasic()
                //  tells Spring not to store session information for users, as this is not necessary for the API
                .and().sessionManagement().disable();
                 antMatchers("/api/test/**","/register", "/register/driver" , "/register/policeman");
        /*

        http.cors().and().csrf().disable()
              .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().
                antMatchers()
                antMatchers("/api/test/**");
                .permitAll()
                .permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

         */
    }

    private void antMatchers(String s, String s1, String s2, String s3) {
    }
}