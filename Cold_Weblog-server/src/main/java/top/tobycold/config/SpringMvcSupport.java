package top.tobycold.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.tobycold.interceptor.JwtToken;

public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Autowired
    JwtToken jwtToken;
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/index").addResourceLocations("/index.html");
    }
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtToken)
                .addPathPatterns("/")
                .excludePathPatterns("/login");
    }
}
