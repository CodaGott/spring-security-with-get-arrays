package com.security.spring.security;

import com.security.spring.security.model.Role;
import com.security.spring.security.model.User;
import com.security.spring.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Jonny", "Jon", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Willy", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jimmy", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold", "Arn", "1234", new ArrayList<>()));

			userService.addRoleToUser("Jon", "ROLE_ADMIN");
			userService.addRoleToUser("Arn", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_SUPER_ADMIN");

		};
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
