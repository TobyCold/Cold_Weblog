package top.tobycold.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("top.tobycold.service")
@PropertySource({"classpath:jdbc.properties", "classpath:music.properties"})
@Import({JdbcConfig.class, MyBatisConfig.class, MapperConfig.class})
public class SpringConfig {
}
