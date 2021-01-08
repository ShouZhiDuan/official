package com.official.nvclouds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * created by dsz
 * 锘崴官网后台服务
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.official.nvclouds.mapper"})
public class NvcloudsOfficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(NvcloudsOfficialApplication.class, args);
    }

}
