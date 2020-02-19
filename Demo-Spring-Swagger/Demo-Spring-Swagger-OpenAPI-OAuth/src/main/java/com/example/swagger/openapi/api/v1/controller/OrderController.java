package com.example.swagger.openapi.api.v1.controller;

import com.example.swagger.openapi.api.v1.model.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag( name = "order", description = "The order API" )
@RestController
public class OrderController {

	@Operation(
			summary = "Get order from the call api.",
			tags = {
				"order"
			},
			security =  @SecurityRequirement( name = "Authorization" )
	)
	@ApiResponses( value = {
			@ApiResponse(
					responseCode = "200",
					description = "successful operation",
					content = {
						@Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
						schema = @Schema( implementation = Order.class ) )
					}
				)
	})
	@GetMapping( value = "/order", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Order> getOrder( @RequestParam Long id, @RequestParam Integer quantity ){
		return ResponseEntity.ok(
				Order.builder()
					.id( id )
					.quantity( quantity )
					.build() );
	}
}
