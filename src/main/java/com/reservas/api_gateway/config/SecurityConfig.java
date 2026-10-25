package com.reservas.api_gateway.config;

import com.reservas.security.JwtSupportConfiguration;
import com.reservas.security.JwtTokenProvider;
import com.reservas.security.SecurityProperties;
import com.reservas.security.StatelessSecuritySupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

/** El tráfico entra por el gateway: JWT válido y rol según {@code app.security.rules}. */
@Configuration
@EnableWebSecurity
@Import(JwtSupportConfiguration.class)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http,
			SecurityProperties properties,
			JwtTokenProvider tokenProvider,
			AuthenticationEntryPoint authenticationEntryPoint,
			AccessDeniedHandler accessDeniedHandler
	) throws Exception {
		return StatelessSecuritySupport.build(
				http,
				properties,
				tokenProvider,
				authenticationEntryPoint,
				accessDeniedHandler
		);
	}
}
