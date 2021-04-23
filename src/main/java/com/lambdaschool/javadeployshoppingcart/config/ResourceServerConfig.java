package com.lambdaschool.javadeployshoppingcart.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)
                .stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/h2-console/**",
                        "/swagger-resources/**",
                        "/swagger-resource/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/createnewuser")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/users/user/**")
                .hasAnyRole("ADMIN", "DATA")
                .antMatchers(HttpMethod.POST, "/users/user")
                .hasAnyRole("ADMIN", "DATA")
                .antMatchers(HttpMethod.PUT, "/users/user/**")
                .hasAnyRole("ADMIN", "DATA")
                .antMatchers(HttpMethod.PATCH, "/users/user/**")
                .hasAnyRole("ADMIN", "DATA")
                .antMatchers(HttpMethod.DELETE, "/users/user/name/**")
                .hasAnyRole("ADMIN", "DATA")
                .antMatchers("/carts/**")
                .authenticated()
                .antMatchers("/roles/**", "/products/**")
                .hasAnyRole("ADMIN", "DATA")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());


        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.logout().disable();
    }
}
