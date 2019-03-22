package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

//@SpringCloudApplication
//@EnableAuthorizationServer
//@EnableFeignClients("com.peng.main.client")
@SpringBootApplication
@EnableAuthorizationServer
public class AuthCenterProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthCenterProviderApplication.class, args);
    }
}
