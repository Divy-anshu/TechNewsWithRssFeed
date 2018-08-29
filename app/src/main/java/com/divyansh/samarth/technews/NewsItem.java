package com.divyansh.samarth.technews;

/**
 * Created by Divyansh on 23-03-2018.
 */

public class NewsItem {
    private String title;
    private String link;
    private String description;
    private String img;

    public NewsItem(String title, String link, String description, String img) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }
}
