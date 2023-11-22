package top.tobycold.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.tobycold.interceptor.JwtTokenAdminInterceptor;

@Slf4j
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器……");
        log.info("{}", jwtTokenAdminInterceptor);
        registry.addInterceptor(jwtTokenAdminInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/console/login")
                .excludePathPatterns("/data/logo");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
