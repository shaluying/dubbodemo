package com.shaluy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shaluy.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class HelloController {

    //在服务消费者一方配置负载均衡策略
    @Reference(loadbalance = "random") //导入dubbo提供的注解
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String getName(String name){
        System.out.println("helloService = " + helloService.getClass().getName());

        //远程调用
        String result = helloService.sayHello(name);

        return "hello:"+result;
    }

}
