package br.com.springboot.thymeleaf.exemplothymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController
{
    @RequestMapping("/")
    public String Index(){
        return "Start";
    }
}
