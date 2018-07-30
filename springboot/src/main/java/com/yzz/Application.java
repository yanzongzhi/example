package com.yzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.yzz"})
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages="") //开启ek内部请求地址扫描
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
