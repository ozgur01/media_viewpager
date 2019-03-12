package com.example.asynctask;

import java.util.List;

public class Product {

    private String title;
    private List<Media> mediaList;

    public Product(String title, List<Media> mediaList)
    {
        this.title = title;
        this.mediaList = mediaList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }
}
