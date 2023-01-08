package com.emlakcepte;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Emlakcepte Banner API", version = "1.0", description = "Banner API Information"))
public class EmlakcepteBannerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakcepteBannerServiceApplication.class, args);
	}

}
