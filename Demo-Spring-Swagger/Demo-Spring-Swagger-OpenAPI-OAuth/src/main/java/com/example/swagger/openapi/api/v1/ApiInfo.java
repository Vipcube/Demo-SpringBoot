package com.example.swagger.openapi.api.v1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
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
// Need fixed the cors
//@SecurityScheme(
//		name = "OAuth2Security",
//		type = SecuritySchemeType.OAUTH2,
//		description = "The OAuth JWT token",
//		in = SecuritySchemeIn.HEADER,
//		bearerFormat = "JWT",
//		flows = @OAuthFlows(
//			password = @OAuthFlow(
//					tokenUrl = "http://localhost:8080/oauth/token",
//					scopes = {
//							@OAuthScope( name = "account", description = "read access" )
//					}
//			)
//		)
//)
@SecurityScheme(
		name = "Authorization",
		type = SecuritySchemeType.APIKEY,
		description = "The Bearer JWT",
		in = SecuritySchemeIn.HEADER
)
@Component
public class ApiInfo {
}
