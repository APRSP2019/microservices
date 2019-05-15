package zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class Swagger implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("microservice-get", "/microservice-get/v2/api-docs", "2.9.2"));
		resources.add(swaggerResource("microservice-post", "/microservice-post/v2/api-docs", "2.9.2"));
		resources.add(swaggerResource("microservice-put", "/microservice-post/v2/api-docs", "2.9.2"));
		resources.add(swaggerResource("microservice-delete", "/microservice-post/v2/api-docs", "2.9.2"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}