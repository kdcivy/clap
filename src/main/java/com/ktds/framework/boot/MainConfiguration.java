package com.ktds.framework.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.ktds.framework.sample.boot.*Configuration*") // Package is not exist.
//@Import({RootContextConfiguration.class, ServletContextConfiguration.class }) // XML Configuration
@Import({RootContextMultipleConfig.class, ServletContextConfig.class, SubJdbcProfile.class, SubJpaProfile.class, SubMybatisMultipleProfile.class}) // JAVA Configuration
public class MainConfiguration {

}
