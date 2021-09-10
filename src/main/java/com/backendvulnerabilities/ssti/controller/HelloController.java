package com.backendvulnerabilities.ssti.controller;

import com.backendvulnerabilities.ssti.service.UserService;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("object", con.getObjectWrapper());
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        File file = null;
        try {
            file = new ClassPathResource("images/maj-litl-poni-4.jpg").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringLoader.putTemplate("hello.ftl",
                "<html>\n" +
                "<body>\n"+
                "<img src=\"https://smolteddy.ru/wp-content/uploads/2019/04/maj-litl-poni-4.jpg\"/>" +
                        "<h1>Привет " + auth.getName() + "! Рад приветствовать тебя на моей PonyWiki</h1>\n" +
                "</body>\n" +
                "</html>");
        con.setTemplateLoader(new MultiTemplateLoader(new TemplateLoader[]{stringLoader,
                con.getTemplateLoader()}));
        return "hello";
    }

    @ExceptionHandler
    public String exceptionHandler(){
        return "redirect:/";
    }
}