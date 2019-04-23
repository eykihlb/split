package com.mydao.split.filter;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class StaticConfigurationFilter extends WebMvcConfigurerAdapter {

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/views/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}
