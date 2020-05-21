package com.batyan.zefgame.repository.resources.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ArticleDB {

    @PrimaryKey
    public int id;

    public String text;
    public String title;
    public String description;
    public String link;
    public String author;
    public String pubDate;

    public static ArticleDB create(int id, String title, String pubDate,
                                   String link, String description, String category, String text) {
        final ArticleDB result = new ArticleDB();
        result.id = id;
        result.text = text;
        result.title = title;
        result.description = description;
        result.pubDate = pubDate;
        result.link = link;
        result.author = category;
        return result;
    }
}
