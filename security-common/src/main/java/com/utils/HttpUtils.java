package com.utils;

import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * class name
 * <p>
 * Created  by  renxingWei  on  2019/3/19
 **/
public class HttpUtils {

    public static HttpHeaders getHeaders() {// 要进行一个Http头信息配置
        HttpHeaders headers= new HttpHeaders(); //定义一个HTTP的头信息
        // 此处写死，生产环境应该传入参数或者去配置中心认证中心获取用户信息
        String auth= "admin:admin";// 认证的原始信息
        byte[]encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));// 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader= "Basic " +new String(encodedAuth);// 此处一定要加"Basic "，一定有个空
        headers.set("Authorization",authHeader);
        return headers;
    }
}
