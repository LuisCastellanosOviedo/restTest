package com.restesting.restesting;

import com.restesting.restesting.flowManager.FlowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan
public class RestestingApplication  implements CommandLineRunner {



	@Autowired
	FlowManager flowManager;



	public static void main(String[] args) {
		SpringApplication.run(RestestingApplication.class, args).close();
	}


	@Override
	public void run(String... strings) {
		try {
			flowManager.executeFlows();
		} catch (IOException e) {
			System.out.println("ERROR READING FILE CONFIGURATIONS ");
		}

	}






}

