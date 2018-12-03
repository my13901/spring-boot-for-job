package com.test.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.demo.entity.User;
import com.test.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController implements  WebMvcConfigurer {
    @Resource
    IUserService userService;

    @GetMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }

    @PostMapping("/add")
    public String add(@Valid User user, BindingResult result,Model model){
        if(result.hasErrors()){
              model.addAttribute("message",result.getFieldError().getDefaultMessage());
              return "user/add";
        }
        userService.save(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> list = userService.list();
        model.addAttribute("users",list);
        return "user/list";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        userService.delete(id);
        return "redirect:/list";
    }

}
