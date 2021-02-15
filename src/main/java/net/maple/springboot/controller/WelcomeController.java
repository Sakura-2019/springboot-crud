package net.maple.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 初始页
 */
@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String welcomePage(){
        return "login";
    }
}
