package com.security.controller;

import com.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.plugin2.main.server.Plugin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * class name
 * <p>
 * Created  by  renxingWei  on  2019/3/18
 **/
@RestController
public class TestCotr {

    private RestTemplate restTemplate = new RestTemplate();


    @RequestMapping("sessionId")
    public String id(HttpServletRequest request) {
        return request.getSession().getId();
    }


    @RequestMapping("test001")
    public String test001(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @RequestMapping("test002")
    public String test002() {
        Object obj = restTemplate.getForObject("http://admin:admin@localhost:8093/test001", String.class);
        return obj.toString();
    }

    @RequestMapping("test003")
    public String test003() {
        HttpHeaders headers = new HttpHeaders(); //定义一个HTTP的头信息
        String auth = "user1:123456";// 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));// 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        //Object obj = restTemplate.exchange("http://localhost:8092/sessionId", HttpMethod.GET,
        //        new HttpEntity(HttpUtils.getHeaders()), String.class).getBody();
        Object obj = restTemplate.exchange("http://localhost:8092/sessionId", HttpMethod.GET,
                new HttpEntity(headers), String.class).getBody();
        return obj.toString();
    }


}
