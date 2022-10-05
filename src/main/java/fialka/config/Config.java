package fialka.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableJpaRepositories("fialka.*")
@ComponentScan(basePackages = { "fialka.*" })
@EntityScan("fialka.*")
@EnableTransactionManagement
public class Config {
}