package com.backendvulnerabilities.ssti.controller;

import com.backendvulnerabilities.ssti.service.UserService;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    private  Configuration con;

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("object", con.getObjectWrapper());
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("hello.ftl", "Hello ");
        con.setTemplateLoader(new MultiTemplateLoader(new TemplateLoader[]{stringLoader,
                con.getTemplateLoader()}));
        return "hello";
    }

    @ExceptionHandler
    public String exceptionHandler(){
        return "redirect:/";
    }
}