package com.mashibing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/mashibing/mapper")
public class CloudProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProgramApplication.class, args);
    }

}
