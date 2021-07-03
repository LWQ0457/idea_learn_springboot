package com.lwq.springboot.helloworld.demo.controller;

import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class helloworld {
    @RequestMapping("/hello")
    public String hello(){
        return "第一个springboot的helloworld程序";
    }
    @RequestMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getinfo(@PathVariable Integer id,//路径可变参数
                                       @PathVariable String name,//路劲可变参数
                                       @PathVariable Map<String,String> pv,//路径可变参数集合
                                       @RequestHeader("user-agent") String requestHeader,//指定请求头
                                       @RequestHeader Map<String,String> header,//所有请求头信息
                                       @RequestParam("age") Integer age,//获取指定参数?age=12&address=广西,这种参数
                                       @RequestParam Map<String,String> allinfo,//获取问号后所有参数
                                       @CookieValue("_ga") String cookievalue,//获取cookide的变量值
                                       @CookieValue Cookie cookie,//获取cookide
                                       HttpServletRequest request,
                                       HttpServletResponse response,
                                       Session session
    ){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("info",pv);

        return map;
    }

    //通过request.setAttibute(key,value)//设置request域中属性
    @PostMapping
    public Map<String,Object> postmethod(@RequestBody String content,//获取请求体数据所有数据
                                         @RequestAttribute("username") String name//获取request域中属性
                                         ){
        return new HashMap<>();
    }
}
