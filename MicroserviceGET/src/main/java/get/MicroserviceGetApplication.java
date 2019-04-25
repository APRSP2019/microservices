package get;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetApplication.class, args);
	}
}
