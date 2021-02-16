package net.maple.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
    /**
     * 员工列表
     */
    @GetMapping("/emps")
    public String list(){
        return "emp/list";
    }
}
