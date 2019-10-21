package edu.ccsu.sped.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class SpedWorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpedWorkflowApplication.class, args);
	}

}
