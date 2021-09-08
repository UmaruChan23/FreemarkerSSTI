package com.backendvulnerabilities.ssti.service;

import com.backendvulnerabilities.ssti.entity.Item;
import com.backendvulnerabilities.ssti.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public List<Item> allItems() {
        return newsRepository.findAll();
    }

    public void saveItem(String name, String text) {

        newsRepository.save(new Item(name, text));
    }
}
