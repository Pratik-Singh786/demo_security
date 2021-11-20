package com.examplespringsecurity.demosecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @GetMapping("/user")
    public String getUser(@RequestParam("name")String name)
        {
            return "hi"+name;

        }


    @GetMapping("/student/greet")
    public String greetStudent(@RequestParam("name")String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "hi Student: " +name;
    }

    @PostMapping("/student/greet2")
    public String greetStudent2(@RequestParam("name")String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "hi Student: " +name;
    }

    @GetMapping("/faculty")
    public String getFaculty(@RequestParam("name")String name)

    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();// its just holding the authentication object, i.e details of the user
        return "hi faculty: " +name;
    }
    @GetMapping("/")
    public String greetPublic(@RequestParam("name")String name)

    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "hi Public User: " +name;
    }




}
