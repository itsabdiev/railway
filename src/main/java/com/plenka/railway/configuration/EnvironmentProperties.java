package com.plenka.railway.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.env.props")
public record EnvironmentProperties(String issuer, String properties) {

}
