package com.backendvulnerabilities.ssti.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_news")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @Column(columnDefinition = "text")
    String text;

    public Item(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
