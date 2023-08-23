package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.metier.ArticleService;
import com.example.demo.metier.SecuriteService;

@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =  
				SpringApplication.run(TestJpaApplication.class, args);
		
		
		
		/*
		 * SecuriteService secServ = context.getBean(SecuriteService.class); //String
		 * AppUser u1 = new AppUser("Ahmed", "1234"); secServ.addUser(u1);
		 * 
		 * 
		 * AppUser u2 = new AppUser("Sara", "1234"); secServ.addUser(u2);
		 * 
		 * 
		 * AppRole r1 = new AppRole("admin", "Le chef"); secServ.addRole(r1);
		 * 
		 * AppRole r2 = new AppRole("user", "");
		 * 
		 * secServ.addRole(r2);
		 * 
		 * secServ.addRoleToUser(r1, u1); secServ.addRoleToUser(r2, u2);
		 */
		  
		 
	}

}
