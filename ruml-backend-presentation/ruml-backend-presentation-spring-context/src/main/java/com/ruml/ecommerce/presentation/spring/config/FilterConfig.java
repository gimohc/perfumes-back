package com.ruml.ecommerce.presentation.spring.config;

import com.ruml.ecommerce.presentation.spring.filter.CorrelationIdFilter;
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
        registrationBean.setOrder(2); // Run after CorrelationIdFilter and security filters
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CorrelationIdFilter> correlationIdFilter() {
        FilterRegistrationBean<CorrelationIdFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorrelationIdFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); // Run very early to ensure all logs have a correlation ID
        return registrationBean;
    }
}
