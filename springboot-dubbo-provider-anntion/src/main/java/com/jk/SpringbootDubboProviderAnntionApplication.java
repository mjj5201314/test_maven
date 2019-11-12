package com.jk;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.mapper")

public class SpringbootDubboProviderAnntionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboProviderAnntionApplication.class, args);
    }

}
