package top.tobycold.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"top.tobycold.service"})
@PropertySource({"classpath:jdbc.properties", "classpath:resources.properties"})
@Import({JdbcConfig.class, MyBatisConfig.class, MapperConfig.class})
public class SpringConfig {
}
