package com.troncoPruebas.classroom;

import com.troncoPruebas.classroom.Service.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(AppConfig.class)
@EntityScan(basePackages = "com.troncoPruebas.classroom.models")
@EnableJpaRepositories(basePackages = "com.troncoPruebas.classroom.repositories")
public class ClassroomApplication {



	public static void main(String[] args) {
		SpringApplication.run(ClassroomApplication.class, args);
	}

}
