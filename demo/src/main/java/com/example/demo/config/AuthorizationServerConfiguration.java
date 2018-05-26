package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.example.demo.service.Authorities;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter
		implements EnvironmentAware {

	private static final String ENV_OAUTH = "authentication.oauth.";
	private static final String PROP_CLIENTID = "clientid";
	private static final String PROP_SECRET = "secret";
	private static final String PROP_TOKEN_VALIDITY_SECONDS = "tokenValidityInSeconds";

	private RelaxedPropertyResolver propertyResolver;

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
//			.tokenStore(tokenStore())
			.authenticationManager(authenticationManager);
		
		 CustomDefaultTokenServices tokenServices = new CustomDefaultTokenServices();
         tokenServices.setTokenStore(endpoints.getTokenStore());
         tokenServices.setSupportRefreshToken(true);
         tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
         tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//         tokenServices.setAccessTokenValiditySeconds(2000);
//         tokenServices.refreshAccessToken(refreshTokenValue, tokenRequest);
         
//         endpoints.tokenServices(tokenServices); 
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(propertyResolver.getProperty(PROP_CLIENTID)).scopes("read", "write")
				.authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_APPROVER.name(),  Authorities.ROLE_CREATER.name())
				.authorizedGrantTypes("password", "refresh_token").secret(propertyResolver.getProperty(PROP_SECRET))
				.accessTokenValiditySeconds(
						propertyResolver.getProperty(PROP_TOKEN_VALIDITY_SECONDS, Integer.class, 10));
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH);
	}

}
