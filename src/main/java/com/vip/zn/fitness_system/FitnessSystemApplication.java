package com.vip.zn.fitness_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.vip.zn.fitness_system.db.mapper")
@EnableConfigurationProperties
public class FitnessSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessSystemApplication.class, args);
    }
}
