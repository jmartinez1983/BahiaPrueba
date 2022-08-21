package com.prueba.bahia.config;

import feign.Feign;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> circuitBreakerFactoryCustomizer() {
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(60)).build();
        return resilience4JCircuitBreakerFactory -> resilience4JCircuitBreakerFactory.configure(builder ->
                builder.timeLimiterConfig(timeLimiterConfig), "UserSessionClient#validateSession(UUID)");
    }

    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
        return (feignClientName, target, method) -> Feign.configKey(target.type(), method);
    }
}