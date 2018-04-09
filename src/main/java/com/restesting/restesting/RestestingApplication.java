package com.restesting.restesting;

import com.restesting.restesting.flowManager.FlowManager;
import com.restesting.restesting.setupTools.GlobalSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

import static com.restesting.restesting.constant.IConstants.URL_F_LOWS;

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
			GlobalSetup.getInstace().addParameter(URL_F_LOWS,strings[0]);

			flowManager.executeFlows();
		} catch (IOException e) {
			System.out.println("ERROR READING FILE CONFIGURATIONS ");
		}

	}






}

