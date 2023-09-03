package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.study.orm.mapper"})
public class ShardingSphereSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereSimpleApplication.class, args);
	}

}
