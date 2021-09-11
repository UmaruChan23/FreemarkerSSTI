package com.backendvulnerabilities.ssti.controller;

import com.backendvulnerabilities.ssti.entity.Item;
import com.backendvulnerabilities.ssti.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("allItems", newsService.allItems());
        return "news";
    }

    @PostMapping
    public String addPost(@RequestParam(required = true, defaultValue = "" ) String text) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!text.equals("")){
            newsService.saveItem(auth.getName(), text);
        }
        return "redirect:/news";
    }

}
