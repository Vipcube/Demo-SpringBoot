package com.example.swagger.openapi.api.v1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.stereotype.Component;

/**
 * The API information.
 *
 * @author Brad Chen
 *
 */
@OpenAPIDefinition(
		info = @Info(
				title = "The API title",
				version = "v1",
				description = "Test order API",
				license = @License(name = "Apache 2.0", url = "http://foo.bar"),
				contact = @Contact(url = "http://foo-server.com", name = "Brad Chen", email = "brad@email.com")
		)
)
@Component
public class ApiInfo {
}
