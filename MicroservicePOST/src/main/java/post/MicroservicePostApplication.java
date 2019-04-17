package post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("post")
public class MicroservicePostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePostApplication.class, args);
	}
}
