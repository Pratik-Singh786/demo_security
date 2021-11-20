package com.examplespringsecurity.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config extends WebSecurityConfigurerAdapter
{
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
    //authentication function

        auth.inMemoryAuthentication()
                .withUser("pratik")

                .password("$2a$10$XYwQbMcuLkguwgz63mX6m.T0u105eeGIJnsJaNnRY7KrT7l0PsTsS")// in backend i don't want to expose the user password but during login i want to write pratik123
                .authorities("FACULTY")
                .and()
                .withUser("karan")
                .password("$2a$10$AbMB1A6eMAfXUREqQ2bbbupFOth8VjdlvUrpBDAY7tG8agehZQree")//encrypted form of password
                .authorities("STUDENT");



    }
    //authorization function
    //.Every faculty should be able to operate on student APIs as well

    //1.Either give your faculty multiple authorities
    //2.Give only one authority to the user and while  authorizing check for multiple scopes
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
         http.authorizeRequests()
                //.antMatchers("/student/**").hasAuthority("STUDENT")
                 .antMatchers(HttpMethod.POST,"/student/greet2/**").hasAuthority("FACULTY")
                 .antMatchers(HttpMethod.GET,"/student/*").hasAnyAuthority("STUDENT","FACULTY")//bcz it contains all after student/

                 .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .antMatchers("/**").permitAll() //least restricted api put in the last.
                .and()
                .formLogin();
    }
   /* @Bean
    public PasswordEncoder getEncoder()
    {
        return NoOpPasswordEncoder.getInstance();// this  is using the singleton concept
    }*/


    @Bean
    public PasswordEncoder getBEncoder()  // and for this spring is creating a new password everytime.
    {
        return new  BCryptPasswordEncoder();//plain password that we are passing in login will be encoded and then matched with  the password
                                            //present in the inMemoryAuthentication() which is also in encoded form
    }



}
