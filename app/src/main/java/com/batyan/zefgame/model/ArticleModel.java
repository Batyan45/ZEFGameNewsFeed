package com.batyan.zefgame.model;

import java.io.Serializable;

public final class ArticleModel implements Serializable {

    private int id;
    private String title;
    private String pubDate;
    private String link;
    private String author;
    private String description;
    private String text;

    public ArticleModel(int id, String title, String pubDate, String link, String description, String author, String text) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.description = description;
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArticleModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
