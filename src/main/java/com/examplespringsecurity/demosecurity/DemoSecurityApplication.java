package com.examplespringsecurity.demosecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication //implements CommandLineRunner
{

	public static void main(String[] args)
	{

		SpringApplication.run(DemoSecurityApplication.class, args);
		System.out.println("hello!!");

		//this piece of code will generate encoded password
		//========================================================
	 	/*BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("pratik123"));
		System.out.println(encoder.encode("karan123"));*/
		//================================================


	}

/*	@Override
	public void run(String...args) throws Exception
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("pratik123"));
		System.out.println(encoder.encode("karan123"));


	}*/

}
