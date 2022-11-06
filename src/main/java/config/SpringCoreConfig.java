package config;

import dao.MyBeanRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCoreConfig {

    @Bean
    public MyBeanRepo myBean() {
        return new MyBeanRepo();
    }
}
