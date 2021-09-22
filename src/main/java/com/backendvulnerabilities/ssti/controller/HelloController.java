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
                "  <video src=\"https://redirector.googlevideo.com/" +
                "videoplayback?expire=1632348640&ei=gFVLYczOEMPL7gSCw" +
                "pyoDg&ip=2a06%3Ac006%3A7f1e%3A256%3A647d%3Ac0fa%3Ad0" +
                "07%3A33c&id=o-ABSjZ_8cMQK0AGT9sRq9s5Yj-dt9HFAfI1_J15" +
                "aucQ5Z&itag=18&source=youtube&requiressl=yes&mh=Dr&m" +
                "m=31%2C29&mn=sn-4pvgq-n8vs%2Csn-n8v7knee&ms=au%2Crdu" +
                "&mv=m&mvi=2&pl=32&initcwndbps=330000&vprv=1&mime=vid" +
                "eo%2Fmp4&ns=p_sRUxR5z7yrwUbDQrxeC7kG&gir=yes&clen=25" +
                "03681&ratebypass=yes&dur=32.624&lmt=1558544872154815" +
                "&mt=1632326698&fvip=10&fexp=24001373%2C24007246&c=WE" +
                "B&txp=5431432&n=JQ_yYWgzM-YfCsQM&sparams=expire%2Cei" +
                "%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmim" +
                "e%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparam" +
                "s=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&ls" +
                "ig=AG3C_xAwRQIhAO42H7NekuiLRHj65lbUhGXvESdsGlOOTskVn" +
                "5sIZ9vrAiA3rZBstrLuSfH5BSrq7tuiaf1KrmCaSebY1nPsNx3b1" +
                "A%3D%3D&sig=AOq0QJ8wRAIgZjaf1YCEL3ZNXkb87jdp3G3Ud_qJ" +
                "f6E1Mh90kk19XtkCIGGVZtt8c8P2Stm_O4ean4hVNvORSbTYJVNx" +
                "6k_Iy9BU&title=drujba-eto-cudo-zastavka-my-little-po" +
                "ny-theme-song_(videomega.ru)\" width=\"100%\" height=\"100%\" type=\"video/mp4\" \"autoplay=\"autoplay\"" +
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