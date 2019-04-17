package post;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-get", url = "http://localhost:9100")
public interface FeignRepository {

	@GetMapping(value = "redniBroj/{id}")
	public Integer redniBroj(@PathVariable("id") int id);
}
