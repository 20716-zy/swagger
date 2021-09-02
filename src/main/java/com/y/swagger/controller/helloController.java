package com.y.swagger.controller;

import com.y.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping(value = "/t")
    public String to(){
        return "index";
    }
    //只要接口中存在实体类 或 返回值时实体类 那么这个接口中的实体类就会被扫描到swagger
    @GetMapping(value = "/t1")
    public User get(){
        return new User();
    }

    @ApiOperation("这是控制类方法注释")
    @GetMapping(value = "/t2")
    public User get1( String name){
        return new User();
    }

}
