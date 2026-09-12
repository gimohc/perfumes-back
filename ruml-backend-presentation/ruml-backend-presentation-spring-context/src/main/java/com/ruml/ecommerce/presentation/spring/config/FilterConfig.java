package com.ruml.ecommerce.presentation.spring.config;

import com.ruml.ecommerce.presentation.spring.filter.RequesterContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequesterContextFilter> requesterContextFilter(LocaleResolver localeResolver) {
        FilterRegistrationBean<RequesterContextFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequesterContextFilter(localeResolver));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); // Run after security filters (which are usually Order 0 or negative)
        return registrationBean;
    }
}
