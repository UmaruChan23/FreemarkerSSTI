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
    private Configuration con;

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
        stringLoader.putTemplate("hello.ftl", getTemplate(auth));
        con.setTemplateLoader(new MultiTemplateLoader(new TemplateLoader[]{stringLoader,
                con.getTemplateLoader()}));
        return "hello";
    }

    private String getTemplate(Authentication auth) {
        return
        "<html>\n" +
                "<head> " +
                "<title>Справочник</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            margin: 0; /* Убираем отступы */\n" +
                "            height: 100%; /* Высота страницы */\n" +
                "        }\n" +
                "\n" +
                "        .main_container {\n" +
                "            position: absolute;\n" +
                "            left: 50%;\n" +
                "            top: 1%;\n" +
                "            transform: translate(-50%, -50%);\n" +
                "        }\n" +
                "        .video {\n" +
                "            position: absolute;\n" +
                "            left: 50%;\n" +
                "            top: 50%;\n" +
                "            transform: translate(-50%, -50%);\n" +
                "        }\n" +
                "\n" +
                "        .top-nav {\n" +
                "            overflow: hidden;\n" +
                "            background-color: #333;\n" +
                "        }\n" +
                "\n" +
                "        .top-nav a {\n" +
                "            float: left;\n" +
                "            color: #f2f2f2;\n" +
                "            text-align: center;\n" +
                "            padding: 14px 16px;\n" +
                "            text-decoration: none;\n" +
                "            font-size: 17px;\n" +
                "        }\n" +
                "\n" +
                "        .top-nav a:hover {\n" +
                "            background-color: #ddd;\n" +
                "            color: black;\n" +
                "        }\n" +
                "\n" +
                "        .top-nav a.active {\n" +
                "            background-color: #04AA6D;\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Время взбодриться, " + service.getNickname(auth.getName()) + "!</h1>\n" +
                "<div class=\"main_container\">\n" +
                "    <div class=\"top-nav\">\n" +
                "        <sec:authorize access=\"isAuthenticated()\">\n" +
                "            <a href=\"/logout\">Выйти</a>\n" +
                "        </sec:authorize>\n" +
                "        <a href=\"/\">Главная</a>\n" +
                "        <a href=\"/news\">Форум</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<div class=\"video\">\n" +
                "  <video src=\"videoplayback\" width=\"100%\" height=\"100%\" type=\"video/mp4\" \"autoplay=\"autoplay\"" +
                "controls=\"controls\">\t\n" +
                " \t\t</video>\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";
    }

    @ExceptionHandler
    public String exceptionHandler() {
        return "redirect:/";
    }
}