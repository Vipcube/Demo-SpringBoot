package org.example.spring.boot.prometheus.app.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusMetricConfig {
	@Value( "${spring.application.name}" )
	private String application;

	@Bean
	public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> registry.config().commonTags("application", this.application );
	}
}
