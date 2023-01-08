package emlakcepte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmlakcepteGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakcepteGatewayApplication.class, args);
	}

}
