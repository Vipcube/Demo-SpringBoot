package com.example.swagger.openapi.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * The sample model.
 *
 * @author Brad Chen
 *
 */
@Data
@Builder
public class Order {
	@Schema( example = "198772", description = "The id" )
	private Long id;

	@Schema( example = "0", description = "The quantity" )
	private Integer quantity;
}
