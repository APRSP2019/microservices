package post;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-get")
@RibbonClient(name = "microservice-get")
public interface FeignRepository {

	@GetMapping(value = "redniBroj/{id}")
	public Integer redniBroj(@PathVariable("id") int id);
}
