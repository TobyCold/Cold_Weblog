package top.tobycold.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(value = {"top.tobycold.controller", "top.tobycold.interceptor", "top.tobycold.config"},excludeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = PropertySource.class
        )
})
@EnableWebMvc
@Slf4j
public class SpringMvcConfig {

    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.tobycold.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("Cold_Weblog项目接口文档")
                .description("Cold_Weblog项目接口文档")
                .version("2.0")
                .build();
    }
}
