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

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("manager").password("password").roles("MANAGER");
    }
    /*
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
        //authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
     */

    @Override
    // tells Spring Security how we configure CORS
    protected void configure(HttpSecurity http) throws Exception {
        http
                //Disables CSRF Protection because it is not needed for the API
                .csrf().disable()
                // Declares that all requests to any endpoint must be authorized, otherwise they must be rejected.
                .authorizeRequests().antMatchers(
                        "/",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                // so that it expects basic HTTP authentication
                .and().httpBasic()
                //  tells Spring not to store session information for users, as this is not necessary for the API
                .and().sessionManagement().disable()
                //form-based authentication is enabled with a custom login page and failure url
                .formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
                .and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        /*
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

         */
    }
}