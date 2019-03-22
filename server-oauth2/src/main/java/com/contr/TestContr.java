package com.contr;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * class name
 * <p>
 * Created  by  renxingWei  on  2019/3/20
 **/
@RestController
public class TestContr {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody
    String personInfo() {
        Map<String,Object> user = new HashMap<>();
        user.put("name","peter");
        user.put("age",22);
        user.put("country","China");
        return user.toString();
    }

    @RequestMapping("/user")
    public HttpTrace.Principal user(HttpTrace.Principal user) {
        return user;
    }


}
