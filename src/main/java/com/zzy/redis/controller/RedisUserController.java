package com.zzy.redis.controller;


import com.zzy.redis.entity.RedisUser;
import com.zzy.redis.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedisUserController {
    @Autowired
    private RedisUserService userService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users",userService.selectList());
        return "listuser";
    }
    @RequestMapping("/del")
    public String del(RedisUser user){
        System.out.println(user);
        userService.del(user);
        return "redirect:/list";
    }
    @RequestMapping("/updateUser")
    public String updateby(RedisUser user, Integer number, Model model){
        model.addAttribute("user",user);
        model.addAttribute("number",number);
        return "edit";
    }
    @RequestMapping("/update")
    public String update(RedisUser user, Integer number){
        userService.update(user,number);
        return "redirect:/list";
    }
    @RequestMapping("/add")
    public String add(){
        return "/adduser";
    }
    @RequestMapping("/addUser")
    public String addone(RedisUser user){
        userService.add(user);
        return "redirect:/list";
    }
}
