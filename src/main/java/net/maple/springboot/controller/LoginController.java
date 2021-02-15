package net.maple.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    /**
     * 登录判断
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model){
        if("admin".equals(username)&&"123".equals(password)){
            session.setAttribute("loginUsername",username);
            return "redirect:/index.html";
        }else if(!"admin".equals(username)){
            model.addAttribute("msgUsername","用户名错误");
            return "login";
        }else{
            model.addAttribute("msgPassword","密码错误");
            return "login";
        }
    }
}
